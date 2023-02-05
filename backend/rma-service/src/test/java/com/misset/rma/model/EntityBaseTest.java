package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EntityBaseTest {

    private static final String MY_ENTITY = "my entity";
    private static final String MY_DESCRIPTION = "my description";
    private static final String ID = "id";

    @Test
    void testNewInstanceCreatesId() {
        EntityBaseImpl entity = new EntityBaseImpl();
        entity.setName(MY_ENTITY);
        entity.setDescription(MY_DESCRIPTION);

        assertEquals(MY_ENTITY, entity.getName());
        assertEquals(MY_DESCRIPTION, entity.getDescription());
        assertNotNull(entity.getId());
    }

    private static class EntityBaseImpl extends EntityBase {
        public EntityBaseImpl() {

        }

        public EntityBaseImpl(String id) {
            super(id);
        }
    }

}
