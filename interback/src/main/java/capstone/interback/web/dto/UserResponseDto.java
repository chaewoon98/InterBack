package capstone.interback.web.dto;

import capstone.interback.domain.user.User;

public class UserResponseDto {

    private Long id;
    private String user_id;
    private String password;
    private String name;
    private String email;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.user_id = entity.getUser_id();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }
}
