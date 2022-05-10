package capstone.interback.web.dto;

import capstone.interback.domain.room.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class RoomSaveRequestDto {
    private String title;
    private String content;
    private String master;

    @Builder
    public RoomSaveRequestDto(String title, String content, String master){
        this.title = title;
        this.content = content;
        this.master = master;
    }

    public Room toEntity(){
        return Room.builder()
                .title(title)
                .content(content)
                .master(master)
                .build();
    }
}
