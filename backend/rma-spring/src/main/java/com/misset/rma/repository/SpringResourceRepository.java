package com.misset.rma.repository;

import com.misset.rma.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringResourceRepository extends JpaRepository<Resource, String>, ResourceRepository {

}
