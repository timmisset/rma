package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectTest {

    @Test
    void testAddResourceAddsResource() {
        // ARRANGE
        Resource resourceA = new Resource();
        Resource resourceB = new Resource();
        Project project = new Project();

        // ACT
        project.addResource(resourceA);
        project.addResource(resourceB);

        // ASSERT
        assertTrue(project.getResources().containsAll(List.of(resourceA, resourceB)));
    }

    @Test
    void testAddAllResourcesAddsAllResources() {
        // ARRANGE
        Resource resourceA = new Resource();
        Resource resourceB = new Resource();
        Project project = new Project();

        // ACT
        project.addAllResources(List.of(resourceA, resourceB));

        // ASSERT
        assertTrue(project.getResources().containsAll(List.of(resourceA, resourceB)));
    }

    @Test
    void testSetResourcesOverridesResources() {
        // ARRANGE
        Resource resourceA = new Resource();
        Resource resourceB = new Resource();
        Project project = new Project();
        project.addResource(resourceA);

        // ACT
        project.setResources(List.of(resourceB));

        // ASSERT
        assertFalse(project.getResources().contains(resourceA));
        assertTrue(project.getResources().contains(resourceB));

    }
}
