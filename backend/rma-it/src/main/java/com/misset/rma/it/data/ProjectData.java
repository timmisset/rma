package com.misset.rma.it.data;

import com.misset.rma.service.ProjectService;
import com.misset.rma.service.ResourceService;
import org.openapitools.model.ProjectDto;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ProjectData extends ITDataLoader {

    private final ProjectService projectService;
    private final ResourceService resourceService;

    @Autowired
    ProjectData(ProjectService projectService, ResourceService resourceService) {
        this.projectService = projectService;
        this.resourceService = resourceService;
    }

    @Override
    public void load() {
        loadSimpleProject();
        loadProjectWithResources();
    }

    private void loadSimpleProject() {
        ProjectDto projectDto = new ProjectDto().name("Project A").description("Project A");
        projectService.add(projectDto);
    }

    private void loadProjectWithResources() {
        ProjectDto projectDto = new ProjectDto().name("Project B").description("project projectDto");
        ResourceDto resourceDto = new ResourceDto().name("Resource for Project B");
        ProjectDto addedProject = projectService.add(projectDto);
        ResourceDto addedResource = resourceService.add(resourceDto);
        projectService.updateResourcesById(addedProject.getId(), Collections.singleton(addedResource.getId()));
    }

}
