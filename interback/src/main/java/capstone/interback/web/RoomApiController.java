package capstone.interback.web;

import capstone.interback.service.room.RoomService;
import capstone.interback.service.user_and_room.UserAndRoomService;
import capstone.interback.web.dto.RoomResponseDto;
import capstone.interback.web.dto.RoomSaveRequestDto;
import capstone.interback.web.dto.UserAndRoomResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RoomApiController {

    private final RoomService roomService;
    private final UserAndRoomService userAndRoomService;

    @PostMapping("/api/room")
    public Long createRoom(@RequestBody RoomSaveRequestDto requestDto){
        return roomService.save(requestDto);
    }

    @GetMapping("/api/room/{id}")
    public RoomResponseDto findById(@PathVariable Long id){
        return roomService.findById(id);
    }

//    @PutMapping("/api/v1/posts{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
//        return postsService.update(id, requestDto);
//    }

}
