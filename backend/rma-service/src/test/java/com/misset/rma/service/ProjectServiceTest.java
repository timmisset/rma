package com.misset.rma.service;

import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    private static final String ID = "ID";
    private static final String RESOURCE_ID = "RESOURCE_ID";

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ResourceService resourceService;

    @InjectMocks
    ProjectService projectService;

    @Test
    void testCanDeleteReturnsTrue() {
        // ARRANGE

        // ACT
        assertTrue(projectService.canDelete(new Project()));

        // ASSERT

    }

    @Test
    void testAddResourcesById() {
        // ARRANGE
        Project project = new Project();
        Resource resource = new Resource();
        project.addResource(resource);

        Resource resource2 = new Resource();

        when(projectRepository.getReferenceById(ID)).thenReturn(project);
        when(resourceService.get(RESOURCE_ID)).thenReturn(resource2);

        // ACT
        projectService.addResourcesById(ID, List.of(RESOURCE_ID));

        // ASSERT
        assertTrue(project.getResources().contains(resource));
        assertTrue(project.getResources().contains(resource2));
    }

    @Test
    void testUpdateResourcesById() {
        // ARRANGE
        Project project = new Project();
        Resource resource = new Resource();
        project.addResource(resource);

        Resource resource2 = new Resource();

        when(projectRepository.getReferenceById(ID)).thenReturn(project);
        when(resourceService.get(RESOURCE_ID)).thenReturn(resource2);

        // ACT
        projectService.updateResourcesById(ID, List.of(RESOURCE_ID));

        // ASSERT
        assertFalse(project.getResources().contains(resource));
        assertTrue(project.getResources().contains(resource2));
    }
}
