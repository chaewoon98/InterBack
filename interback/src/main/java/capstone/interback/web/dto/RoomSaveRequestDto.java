package capstone.interback.web.dto;

import capstone.interback.domain.room.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class RoomSaveRequestDto {
    private String title;
    private String master;

    @Builder
    public RoomSaveRequestDto(String title, String master){
        this.title = title;
        this.master = master;
    }

    public Room toEntity(){
        return Room.builder()
                .title(title)
                .master(master)
                .build();
    }
}
