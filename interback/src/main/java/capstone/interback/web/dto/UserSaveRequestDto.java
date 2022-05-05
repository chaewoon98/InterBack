package capstone.interback.web.dto;

import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String user_id;
    private String password;
    private String name;
    private String email;

    @Builder
    public UserSaveRequestDto(String user_id, String password, String name, String email) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public User toEntity(){
        return User.builder()
                .user_id(user_id)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
