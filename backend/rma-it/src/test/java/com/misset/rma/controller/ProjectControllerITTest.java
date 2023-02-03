package com.misset.rma.controller;

import com.misset.rma.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProjectControllerITTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectControllerIT projectControllerIT;

    @Test
    void testClear() {
        // ARRANGE

        // ACT
        projectControllerIT.clear();

        // ASSERT
        verify(projectRepository).deleteAll();

    }
}
