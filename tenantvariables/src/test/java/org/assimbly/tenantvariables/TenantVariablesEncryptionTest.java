package org.assimbly.tenantvariables;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;

    @BeforeClass
    public static void setup(){
        processor = new TenantVariablesProcessor();
    }


    @Test
    public void runTest() throws IOException {

        String encrypted = processor.encrypt("Value 1");

        String decrypted = processor.decrypt(encrypted);

        assertEquals("Value 1", decrypted);
    }

}
