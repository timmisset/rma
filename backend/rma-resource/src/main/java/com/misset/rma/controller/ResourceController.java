package com.misset.rma.controller;

import com.misset.rma.api.ResourceApi;
import com.misset.rma.api.ResourcesApi;
import com.misset.rma.service.ResourceService;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController implements ResourceApi, ResourcesApi {
    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public ResponseEntity<ResourceDto> addResource(ResourceDto resource) {
        return ResponseEntity.ok(resourceService.add(resource));
    }

    @Override
    public ResponseEntity<ResourceDto> updateResource(String id, ResourceDto resourceDto) {
        return ResponseEntity.ok(resourceService.update(id, resourceDto));
    }

    @Override
    public ResponseEntity<ResourceDto> getResource(String id) {
        return ResponseEntity.ok(resourceService.get(id));
    }

    @Override
    public ResponseEntity<List<ResourceDto>> getResources() {
        return ResponseEntity.ok(resourceService.getAll());
    }
}
