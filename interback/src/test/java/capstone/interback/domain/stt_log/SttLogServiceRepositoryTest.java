package capstone.interback.domain.stt_log;

import capstone.interback.domain.log.SttLog;
import capstone.interback.domain.log.SttLogRepository;
import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SttLogServiceRepositoryTest {

    @Autowired
    SttLogRepository sttLogRepository;

    @AfterEach
    public void cleanup() {
        sttLogRepository.deleteAll();
    }

    @Test
    public void 미팅룸저장_불러오기(){
        //given
        Room room = new Room("title1", "content1", "master1");
        User user = new User("test_id", "pw", "name", "email");
        Date date = new Date(System.currentTimeMillis());

        sttLogRepository.save(SttLog.builder().room_id(room) //id값 있으면 update, 없으면 insert 쿼리 실행
                .user_id(user)
                .log_text("log_text test")
                .log_time(date)
                .build());

        //when
        List<SttLog> sttLogList = sttLogRepository.findAll(); //posts 테이블 모든 데이터 조회

        //then
        SttLog sttLog = sttLogList.get(0);
        assertThat(sttLog.getLog_text()).isEqualTo("log_text test");
//        assertThat(sttLog.getRoom_id()).isEqualTo(room.getId());
    }
}
