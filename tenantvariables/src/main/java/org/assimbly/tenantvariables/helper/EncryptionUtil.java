package org.assimbly.tenantvariables.helper;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public final class EncryptionUtil {

    private final StandardPBEStringEncryptor textEncryptor = new StandardPBEStringEncryptor();
    private static final int SALT_LENGTH = 16; // Length of the salt in bytes
    private static final int IV_LENGTH = 12; // Length of the GCM IV in bytes
    private static final int GCM_TAG_LENGTH_BITS = 128;
    private static final String GCM_MARKER = "GCM";
    private final String password;

    private static final SecureRandom secureRandom = new SecureRandom();

    public EncryptionUtil(String password, String algorithm) {
        this.password = password;
        this.textEncryptor.setPassword(password);
        this.textEncryptor.setAlgorithm(algorithm);
        this.textEncryptor.setIvGenerator(new RandomIvGenerator());
    }

    public StandardPBEStringEncryptor getTextEncryptor() {
        return textEncryptor;
    }

    public String encrypt(String plainText) {
        // If the value is already encrypted, do not encrypt again and return
        if (plainText.startsWith("ENC(") && plainText.endsWith(")")) {
            return plainText;
        }

        // Generate random salt
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);

        // Generate random IV
        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(iv);

        // Generate key from password and salt
        SecretKeySpec secretKey = new SecretKeySpec(generateKey(password, salt), "AES");

        // Encrypt the plain text
        byte[] encryptedBytes = encryptWithIv(secretKey, iv, plainText);

        // Encode the salt, IV, and encrypted text
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedSalt = encoder.encodeToString(salt);
        String encodedIv = encoder.encodeToString(iv);
        String encodedEncryptedText = encoder.encodeToString(encryptedBytes);

        // Concatenate and return
        return String.format("ENC(%s|%s|%s|%s)", GCM_MARKER, encodedSalt, encodedIv, encodedEncryptedText);
    }

    public String decrypt(String encryptedText) {
        // Validate and extract components
        if (!encryptedText.startsWith("ENC(") || !encryptedText.endsWith(")")) {
            throw new IllegalArgumentException("Invalid encrypted text format.");
        }

        String contents = encryptedText.substring(4, encryptedText.length() - 1);
        String[] parts = contents.split("\\|");

        Base64.Decoder decoder = Base64.getDecoder();

        // Current format: ENC(GCM|salt|iv|text)
        if (parts.length == 4 && GCM_MARKER.equals(parts[0])) {
            SecretKeySpec secretKey = new SecretKeySpec(generateKey(password, decoder.decode(parts[1])), "AES");
            return decryptWithIv(secretKey, decoder.decode(parts[2]), decoder.decode(parts[3]));
        }

        // Unmarked format: ENC(salt|iv|text)
        if (parts.length == 3) {
            SecretKeySpec secretKey = new SecretKeySpec(generateKey(password, decoder.decode(parts[0])), "AES");
            byte[] iv = decoder.decode(parts[1]);
            // Why: runtime (and gateway through it) briefly wrote AES/GCM without the marker; its 12-byte IV tells it apart from legacy AES/CBC.
            if (iv.length == IV_LENGTH) {
                return decryptWithIv(secretKey, iv, decoder.decode(parts[2]));
            }
            return decryptLegacyCbc(secretKey, iv, decoder.decode(parts[2]));
        }

        throw new IllegalArgumentException("Invalid encrypted text format.");
    }


    private byte[] generateKey(String password, byte[] salt) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256); // 10000 iterations, 256 bits
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return factory.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("Key generation failed.", e);
        }
    }

    private byte[] encryptWithIv(SecretKeySpec secretKey, byte[] iv, String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv));
            return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)); // Use UTF-8 encoding
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed.", e);
        }
    }

    private String decryptWithIv(SecretKeySpec secretKey, byte[] iv, byte[] encryptedBytes) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new GCMParameterSpec(GCM_TAG_LENGTH_BITS, iv));
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8); // Use UTF-8 encoding
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed.", e);
        }
    }

    // Why: values stored before the switch to GCM were encrypted with CBC and must stay decryptable. Never used to encrypt.
    @SuppressWarnings("java:S5542")
    private String decryptLegacyCbc(SecretKeySpec secretKey, byte[] iv, byte[] encryptedBytes) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed.", e);
        }
    }

}
