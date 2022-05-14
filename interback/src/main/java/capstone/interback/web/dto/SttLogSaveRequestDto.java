package capstone.interback.web.dto;

import capstone.interback.domain.log.SttLog;
import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class SttLogSaveRequestDto {

    private Room room_id;
    private User user_id;
    private String log_text;
    private Date log_time;

    @Builder
    public SttLogSaveRequestDto(Room room_id, User user_id, String log_text, java.sql.Date log_time) {
        this.room_id = room_id;
        this.user_id = user_id;
        this.log_text = log_text;
        this.log_time = log_time;
    }

    public SttLog toEntity(){
        return SttLog.builder()
                .room_id(room_id)
                .user_id(user_id)
                .log_text(log_text)
                .log_time(log_time)
                .build();
    }
}
