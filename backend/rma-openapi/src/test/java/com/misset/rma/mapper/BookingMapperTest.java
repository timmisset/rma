package com.misset.rma.mapper;

import com.misset.rma.model.Booking;
import com.misset.rma.model.BookingDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingMapperTest {

    @Test
    void testSetsIdViaConstructor() {
        String id = "id";
        Booking booking = BookingMapper.INSTANCE.fromDto(new BookingDto().id(id));
        assertEquals(id, booking.getId());
    }

}
