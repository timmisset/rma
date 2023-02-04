import com.misset.rma.RmaApplication;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RmaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AbstractControllerIT<T> {

    private final String resourcePath;
    private final Class<T> entityClass;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    public AbstractControllerIT(String resourcePath, Class<T> entityClass) {
        this.resourcePath = resourcePath;
        this.entityClass = entityClass;
    }

    protected T add(T dto) {
        return add(dto, resourcePath, entityClass);
    }

    protected <U> U add(U dto, String resourcePath, Class<U> entityClass) {
        HttpEntity<U> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<U> response = restTemplate.exchange(
                createURLWithPort(resourcePath),
                HttpMethod.POST,
                entity,
                entityClass);

        return response.getBody();
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    protected T get(String id) {
        return get(id, resourcePath, entityClass);
    }

    protected <U> U get(String id, String resourcePath, Class<U> entityClass) {
        HttpEntity<?> entity = new HttpEntity<>(null, headers);

        ResponseEntity<U> response = restTemplate.exchange(
                createURLWithPort(resourcePath + "/" + id),
                HttpMethod.GET,
                entity,
                entityClass);

        return response.getBody();
    }

    protected <U> List<U> getAll(String resourcePath) {
        HttpEntity<?> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List<U>> response = restTemplate.exchange(
                createURLWithPort(resourcePath),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    protected T update(String id, T dto) {
        return update(id, dto, resourcePath, entityClass);
    }

    protected <U> U update(String id, U dto, String resourcePath, Class<U> entityClass) {
        HttpEntity<U> entity = new HttpEntity<>(dto, headers);

        ResponseEntity<U> response = restTemplate.exchange(
                createURLWithPort(resourcePath + "/" + id),
                HttpMethod.PUT,
                entity,
                entityClass);
        return response.getBody();
    }

    protected void removeAll() {
        restTemplate.delete(createURLWithPort(resourcePath));
    }

}
