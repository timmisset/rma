package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbstractEntityTest {

    public static final String MY_ENTITY = "my entity";
    public static final String MY_DESCRIPTION = "my description";

    @Test
    void testNewInstanceCreatesId() {
        EntityImpl entity = new EntityImpl();
        entity.setName(MY_ENTITY);
        entity.setDescription(MY_DESCRIPTION);

        assertEquals(MY_ENTITY, entity.getName());
        assertEquals(MY_DESCRIPTION, entity.getDescription());
        assertNotNull(entity.getId());
    }

    private static class EntityImpl extends AbstractEntity {

    }

}
