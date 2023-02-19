package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EntityBaseTest {
    @Test
    void testNewInstanceCreatesId() {
        EntityBaseImpl entity = new EntityBaseImpl();
        assertNotNull(entity.getId());
    }

    private static class EntityBaseImpl extends EntityBase {
        public EntityBaseImpl() {

        }
    }

}
