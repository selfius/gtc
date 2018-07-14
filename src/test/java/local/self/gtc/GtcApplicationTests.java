package local.self.gtc;

import local.self.gtc.model.User;
import local.self.gtc.model.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GtcApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        userRepository.save(new User("someName",123));
    }

}
