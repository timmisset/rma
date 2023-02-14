package com.misset.rma.controller;

import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.ProjectDto;
import org.openapitools.model.ResourceDto;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

    public static final String ID = "id";
    @Mock
    ProjectServiceImpl service;

    @InjectMocks
    ProjectController projectController;

    @Test
    void testAddProjectCreatesProject() {
        when(service.add(any(Project.class))).thenAnswer(invocation -> invocation.getArguments()[0]);
        ProjectDto projectDto = projectController.addProject(new ProjectDto());

        assertNotNull(projectDto);
        verify(service).add(any(Project.class));
    }

    @Test
    void testAddProjectResourcesAddsResources() {
        String resourceA = "resourceA";
        String resourceB = "resourceB";
        List<String> resourceIds = Arrays.asList(resourceA, resourceB);
        projectController.addProjectResources(ID, resourceIds);

        verify(service).addResourcesById(ID, resourceIds);
    }

    @Test
    void testUpdateProjectUpdatesProject() {
        when(service.update(eq(ID), any(Project.class))).thenAnswer(invocation -> invocation.getArguments()[1]);
        ProjectDto projectDto = projectController.updateProject(ID, new ProjectDto());

        assertNotNull(projectDto);
        verify(service).update(eq(ID), any(Project.class));
    }

    @Test
    void testUpdateProjectResourcesUpdatesResources() {
        String resourceA = "resourceA";
        String resourceB = "resourceB";
        List<String> resourceIds = Arrays.asList(resourceA, resourceB);
        projectController.updateProjectResources(ID, resourceIds);

        verify(service).updateResourcesById(ID, resourceIds);
    }

    @Test
    void testGetProjectReturnsProjectById() {
        when(service.get(ID)).thenReturn(new Project());

        assertNotNull(projectController.getProject(ID));
    }

    @Test
    void testGetProjectResources() {
        Project project = new Project();
        project.addAllResources(Arrays.asList(new Resource(), new Resource()));

        when(service.get(ID)).thenReturn(project);

        List<ResourceDto> resourceDtos = projectController.getProjectResources(ID);
        assertEquals(2, resourceDtos.size());
    }

    @Test
    void getProjectsReturnsAllProjects() {
        when(service.getAll()).thenReturn(Arrays.asList(new Project(), new Project()));
        assertEquals(2, projectController.getProjects().size());
    }
}
