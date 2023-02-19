package com.misset.rma.mapper;

import com.misset.rma.model.Booking;
import com.misset.rma.model.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper extends RmaEntityMapper<Booking, BookingDto> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
}
