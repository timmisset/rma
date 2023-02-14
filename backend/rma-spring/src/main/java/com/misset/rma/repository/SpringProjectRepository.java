package com.misset.rma.repository;

import com.misset.rma.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringProjectRepository extends JpaRepository<Project, String>, ProjectRepository {
}
