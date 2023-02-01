package com.misset.rma.service;

import com.misset.rma.model.Resource;
import com.misset.rma.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends AbstractRmaService<Resource> {
    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        super(resourceRepository);
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
