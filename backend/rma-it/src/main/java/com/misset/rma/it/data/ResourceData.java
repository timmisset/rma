package com.misset.rma.it.data;

import com.misset.rma.service.ResourceService;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceData extends ITDataLoader {

    private final ResourceService resourceService;

    @Autowired
    public ResourceData(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public void load() {
        ResourceDto resourceA = new ResourceDto().name("Resource A");
        resourceService.add(resourceA);
    }
}
