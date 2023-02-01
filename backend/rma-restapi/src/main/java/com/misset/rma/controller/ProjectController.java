package com.misset.rma.controller;

import com.misset.rma.api.ProjectApi;
import com.misset.rma.api.ProjectsApi;
import com.misset.rma.mapper.ProjectMapper;
import com.misset.rma.mapper.ResourceMapper;
import com.misset.rma.model.Project;
import com.misset.rma.service.ProjectService;
import org.openapitools.model.ProjectDto;
import org.openapitools.model.ResourceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController implements ProjectApi, ProjectsApi {

    private final ProjectService service;

    private final ProjectMapper mapper;

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
        this.mapper = ProjectMapper.INSTANCE;
    }

    @Override
    public ResponseEntity<ProjectDto> addProject(ProjectDto projectDto) {
        Project addedProject = service.add(mapper.fromDto(projectDto));
        return ResponseEntity.ok(mapper.toDto(addedProject));
    }

    @Override
    public ResponseEntity<Void> addProjectResources(String id, List<String> requestBody) {
        service.addResourcesById(id, requestBody);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjectDto> updateProject(String id, ProjectDto projectDto) {
        Project updatedProject = service.update(id, mapper.fromDto(projectDto));
        return ResponseEntity.ok(mapper.toDto(updatedProject));
    }

    @Override
    public ResponseEntity<Void> updateProjectResources(String id, List<String> requestBody) {
        service.updateResourcesById(id, requestBody);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjectDto> getProject(String id) {
        return ResponseEntity.ok().body(mapper.toDto(service.get(id)));
    }

    @Override
    public ResponseEntity<List<ResourceDto>> getProjectResources(String id) {
        List<ResourceDto> resources = service.get(id).getResources()
                .stream()
                .map(ResourceMapper.INSTANCE::toDto)
                .toList();
        return ResponseEntity.ok().body(resources);
    }

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects() {
        List<ProjectDto> projects = service.getAll().stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok().body(projects);
    }
}
