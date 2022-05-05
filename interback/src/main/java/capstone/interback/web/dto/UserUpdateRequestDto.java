package capstone.interback.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto { //유저 정보 수정 Dto

    private String password;
    private String name;
    private String email;

    @Builder
    public UserUpdateRequestDto(String password, String name, String email) {
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
