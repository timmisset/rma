import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.model.ProjectDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProjectControllerIT extends AbstractControllerIT<ProjectDto> {
    public static final String PROJECT = "my project";

    private final ProjectDto projectDto = new ProjectDto().name(PROJECT);

    public ProjectControllerIT() {
        super("/project", ProjectDto.class);
    }

    @BeforeEach
    void setUp() {
        removeAll();
    }

    @Test
    void testAddProject() {
        assertNotNull(add(projectDto).getId());
    }

    @Test
    void testUpdateProject() {
        ProjectDto myProject = add(projectDto);
        myProject.setName("new name");
        ProjectDto response = update(myProject.getId(), myProject);

        assertEquals("new name", response.getName());
    }

    @Test
    void testGetProject() {
        ProjectDto project = add(projectDto);
        ProjectDto result = get(project.getId());
        assertEquals(PROJECT, result.getName());
        assertEquals(project.getId(), result.getId());
    }

    @Test
    void testGetProjects() {
        add(projectDto);
        add(new ProjectDto().name("Another project"));
        add(new ProjectDto().name("A third project"));

        List<ProjectDto> projects = getAll("/projects");

        assertEquals(3, projects.size());
    }
}
