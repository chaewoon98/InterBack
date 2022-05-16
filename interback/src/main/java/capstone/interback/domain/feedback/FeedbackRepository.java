package capstone.interback.domain.feedback;

import capstone.interback.domain.log.SttLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}
