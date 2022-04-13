package capstone.interback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewHistoryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/interview-history")
    public String InterviewHistory(){
        log.info("interview-history");
        return "ok";
    }
}
