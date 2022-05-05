package capstone.interback.service.user;

import capstone.interback.domain.user.User;
import capstone.interback.domain.user.UserRepository;
import capstone.interback.web.dto.UserResponseDto;
import capstone.interback.web.dto.UserSaveRequestDto;
import capstone.interback.web.dto.UserUpdateRequestDto;
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
    
    //유저 정보 수정
    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto){ 
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id = " + id));
    
        user.update(requestDto.getPassword(), requestDto.getName(), requestDto.getEmail());
        
        return id;
    }
    
    //유저 정보 조회
    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다. id = " + id));
        
        return new UserResponseDto(entity);
    }
}
