package capstone.interback.domain.user_and_room;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_and_room")
public class UserAndRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public UserAndRoom(Long id, Room room, User user) {
        this.id = id;
        this.room = room;
        this.user = user;
    }
}
