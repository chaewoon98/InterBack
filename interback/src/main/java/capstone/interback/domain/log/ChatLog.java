package capstone.interback.domain.log;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class ChatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int room_id;

    @Column(length = 15, nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String log_chat;

//    @Column(nullable = false)
//    private LocalDateTime log_time;
}
