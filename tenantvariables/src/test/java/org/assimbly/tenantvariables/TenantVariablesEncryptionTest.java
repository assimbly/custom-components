package org.assimbly.tenantvariables;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;


    @BeforeAll
    static void setup() {
        processor = new TenantVariablesProcessor();
    }

    /*
    @Test
    void runTest() {

        String encrypted = processor.encrypt("Value 1");

        String decrypted = processor.decrypt(encrypted);

        assertEquals("Value 1", decrypted);
    }*/

}