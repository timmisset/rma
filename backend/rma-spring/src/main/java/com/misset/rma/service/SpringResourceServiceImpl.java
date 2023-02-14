package com.misset.rma.service;

import com.misset.rma.repository.ResourceRepository;
import com.misset.rma.service.impl.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringResourceServiceImpl extends ResourceServiceImpl {

    @Autowired
    public SpringResourceServiceImpl(ResourceRepository resourceRepository) {
        super(resourceRepository);
    }
}
