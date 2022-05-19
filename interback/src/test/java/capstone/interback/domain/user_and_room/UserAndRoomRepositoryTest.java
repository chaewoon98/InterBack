package capstone.interback.domain.user_and_room;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserAndRoomRepositoryTest {

    @Autowired
    UserAndRoomRepository userAndRoomRepository;

    @AfterEach
    public void cleanup(){
        userAndRoomRepository.deleteAll();
    }

    @Test
    public void 유저및미팅룸_저장_불러오기(){
        //given
        Room room = new Room("title1", "master1");
        User user = new User("test_id", "pw", "name", "email");

        userAndRoomRepository.save(UserAndRoom.builder()
                .room(room)
                .user(user)
                .build());

        //when
        List<UserAndRoom> userAndRoomList = userAndRoomRepository.findAll(); //테이블 모든 데이터 조회

        //then
        UserAndRoom userAndRoom = userAndRoomList.get(0);
        assertThat(userAndRoom.getRoom().getTitle()).isEqualTo("title1");
        assertThat(userAndRoom.getUser().getUser_id()).isEqualTo("test_id");
    }
}
