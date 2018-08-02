package local.self.gtc.controller;

import local.self.gtc.model.PullRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PullRequestControllerTest {

    @Autowired
    EntityManagerFactory factory;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void checkSubmit() {
        ResponseEntity<Object> objectResponseEntity = restTemplate.
                postForEntity("http://localhost:" + port + "/pr/submit", new PullRequest(1), Object.class);
        assertThat(objectResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
