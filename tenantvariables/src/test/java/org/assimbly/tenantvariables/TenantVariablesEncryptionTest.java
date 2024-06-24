package org.assimbly.tenantvariables;

import org.abstractj.kalium.crypto.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.abstractj.kalium.NaCl.Sodium.CRYPTO_SECRETBOX_XSALSA20POLY1305_NONCEBYTES;

@PrepareForTest(TenantVariablesProcessor.class)
public class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;

    @BeforeAll
    public static void setup(){
        processor = new TenantVariablesProcessor();
        try (MockedStatic<System> mockedSystem = Mockito.mockStatic(System.class)) {
            mockedSystem.when(() -> System.getenv("ASSIMBLY_ENCRYPTION_SECRET")).thenReturn("assimblyassimblyassimblyassimbly");
        }
    }

    @Test
    public void runTest() throws IOException {

        byte[] nonce = new Random().randomBytes(CRYPTO_SECRETBOX_XSALSA20POLY1305_NONCEBYTES);
        byte[] encrypted = processor.encrypt("Value 1", nonce);
        String decrypted = processor.decrypt(encrypted, nonce);

        assertEquals("Value 1", decrypted);
    }

}