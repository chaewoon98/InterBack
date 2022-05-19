package capstone.interback.web.dto;

import capstone.interback.domain.cover_letter.CoverLetter;
import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoverLetterSaveRequestDto {

    private User user_id;
    private String content;

    @Builder
    public CoverLetterSaveRequestDto(User user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }

    public CoverLetter toEntity(){
        return CoverLetter.builder()
                .user_id(user_id)
                .content(content)
                .build();
    }
}
