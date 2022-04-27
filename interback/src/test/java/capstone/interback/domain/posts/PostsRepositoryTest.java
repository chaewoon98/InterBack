package capstone.interback.domain.posts;

import capstone.interback.domain.PostsRepository;
import capstone.interback.domain.Posts;
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
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }
    
    @Test
    public void 미팅룸저장_불러오기(){
        //given
        String title = "테스트 미팅룸";
        String content = "테스트 미팅룸 콘텐트";

        postsRepository.save(Posts.builder().title(title) //id값 있으면 update, 없으면 insert 쿼리 실행
                .content(content)
                .master("woonie")
                .build());
        
        //when
        List<Posts> postsList = postsRepository.findAll(); //posts 테이블 모든 데이터 조회
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        
    }
}
