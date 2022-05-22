package capstone.interback.web.dto;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import capstone.interback.domain.user_and_room.UserAndRoom;
import lombok.Getter;

@Getter
public class UserAndRoomResponseDto {

    private Long id;
    private User user;
    private Room room;

    public UserAndRoomResponseDto(UserAndRoom entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.room = entity.getRoom();
    }
}
