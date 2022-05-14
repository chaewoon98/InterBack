package capstone.interback.domain.feedback;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import capstone.interback.domain.user_and_room.UserAndRoom;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @Column(nullable = false)
    private int positive;

    @Column(nullable = false)
    private int negative;

    @Column(nullable = false)
    private int neutral;

    //워드 클라우드 추가!
}
