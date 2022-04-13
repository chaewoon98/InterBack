package capstone.interback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InterviewListController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/interview-list")
    public String InterviewList(){
        log.info("interview-list");
        return "ok";
    }
}
