package capstone.interback.web.dto;

import capstone.interback.domain.feedback.Feedback;
import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FeedbackSaveRequestDto {

    private Room room_id;
    private User user_id;
    private int positive;
    private int negative;
    private int neutral;

    @Builder
    public FeedbackSaveRequestDto(Room room_id, User user_id, int positive, int negative, int neutral) {
        this.room_id = room_id;
        this.user_id = user_id;
        this.positive = positive;
        this.negative = negative;
        this.neutral = neutral;
    }

    public Feedback toEntity(){
        return Feedback.builder()
                .room_id(room_id)
                .user_id(user_id)
                .positive(positive)
                .negative(negative)
                .neutral(neutral)
                .build();
    }
}
