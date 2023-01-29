package com.misset.rma.service;

import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Resource;
import org.junit.jupiter.api.Test;
import org.openapitools.model.ResourceDto;

import static org.junit.jupiter.api.Assertions.*;

class ResourceMapperTest {

    public static final String MY_NAME = "my name";

    @Test
    void mapperIsNullSafe() {
        assertNull(ResourceMapper.INSTANCE.toDto(null));
        assertNull(ResourceMapper.INSTANCE.fromDto(null));
    }

    @Test
    void resourceToResourceDto() {
        Resource resource = new Resource();
        resource.setName(MY_NAME);

        ResourceDto resourceDto = ResourceMapper.INSTANCE.toDto(resource);
        assertEquals(MY_NAME, resourceDto.getName());
        assertEquals(resource.getId(), resourceDto.getId());
    }

    @Test
    void resourceDtoToResource() {
        ResourceDto resourceDto = new ResourceDto().name(MY_NAME);
        Resource resource = ResourceMapper.INSTANCE.fromDto(resourceDto);
        assertEquals(MY_NAME, resource.getName());
        assertNotNull(resource.getId());
    }
}
