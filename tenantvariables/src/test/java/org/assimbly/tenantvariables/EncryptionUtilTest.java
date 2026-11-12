package org.assimbly.tenantvariables;

import org.assimbly.tenantvariables.helper.EncryptionUtil;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EncryptionUtilTest {

    private static final String PASSWORD = "test-secret";
    private static final String ALGORITHM = "PBEWithHMACSHA512AndAES_256";

    private final EncryptionUtil encryptionUtil = new EncryptionUtil(PASSWORD, ALGORITHM);

    @Test
    void encryptsWithGcmAndDecryptsAgain() {
        String encrypted = encryptionUtil.encrypt("Value 1");

        assertTrue(encrypted.startsWith("ENC(GCM|"));
        assertEquals("Value 1", encryptionUtil.decrypt(encrypted));
    }

    @Test
    void encryptingTwiceGivesDifferentCiphertext() {
        assertNotEquals(encryptionUtil.encrypt("Value 1"), encryptionUtil.encrypt("Value 1"));
    }

    @Test
    void doesNotEncryptAlreadyEncryptedValue() {
        String encrypted = encryptionUtil.encrypt("Value 1");

        assertEquals(encrypted, encryptionUtil.encrypt(encrypted));
    }

    @Test
    void decryptsLegacyCbcValue() throws Exception {
        assertEquals("Legacy value", encryptionUtil.decrypt(legacyCbcEncrypt("Legacy value")));
    }

    @Test
    void decryptsUnmarkedGcmValue() throws Exception {
        assertEquals("Unmarked value", encryptionUtil.decrypt(unmarkedGcmEncrypt("Unmarked value")));
    }

    @Test
    void rejectsTamperedGcmValue() {
        String encrypted = encryptionUtil.encrypt("Value 1");
        String[] parts = encrypted.substring(4, encrypted.length() - 1).split("\\|");
        byte[] cipherText = Base64.getDecoder().decode(parts[3]);
        cipherText[0] ^= 1;
        String tampered = "ENC(%s|%s|%s|%s)".formatted(parts[0], parts[1], parts[2], Base64.getEncoder().encodeToString(cipherText));

        assertThrows(RuntimeException.class, () -> encryptionUtil.decrypt(tampered));
    }

    @Test
    void rejectsInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> encryptionUtil.decrypt("plain"));
        assertThrows(IllegalArgumentException.class, () -> encryptionUtil.decrypt("ENC(a|b)"));
    }

    // Builds a value in the format written before the switch to GCM: ENC(salt|iv|text)
    private static String legacyCbcEncrypt(String plainText) throws Exception {
        byte[] salt = new byte[16];
        byte[] iv = new byte[16];
        PBEKeySpec spec = new PBEKeySpec(PASSWORD.toCharArray(), salt, 10000, 256);
        byte[] key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec).getEncoded();

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        Base64.Encoder encoder = Base64.getEncoder();
        return "ENC(%s|%s|%s)".formatted(encoder.encodeToString(salt), encoder.encodeToString(iv), encoder.encodeToString(encrypted));
    }

    // Builds a value in the format runtime wrote before it added the marker: AES/GCM as ENC(salt|iv|text)
    private static String unmarkedGcmEncrypt(String plainText) throws Exception {
        byte[] salt = new byte[16];
        byte[] iv = new byte[12];
        PBEKeySpec spec = new PBEKeySpec(PASSWORD.toCharArray(), salt, 10000, 256);
        byte[] key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(spec).getEncoded();

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        Base64.Encoder encoder = Base64.getEncoder();
        return "ENC(%s|%s|%s)".formatted(encoder.encodeToString(salt), encoder.encodeToString(iv), encoder.encodeToString(encrypted));
    }
}
