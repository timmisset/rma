package com.misset.rma.mapper;

import com.misset.rma.model.Project;
import com.misset.rma.model.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper extends RmaEntityMapper<Project, ProjectDto> {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
}
