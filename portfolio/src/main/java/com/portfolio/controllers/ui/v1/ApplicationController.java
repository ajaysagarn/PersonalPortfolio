package com.portfolio.controllers.ui.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class ApplicationController {
	@GetMapping("/index")
    public String home() {
        return "home";
    }
}
