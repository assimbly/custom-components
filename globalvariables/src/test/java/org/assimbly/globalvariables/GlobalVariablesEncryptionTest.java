package org.assimbly.globalvariables;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GlobalVariablesEncryptionTest {

    private static GlobalVariablesProcessor processor;

    @BeforeClass
    public static void setup(){
        processor = new GlobalVariablesProcessor();
    }


    @Test
    public void runTest() throws IOException {

        String encrypted = processor.encrypt("Value 1");

        String decrypted = processor.decrypt(encrypted);

        assertEquals("Value 1", decrypted);
    }

}
