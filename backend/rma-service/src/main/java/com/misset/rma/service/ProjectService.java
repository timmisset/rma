package com.misset.rma.service;

import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectService extends AbstractRmaService<Project> {

    private final ResourceService resourceService;

    @Autowired
    protected ProjectService(ProjectRepository projectRepository,
                             ResourceService resourceService) {
        super(projectRepository);
        this.resourceService = resourceService;
    }

    @Override
    void validate(Project entityToSave) {
        // no validation implemented
    }

    @Override
    boolean canDelete(Project entityToDelete) {
        return true;
    }

    public void addResourcesById(String id, Collection<String> resourceIds) {
        repository.getReferenceById(id).addAllResources(getResources(resourceIds));
    }

    private Collection<Resource> getResources(Collection<String> resourceIds) {
        return resourceIds.stream()
                .map(resourceService::get)
                .toList();
    }

    public void updateResourcesById(String id, Collection<String> resourceIds) {
        repository.getReferenceById(id).setResources(getResources(resourceIds));
    }

}
