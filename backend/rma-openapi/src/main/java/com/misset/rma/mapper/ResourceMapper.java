package com.misset.rma.mapper;

import com.misset.rma.model.PatternDto;
import com.misset.rma.model.Resource;
import com.misset.rma.model.ResourceDto;
import com.misset.rma.model.availability.Pattern;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface ResourceMapper extends RmaEntityMapper<Resource, ResourceDto> {
    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    @ObjectFactory
    default Pattern createPattern(PatternDto patternDto) {
        return PatternFactory.createPattern(patternDto);
    }
}
