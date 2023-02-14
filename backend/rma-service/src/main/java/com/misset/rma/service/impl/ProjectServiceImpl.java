package com.misset.rma.service.impl;

import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.repository.ProjectRepository;
import com.misset.rma.service.ProjectService;
import com.misset.rma.service.ResourceService;

import java.util.Collection;

public class ProjectServiceImpl extends AbstractRmaService<Project> implements ProjectService {

    private final ResourceService resourceService;

    protected ProjectServiceImpl(ProjectRepository projectRepository,
                                 ResourceService resourceService) {
        super(projectRepository);
        this.resourceService = resourceService;
    }

    @Override
    public void addResourcesById(String id, Collection<String> resourceIds) {
        Project project = repository.getReferenceById(id);
        project.addAllResources(getResources(resourceIds));
        update(id, project);
    }

    private Collection<Resource> getResources(Collection<String> resourceIds) {
        return resourceIds.stream()
                .map(resourceService::get)
                .toList();
    }

    @Override
    public void updateResourcesById(String id, Collection<String> resourceIds) {
        Project project = repository.getReferenceById(id);
        project.setResources(getResources(resourceIds));
        update(id, project);
    }

}
