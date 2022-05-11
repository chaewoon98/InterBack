package capstone.interback.web.dto;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import capstone.interback.domain.user_and_room.UserAndRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAndRoomSaveRequestDto {

    private Long id;
    private Room room;
    private User user;

    @Builder
    public UserAndRoomSaveRequestDto(Long id, Room room, User user) {
        this.id = id;
        this.room = room;
        this.user = user;
    }

    public UserAndRoom toEntity(){
        return UserAndRoom.builder()
                .room(room)
                .user(user)
                .build();
    }
}
