package com.misset.rma.controller;

import com.misset.rma.api.ResourceApi;
import com.misset.rma.api.ResourcesApi;
import com.misset.rma.mapper.BookingMapper;
import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Resource;
import com.misset.rma.service.impl.BookingServiceImpl;
import com.misset.rma.service.impl.ResourceServiceImpl;
import org.openapitools.model.BookingDto;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController implements ResourceApi, ResourcesApi {
    private final ResourceServiceImpl resourceService;

    private final BookingServiceImpl bookingService;

    private final ResourceMapper mapper;

    @Autowired
    public ResourceController(ResourceServiceImpl resourceService,
                              BookingServiceImpl bookingService) {
        this.resourceService = resourceService;
        this.bookingService = bookingService;
        this.mapper = ResourceMapper.INSTANCE;
    }

    @Override
    public ResourceDto addResource(ResourceDto resourceDto) {
        Resource resource = resourceService.add(mapper.fromDto(resourceDto));
        return mapper.toDto(resource);
    }

    @Override
    public ResourceDto updateResource(String id, ResourceDto resourceDto) {
        Resource resource = resourceService.update(id, mapper.fromDto(resourceDto));
        return mapper.toDto(resource);
    }

    @Override
    public ResourceDto getResource(String id) {
        return mapper.toDto(resourceService.get(id));
    }

    @Override
    public List<BookingDto> getResourceBookings(String id) {
        return BookingMapper.INSTANCE.toDto(bookingService.getBookingsByResourceId(id));
    }

    @Override
    public List<ResourceDto> getResources() {
        return mapper.toDto(resourceService.getAll());
    }
}
