package capstone.interback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/intro")
    public String Intro(){
        log.info("intro");
        return "ok";
    }

    @GetMapping("/manual")
    public String Manual(){
        log.info("manual");
        return "ok";
    }
}
