package capstone.interback.domain.room;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @Column(name = "room_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String master;

    @Builder
    public Room(String title, String content, String master){
        this.title = title;
        this.content = content;
        this.master = master;
    }
}
