package capstone.interback.service.user;

import capstone.interback.domain.user.UserRepository;
import capstone.interback.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getId();
    }
}
