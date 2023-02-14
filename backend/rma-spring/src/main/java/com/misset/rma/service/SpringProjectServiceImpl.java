package com.misset.rma.service;

import com.misset.rma.repository.ProjectRepository;
import com.misset.rma.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringProjectServiceImpl extends ProjectServiceImpl {

    @Autowired
    protected SpringProjectServiceImpl(ProjectRepository projectRepository,
                                       ResourceService resourceService) {
        super(projectRepository, resourceService);
    }
}
