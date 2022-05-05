package capstone.interback.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanup(){
        userRepository.deleteAll();
    }

    @Test
    public void 유저저장_불러오기(){
        //given
        String user_id = "id123";
        String password = "password123";
        String name = "name";
        String email = "email@email.com";

        userRepository.save(User.builder()
                .user_id(user_id)
                .password(password)
                .name(name)
                .email(email)
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getUser_id()).isEqualTo(user_id);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
    }
}
