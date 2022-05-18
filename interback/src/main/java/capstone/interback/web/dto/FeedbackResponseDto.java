package capstone.interback.web.dto;

import capstone.interback.domain.feedback.Feedback;
import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import lombok.Getter;

@Getter
public class FeedbackResponseDto {

    private Long id;
    private Room room_id;
    private User user_id;
    private int positive;
    private int negative;
    private int neutral;

    public FeedbackResponseDto(Feedback entity) {
        this.id = entity.getId();
        this.room_id = entity.getRoom_id();
        this.user_id = entity.getUser_id();
        this.positive = entity.getPositive();
        this.negative = entity.getNegative();
        this.neutral = entity.getNeutral();
    }
}
