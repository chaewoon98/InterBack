package capstone.interback.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
    private Long id;

    @Column(length = 15, nullable = false)
    private String user_id;

    @Column(length = 25, nullable = false)
    private String password;

    @Column(length = 8, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String email;

    @Builder
    public User(String user_id, String password, String name, String email) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void update(String password, String name, String email){
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
