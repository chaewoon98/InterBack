package capstone.interback.domain.cover_letter;

import capstone.interback.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cover_letter")
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public CoverLetter(Long id, User user_id, String content) {
        this.id = id;
        this.user_id = user_id;
        this.content = content;
    }
}
