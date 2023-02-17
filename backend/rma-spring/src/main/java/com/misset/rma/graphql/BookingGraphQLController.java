package com.misset.rma.graphql;

import com.misset.rma.model.Booking;
import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.service.BookingService;
import com.misset.rma.service.ProjectService;
import com.misset.rma.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Example of using GraphQL instead of REST
 * at localhost:8080/graphql run POST
 * {
 * bookings {
 * id
 * project {
 * name
 * }
 * resource {
 * id
 * }
 * }
 * }
 */
@Controller
public class BookingGraphQLController {
    private final BookingService bookingService;
    private final ResourceService resourceService;
    private final ProjectService projectService;

    @Autowired
    public BookingGraphQLController(BookingService bookingService,
                                    ResourceService resourceService,
                                    ProjectService projectService) {
        this.bookingService = bookingService;
        this.resourceService = resourceService;
        this.projectService = projectService;
        Resource resource = new Resource();
        resource.setName("my graphql resource");
        resourceService.add(resource);

        Project project = new Project();
        project.setName("my graphql project");
        projectService.add(project);

        Booking booking = new Booking();
        booking.setProject(project.getId());
        booking.setResource(resource.getId());
        booking.setFromDateTime(ZonedDateTime.now());
        bookingService.add(booking);

        booking = new Booking();
        booking.setProject(project.getId());
        booking.setResource(resource.getId());
        booking.setFromDateTime(ZonedDateTime.now().plus(1, ChronoUnit.DAYS));
        bookingService.add(booking);
    }

    @QueryMapping
    public List<Booking> bookings() {
        return bookingService.getAll();
    }

    @SchemaMapping
    public Resource resource(Booking booking) {
        return resourceService.get(booking.getResource());
    }

    @SchemaMapping
    public Project project(Booking booking) {
        return projectService.get(booking.getProject());
    }
}
