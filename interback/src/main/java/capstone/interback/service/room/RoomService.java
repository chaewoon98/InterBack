package capstone.interback.service.room;

import capstone.interback.domain.room.Room;
import capstone.interback.domain.room.RoomRepository;
import capstone.interback.web.dto.RoomResponseDto;
import capstone.interback.web.dto.RoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional
    public Long save(RoomSaveRequestDto requestDto){
        return roomRepository.save(requestDto.toEntity()).getId();
    }

    public RoomResponseDto findById(Long id){
        Room entity = roomRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 포스트가 없습니다. id = " + id));
        return new RoomResponseDto(entity);
    }
}
