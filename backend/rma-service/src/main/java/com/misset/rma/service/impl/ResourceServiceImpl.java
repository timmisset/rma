package com.misset.rma.service.impl;

import com.misset.rma.model.Resource;
import com.misset.rma.repository.ResourceRepository;
import com.misset.rma.service.ResourceService;

public class ResourceServiceImpl extends AbstractRmaService<Resource> implements ResourceService {
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        super(resourceRepository);
    }
}
