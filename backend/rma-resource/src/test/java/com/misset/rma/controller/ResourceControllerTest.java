package com.misset.rma.controller;

import com.misset.rma.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.ResourceDto;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourceControllerTest {

    public static final String NAME = "my name";
    @Mock
    ResourceService service;

    @InjectMocks
    ResourceController controller;

    @Test
    void addResourceCallsService() {
        ResourceDto inputDto = new ResourceDto().name(NAME);
        ResourceDto savedDto = new ResourceDto().name(NAME);
        when(service.add(inputDto)).thenReturn(savedDto);

        ResponseEntity<ResourceDto> resourceDtoResponseEntity = controller.addResource(inputDto);
        assertEquals(savedDto, resourceDtoResponseEntity.getBody());
    }
}
