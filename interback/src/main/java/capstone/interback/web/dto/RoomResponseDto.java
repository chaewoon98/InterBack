package capstone.interback.web.dto;

import capstone.interback.domain.room.Room;
import lombok.Getter;

@Getter
public class RoomResponseDto {

    private Long id;
    private String title;
    private String master;

    public RoomResponseDto(Room entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.master = entity.getMaster();
    }
}
