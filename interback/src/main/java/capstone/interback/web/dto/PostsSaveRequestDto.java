package capstone.interback.web.dto;

import capstone.interback.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String master;

    @Builder
    public PostsSaveRequestDto(String title, String content, String master){
        this.title = title;
        this.content = content;
        this.master = master;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .master(master)
                .build();
    }
}
