package capstone.interback.web;

import capstone.interback.service.cover_letter.CoverLetterService;
import capstone.interback.web.dto.CoverLetterSaveRequestDto;
import capstone.interback.web.dto.FeedbackSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CoverLetterApiController {

    CoverLetterService coverLetterService;

    @PostMapping("/coverletter")
    public Long saveCoverLetter(@RequestBody CoverLetterSaveRequestDto requestDto){
        return coverLetterService.save(requestDto);
    }
}
