package com.misset.rma.mapper;

import com.misset.rma.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.ResourceDto;

@Mapper
public interface ResourceMapper extends RmaEntityMapper<Resource, ResourceDto> {
    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);
}
