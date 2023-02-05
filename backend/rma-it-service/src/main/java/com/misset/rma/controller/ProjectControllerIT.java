package com.misset.rma.controller;

import com.misset.rma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectControllerIT {

    private final ProjectRepository repository;

    @Autowired
    public ProjectControllerIT(ProjectRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping(value = "/project")
    public void clear() {
        repository.deleteAll();
    }

}
