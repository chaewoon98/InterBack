package capstone.interback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/login")
    public String Login(){
        log.info("login");
        return "ok";
    }
}
