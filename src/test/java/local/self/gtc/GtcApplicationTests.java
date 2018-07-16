package local.self.gtc;

import local.self.gtc.model.Balance;
import local.self.gtc.repository.BalanceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GtcApplicationTests {

    @Autowired
    BalanceRepository userRepository;

    @Autowired
    EntityManagerFactory factory;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/gtc/someuser",
                Balance.class)).isEqualTo(new Balance("someuser",2));
    }

}
