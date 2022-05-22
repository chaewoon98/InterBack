package capstone.interback.domain.cover_letter;

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
public class CoverLetterRepositoryTest {

    @Autowired
    CoverLetterRepository coverLetterRepository;

    @AfterEach
    public void cleanup(){
        coverLetterRepository.deleteAll();
    }

    @Test
    public void 자소서_저장불러오기(){
        //given
        User user_id = new User("userid", "pw123", "name", "email");
        String content = "content test 123";

        coverLetterRepository.save(CoverLetter.builder()
                .user_id(user_id)
                .content(content)
                .build());

        //when
        List<CoverLetter> coverLetterList = coverLetterRepository.findAll(); //테이블 모든 데이터 조회

        //then
        CoverLetter coverLetter = coverLetterList.get(0);
        assertThat(coverLetter.getContent()).isEqualTo("content test 123");

    }
}
