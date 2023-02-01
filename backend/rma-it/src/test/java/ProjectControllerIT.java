import com.misset.rma.RmaApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.model.ProjectDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RmaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProjectControllerIT {
    public static final String PROJECT = "my project";
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        removeAll();
    }

    private void removeAll() {
        restTemplate.delete(createURLWithPort("/project"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    void testAddProject() {
        assertNotNull(addProject(PROJECT).getId());
    }

    private ProjectDto addProject(String name) {
        ProjectDto myProject = new ProjectDto().name(name);
        HttpEntity<ProjectDto> entity = new HttpEntity<>(myProject, headers);

        ResponseEntity<ProjectDto> response = restTemplate.exchange(
                createURLWithPort("/project"),
                HttpMethod.POST,
                entity,
                ProjectDto.class);

        return response.getBody();
    }

    @Test
    void testUpdateProject() {
        ProjectDto myProject = addProject(PROJECT);
        myProject.setName("new name");
        ProjectDto response = updateProject(myProject.getId(), myProject);

        assertEquals("new name", response.getName());
    }

    private ProjectDto updateProject(String id, ProjectDto projectDto) {
        HttpEntity<ProjectDto> entity = new HttpEntity<>(projectDto, headers);

        ResponseEntity<ProjectDto> response = restTemplate.exchange(
                getProjectWithIdEndpoint(id),
                HttpMethod.PUT,
                entity,
                ProjectDto.class);
        return response.getBody();
    }

    private String getProjectWithIdEndpoint(String id) {
        return createURLWithPort("/project/" + id);
    }

    @Test
    void testGetProject() {
        ProjectDto project = addProject(PROJECT);
        ProjectDto result = getProject(project.getId());
        assertEquals(PROJECT, result.getName());
        assertEquals(project.getId(), result.getId());
    }

    private ProjectDto getProject(String id) {
        HttpEntity<?> entity = new HttpEntity<>(null, headers);

        ResponseEntity<ProjectDto> response = restTemplate.exchange(
                getProjectWithIdEndpoint(id),
                HttpMethod.GET,
                entity,
                ProjectDto.class);

        return response.getBody();
    }

    @Test
    void testGetProjects() {
        addProject(PROJECT);
        addProject("Another project");
        addProject("A third project");

        List<ProjectDto> projects = getProjects();

        assertEquals(3, projects.size());
    }

    private List<ProjectDto> getProjects() {
        HttpEntity<?> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List<ProjectDto>> response = restTemplate.exchange(
                createURLWithPort("/projects"),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }
}
