package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DescribedEntityBaseTest {

    private static final String MY_ENTITY = "my entity";
    private static final String MY_DESCRIPTION = "my description";
    private static final String ID = "id";

    @Test
    void testNewInstanceCreatesId() {
        DescribedEntityBase entityBase = new DescribedEntityBase() {
        };

        entityBase.setName(MY_ENTITY);
        entityBase.setDescription(MY_DESCRIPTION);

        assertEquals(MY_ENTITY, entityBase.getName());
        assertEquals(MY_DESCRIPTION, entityBase.getDescription());
        assertNotNull(entityBase.getId());
    }
}
