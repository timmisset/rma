package com.misset.rma.controller;

import com.misset.rma.api.ProjectApi;
import com.misset.rma.api.ProjectsApi;
import com.misset.rma.mapper.ResourceMapper;
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

    @Autowired
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ProjectDto> addProject(ProjectDto projectDto) {
        return ResponseEntity.ok(service.add(projectDto));
    }

    @Override
    public ResponseEntity<Void> addProjectResources(String id, List<String> requestBody) {
        service.addResourcesById(id, requestBody);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjectDto> updateProject(String id, ProjectDto projectDto) {
        return ResponseEntity.ok(service.update(id, projectDto));
    }

    @Override
    public ResponseEntity<Void> updateProjectResources(String id, List<String> requestBody) {
        service.updateResourcesById(id, requestBody);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProjectDto> getProject(String id) {
        return ResponseEntity.ok().body(service.get(id));
    }

    @Override
    public ResponseEntity<List<ResourceDto>> getProjectResources(String id) {
        List<ResourceDto> resourceDtos = service.getAsType(id).getResources()
                .stream()
                .map(ResourceMapper.INSTANCE::toDto)
                .toList();
        return ResponseEntity.ok().body(resourceDtos);
    }

    @Override
    public ResponseEntity<List<ProjectDto>> getProjects() {
        return ResponseEntity.ok(service.getAll());
    }
}
