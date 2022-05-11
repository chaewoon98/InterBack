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
public class UserAndRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;

    @Builder
    public UserAndRoom(Long id, Room room, User user) {
        this.id = id;
        this.room = room;
        this.user = user;
    }
}
