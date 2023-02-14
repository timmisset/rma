package com.misset.rma.mapper;

import com.misset.rma.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.BookingDto;

@Mapper
public interface BookingMapper extends RmaEntityMapper<Booking, BookingDto> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
}
