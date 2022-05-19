package capstone.interback.service.cover_letter;

import capstone.interback.domain.cover_letter.CoverLetterRepository;
import capstone.interback.web.dto.CoverLetterSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CoverLetterService {

    private final CoverLetterRepository coverLetterRepository;

    @Transactional
    public Long save(CoverLetterSaveRequestDto requestDto){
        return coverLetterRepository.save(requestDto.toEntity()).getId();
    }
}
