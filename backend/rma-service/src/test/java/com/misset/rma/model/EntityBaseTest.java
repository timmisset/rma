package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EntityBaseTest {

    public static final String MY_ENTITY = "my entity";
    public static final String MY_DESCRIPTION = "my description";

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

    }

}
