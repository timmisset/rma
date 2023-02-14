package com.misset.rma.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ResourceServiceImplTest {

    @InjectMocks
    ResourceServiceImpl resourceService;

    @Test
    void testCreatesService() {
        assertNotNull(resourceService);
    }

}
