package capstone.interback.web;

import capstone.interback.service.user.UserService;
import capstone.interback.web.dto.UserResponseDto;
import capstone.interback.web.dto.UserSaveRequestDto;
import capstone.interback.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://3.39.74.53:8080", allowCredentials = "true")
public class UserApiController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("/api/user")
    public Long register(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PutMapping("/api/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(id, requestDto);
    }

    @GetMapping("/api/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }
}
