import org.junit.jupiter.api.Test;
import org.openapitools.model.BookingDto;
import org.openapitools.model.ProjectDto;
import org.openapitools.model.ResourceDto;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BookingControllerIT extends AbstractControllerIT<BookingDto> {

    public BookingControllerIT() {
        super("/booking", BookingDto.class);
    }

    @Test
    void testAddsBookingAndRetrievesViaResource() {
        // GIVEN
        // A project and resource
        ResourceDto resourceDto = add(new ResourceDto(), "/resource", ResourceDto.class);
        ProjectDto projectDto = add(new ProjectDto(), "/project", ProjectDto.class);

        // WHEN
        // A booking is added
        BookingDto bookingDto = new BookingDto().resource(resourceDto.getId())
                .project(projectDto.getId())
                .fromDateTime(ZonedDateTime.now());
        BookingDto add = add(bookingDto);

        // THEN
        // The booking can be retrieved via the Resource
        String resourcePath = String.format("/resource/%s/bookings", resourceDto.getId());
        List<BookingDto> bookings = getAll(resourcePath);

        assertFalse(bookings.isEmpty());
    }

}
