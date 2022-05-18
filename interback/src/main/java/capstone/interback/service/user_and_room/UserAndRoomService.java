package capstone.interback.service.user_and_room;

import capstone.interback.domain.user.User;
import capstone.interback.domain.user_and_room.UserAndRoom;
import capstone.interback.domain.user_and_room.UserAndRoomRepository;
import capstone.interback.web.dto.UserAndRoomResponseDto;
import capstone.interback.web.dto.UserAndRoomSaveRequestDto;
import capstone.interback.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserAndRoomService {

    private final UserAndRoomRepository userAndRoomRepository;

    //미팅룸 입장시 user_id, room_id 저장
    public Long save(UserAndRoomSaveRequestDto requestDto) {
        return userAndRoomRepository.save(requestDto.toEntity()).getId();
    }

    public UserAndRoomResponseDto findById(Long id){
        UserAndRoom entity = userAndRoomRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다. id = " + id));

        return new UserAndRoomResponseDto(entity);
    }

//    //유저별 미팅룸 리스트 조회 @@
//    public List<UserAndRoomResponseDto> findAllRoomById(String user_id){
//        return userAndRoomRepository.findAllRoomById(user_id).stream()
//                .map(UserAndRoomResponseDto::new)
//                .collect(Collectors.toList());
//    }
}
