package capstone.interback.web;

import capstone.interback.service.room.RoomService;
import capstone.interback.web.dto.RoomResponseDto;
import capstone.interback.web.dto.RoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RoomApiController {

    private final RoomService roomService;

    @PostMapping("/api/v1/room")
    public Long save(@RequestBody RoomSaveRequestDto requestDto){
        return roomService.save(requestDto);
    }

    @GetMapping("/api/v1/room/{id}")
    public RoomResponseDto findById(@PathVariable Long id){
        return roomService.findById(id);
    }

//    @PutMapping("/api/v1/posts{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
//        return postsService.update(id, requestDto);
//    }


}
