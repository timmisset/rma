package com.misset.rma.mapper;

import com.misset.rma.model.Resource;
import org.junit.jupiter.api.Test;
import org.openapitools.model.ResourceDto;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RmaEntityMapperTest {

    public static final String MY_NAME = "my name";

    @Test
    void testSingleToSingleDto() {
        Resource resource = new Resource();
        resource.setName(MY_NAME);

        ResourceDto resourceDto = ResourceMapper.INSTANCE.toDto(resource);
        assertEquals(MY_NAME, resourceDto.getName());
        assertEquals(resource.getId(), resourceDto.getId());
    }

    @Test
    void testSingleDtoToSingle() {
        ResourceDto resourceDto = new ResourceDto().name(MY_NAME);
        Resource resource = ResourceMapper.INSTANCE.fromDto(resourceDto);
        assertEquals(MY_NAME, resource.getName());
        assertNotNull(resource.getId());
    }

    @Test
    void testMultipleToMultipleDto() {
        assertEquals(1, ResourceMapper.INSTANCE.toDto(Collections.singleton(new Resource())).size());
    }

    @Test
    void testMultipleDtoToMultiple() {
        assertEquals(1, ResourceMapper.INSTANCE.fromDto(Collections.singleton(new ResourceDto())).size());
    }
}
