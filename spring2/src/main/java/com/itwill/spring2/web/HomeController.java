package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로거 객체를 자동으로 만들어줌
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        log.info("home()");
        
        return "index";
    }
    
    
}
