package capstone.interback.service.feedback;

import capstone.interback.domain.feedback.FeedbackRepository;
import capstone.interback.web.dto.FeedbackSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class Feedback {

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public Long save(FeedbackSaveRequestDto requestDto){
        return feedbackRepository.save(requestDto.toEntity()).getId();
    }
}
