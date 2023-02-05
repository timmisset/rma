package com.misset.rma.controller;

import com.misset.rma.api.ResourceApi;
import com.misset.rma.api.ResourcesApi;
import com.misset.rma.mapper.BookingMapper;
import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Resource;
import com.misset.rma.service.BookingService;
import com.misset.rma.service.ResourceService;
import org.openapitools.model.BookingDto;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController implements ResourceApi, ResourcesApi {
    private final ResourceService resourceService;

    private final BookingService bookingService;

    private final ResourceMapper mapper;

    @Autowired
    public ResourceController(ResourceService resourceService,
                              BookingService bookingService) {
        this.resourceService = resourceService;
        this.bookingService = bookingService;
        this.mapper = ResourceMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<ResourceDto> addResource(ResourceDto resourceDto) {
        Resource resource = resourceService.add(mapper.fromDto(resourceDto));
        return ResponseEntity.ok(mapper.toDto(resource));
    }

    @Override
    public ResponseEntity<ResourceDto> updateResource(String id, ResourceDto resourceDto) {
        Resource resource = resourceService.update(id, mapper.fromDto(resourceDto));
        return ResponseEntity.ok(mapper.toDto(resource));
    }

    @Override
    public ResponseEntity<ResourceDto> getResource(String id) {
        return ResponseEntity.ok(mapper.toDto(resourceService.get(id)));
    }

    @Override
    public ResponseEntity<List<BookingDto>> getResourceBookings(String id) {
        return ResponseEntity.ok(BookingMapper.INSTANCE.toDto(bookingService.getBookingsByResourceId(id)));
    }

    @Override
    public ResponseEntity<List<ResourceDto>> getResources() {
        return ResponseEntity.ok(mapper.toDto(resourceService.getAll()));
    }
}
