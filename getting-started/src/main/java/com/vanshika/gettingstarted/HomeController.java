package com.vanshika.gettingstarted;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path="/home")
    public String home(){
        return "HOME";
    }
}
