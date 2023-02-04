package com.misset.rma.service;

import com.misset.rma.model.Resource;
import com.misset.rma.repository.BookingRepository;
import com.misset.rma.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends AbstractRmaService<Resource> {
    private final BookingRepository bookingRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository,
                           BookingRepository bookingRepository) {
        super(resourceRepository);
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Resource get(String id) {
        return super.get(id);
    }
}
