package com.parking.example.parking.http.controllers.debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/debug")
public class DebugController {

    @GetMapping("/template")
    public String getView() {
        return "index";
    }

}
