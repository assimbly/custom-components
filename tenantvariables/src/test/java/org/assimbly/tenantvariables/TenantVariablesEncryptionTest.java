package org.assimbly.tenantvariables;

import org.abstractj.kalium.crypto.Random;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;

import static org.abstractj.kalium.NaCl.Sodium.CRYPTO_SECRETBOX_XSALSA20POLY1305_NONCEBYTES;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TenantVariablesProcessor.class})
public class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;

    @BeforeClass
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
