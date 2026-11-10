package org.assimbly.tenantvariables.domain;

import org.bson.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TenantVariableTest {

    @Test
    void documentRoundTripKeepsAllFields() {
        EnvironmentValue test = new EnvironmentValue("test");
        test.setValue("ENC(GCM|a|b|c)");
        test.setEncrypted(true);
        test.setLastUpdate(1234L);
        test.setUpdatedBy("flow1");

        TenantVariable variable = new TenantVariable("Var1");
        variable.setProtectedValue(true);
        variable.setCreatedAt(99L);
        variable.setCreatedBy("System");
        variable.put(test);

        TenantVariable restored = TenantVariable.fromDocument(variable.toDocument());

        assertEquals(variable.getId(), restored.getId());
        assertEquals("Var1", restored.getName());
        assertEquals(TenantVariable.TenantVarType.TENANT_VARIABLE.getType(), restored.getType());
        assertTrue(restored.isProtectedValue());
        assertEquals(99L, restored.getCreatedAt());
        assertEquals("System", restored.getCreatedBy());

        EnvironmentValue restoredValue = restored.find("test").orElseThrow();
        assertEquals(test.getId(), restoredValue.getId());
        assertEquals("ENC(GCM|a|b|c)", restoredValue.getValue());
        assertTrue(restoredValue.isEncrypted());
        assertEquals(1234L, restoredValue.getLastUpdate());
        assertEquals("flow1", restoredValue.getUpdatedBy());
    }

    @Test
    void fromDocumentAcceptsIntegerCreatedAt() {
        Document document = new TenantVariable("Var1").toDocument();
        document.put(TenantVariable.CREATED_AT_FIELD, 42);

        assertEquals(42L, TenantVariable.fromDocument(document).getCreatedAt());
    }

    @Test
    void findMatchesOnEnvironmentName() {
        TenantVariable variable = new TenantVariable("Var1");
        variable.put(new EnvironmentValue("test"));

        assertTrue(variable.find("test").isPresent());
        assertFalse(variable.find("prod").isPresent());
        assertFalse(variable.find(null).isPresent());
    }
}
