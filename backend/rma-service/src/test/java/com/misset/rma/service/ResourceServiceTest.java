package com.misset.rma.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ResourceServiceTest {

    @InjectMocks
    ResourceService resourceService;

    @Test
    void testCreatesService() {
        assertNotNull(resourceService);
    }

}
