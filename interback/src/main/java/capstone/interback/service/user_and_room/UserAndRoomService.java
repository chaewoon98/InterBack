package capstone.interback.service.user_and_room;

import capstone.interback.domain.user_and_room.UserAndRoomRepository;
import capstone.interback.web.dto.UserAndRoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAndRoomService {

    private final UserAndRoomRepository userAndRoomRepository;

    //미팅룸 입장시 user_id, room_id 저장
    public Long save(UserAndRoomSaveRequestDto requestDto) {
        return userAndRoomRepository.save(requestDto.toEntity()).getId();
    }
}
