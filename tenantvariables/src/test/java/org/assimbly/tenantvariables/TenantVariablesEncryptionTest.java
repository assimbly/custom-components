package org.assimbly.tenantvariables;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TenantVariablesProcessor.class})
public class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;

    @BeforeAll
    public static void setup(){
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getenv("ASSIMBLY_ENCRYPTION_SECRET")).thenReturn("assimblyassimblyassimblyassimbly");
        processor = new TenantVariablesProcessor();
    }

    @Test
    public void runTest() throws IOException {
        byte[] nonce = new Random().randomBytes(CRYPTO_SECRETBOX_XSALSA20POLY1305_NONCEBYTES);
        byte[] encrypted = processor.encrypt("Value 1", nonce);
        String decrypted = processor.decrypt(encrypted, nonce);

        assertEquals("Value 1", decrypted);
    }

}
