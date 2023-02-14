package com.misset.rma.mapper;

import com.misset.rma.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.ProjectDto;

@Mapper
public interface ProjectMapper extends RmaEntityMapper<Project, ProjectDto> {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
}
