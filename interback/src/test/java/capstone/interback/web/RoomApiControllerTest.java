package capstone.interback.web;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.room.RoomRepository;
import capstone.interback.web.dto.RoomSaveRequestDto;
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
public class RoomApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RoomRepository roomRepository;

    @AfterEach
    public void tearDown() throws Exception{
        roomRepository.deleteAll();
    }

    @Test
    public void Room_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        RoomSaveRequestDto requestDto = RoomSaveRequestDto.builder()
                .title(title)
                .content(content)
                .master("master")
                .build();

        String url = "http://localhost:" + port + "/api/v1/room";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Room> all = roomRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);

    }
}
