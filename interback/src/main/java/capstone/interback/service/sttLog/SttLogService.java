package capstone.interback.service.sttLog;

import capstone.interback.domain.log.SttLogRepository;
import capstone.interback.web.dto.SttLogSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SttLogService {

    private final SttLogRepository sttLogRepository;

    @Transactional
    private long save(SttLogSaveRequestDto requestDto){
        return sttLogRepository.save(requestDto.toEntity()).getId();
    }
}
