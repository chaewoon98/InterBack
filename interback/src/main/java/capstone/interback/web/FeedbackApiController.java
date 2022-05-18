package capstone.interback.web;

import capstone.interback.service.feedback.FeedbackService;
import capstone.interback.web.dto.FeedbackResponseDto;
import capstone.interback.web.dto.FeedbackSaveRequestDto;
import capstone.interback.web.dto.RoomResponseDto;
import capstone.interback.web.dto.RoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FeedbackApiController {

    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public Long createFeedback(@RequestBody FeedbackSaveRequestDto requestDto){
        return feedbackService.save(requestDto);
    }

    @GetMapping("/feedback/{id}")
    public FeedbackResponseDto findById(@PathVariable Long id){
        return feedbackService.findById(id);
    }

}
