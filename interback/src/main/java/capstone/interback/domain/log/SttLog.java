package capstone.interback.domain.log;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class SttLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @Column
    private String log_text;

    @Column
    private java.sql.Date log_time;

    @Builder
    public SttLog(Room room_id, User user_id, String log_text, Date log_time) {
        this.room_id = room_id;
        this.user_id = user_id;
        this.log_text = log_text;
        this.log_time = log_time;
    }
}
