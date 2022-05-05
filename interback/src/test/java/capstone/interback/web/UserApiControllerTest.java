package capstone.interback.web;

import capstone.interback.domain.user.User;
import capstone.interback.domain.user.UserRepository;
import capstone.interback.web.dto.UserSaveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void tearDown() throws Exception{
        userRepository.deleteAll();
    }

    @Test
    public void User_등록된다() throws Exception{
        //given
        String user_id = "user_id123";
        String password = "password123";
        String name = "name";
        String email = "email@email.com";
        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .user_id(user_id)
                .password(password)
                .name(name)
                .email(email)
                .build();

        String url = "http://localhost:" + port + "/api/user";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> all = userRepository.findAll();
        assertThat(all.get(0).getUser_id()).isEqualTo(user_id);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getEmail()).isEqualTo(email);


    }

}
