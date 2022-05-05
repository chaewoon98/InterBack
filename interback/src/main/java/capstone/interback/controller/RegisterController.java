package capstone.interback.controller;

import capstone.interback.web.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/register")
    public String Register(){
        log.info("register");
        return "ok";
    }

    @GetMapping("/register/dto")
    public UserDTO userDTO(@RequestParam("name") String name,
                           @RequestParam("id") String id) {
        return new UserDTO(name, id);
    }
}
