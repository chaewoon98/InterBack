package capstone.interback.domain.feedback;

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

    @Column(nullable = false)
    private int room_id;

    @Column(length = 15, nullable = false)
    private String user_id;

    @Column(nullable = false)
    private int positive;

    @Column(nullable = false)
    private int negative;

    @Column(nullable = false)
    private int neutral;

    //워드 클라우드 추가!
}
