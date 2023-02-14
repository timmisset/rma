package com.misset.rma.service;

import com.misset.rma.model.Project;

import java.util.Collection;

public interface ProjectService extends RmaService<Project> {
    void addResourcesById(String id, Collection<String> resourceIds);

    void updateResourcesById(String id, Collection<String> resourceIds);
}
