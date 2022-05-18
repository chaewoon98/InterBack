package capstone.interback.service.feedback;

import capstone.interback.domain.feedback.Feedback;
import capstone.interback.domain.feedback.FeedbackRepository;
import capstone.interback.domain.room.Room;
import capstone.interback.web.dto.FeedbackResponseDto;
import capstone.interback.web.dto.FeedbackSaveRequestDto;
import capstone.interback.web.dto.RoomResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public Long save(FeedbackSaveRequestDto requestDto){
        return feedbackRepository.save(requestDto.toEntity()).getId();
    }

    public FeedbackResponseDto findById(Long id){
        Feedback entity = feedbackRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 포스트가 없습니다. id = " + id));
        return new FeedbackResponseDto(entity);
    }
}
