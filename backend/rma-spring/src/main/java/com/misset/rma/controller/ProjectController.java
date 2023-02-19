package com.misset.rma.controller;

import com.misset.rma.api.ProjectApi;
import com.misset.rma.api.ProjectsApi;
import com.misset.rma.mapper.ProjectMapper;
import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Project;
import com.misset.rma.model.ProjectDto;
import com.misset.rma.model.ResourceDto;
import com.misset.rma.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController implements ProjectApi, ProjectsApi {

    private final ProjectServiceImpl service;

    private final ProjectMapper mapper;

    @Autowired
    public ProjectController(ProjectServiceImpl service) {
        this.service = service;
        this.mapper = ProjectMapper.INSTANCE;
    }

    @Override
    public ProjectDto addProject(ProjectDto projectDto) {
        Project addedProject = service.add(mapper.fromDto(projectDto));
        return mapper.toDto(addedProject);
    }

    @Override
    public void addProjectResources(String id, List<String> requestBody) {
        service.addResourcesById(id, requestBody);
    }

    @Override
    public ProjectDto updateProject(String id, ProjectDto projectDto) {
        Project updatedProject = service.update(id, mapper.fromDto(projectDto));
        return mapper.toDto(updatedProject);
    }

    @Override
    public void updateProjectResources(String id, List<String> requestBody) {
        service.updateResourcesById(id, requestBody);
    }

    @Override
    public ProjectDto getProject(String id) {
        return mapper.toDto(service.get(id));
    }

    @Override
    public List<ResourceDto> getProjectResources(String id) {
        return ResourceMapper.INSTANCE.toDto(service.get(id).getResources());
    }

    @Override
    public List<ProjectDto> getProjects() {
        return mapper.toDto(service.getAll());
    }
}
