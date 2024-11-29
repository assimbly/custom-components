package org.assimbly.tenantvariables;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenantVariablesEncryptionTest {

    private static TenantVariablesProcessor processor;


    @BeforeAll
    public static void setup() {
        processor = new TenantVariablesProcessor();
    }

    @Test
    public void runTest() throws IOException {

        String encrypted = processor.encrypt("Value 1");

        String decrypted = processor.decrypt(encrypted);

        assertEquals("Value 1", decrypted);
    }

}