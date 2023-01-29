package com.misset.rma.service;

import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Resource;
import com.misset.rma.repository.ResourceRepository;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends AbstractRmaService<Resource, ResourceDto> {
    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        super(resourceRepository, ResourceMapper.INSTANCE);
    }

    @Override
    void validate(Resource entityToSave) {
        // no validation implemented
    }

    @Override
    boolean canDelete(Resource entityToDelete) {
        return true;
    }
}
