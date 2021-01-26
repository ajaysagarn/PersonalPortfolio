package com.portfolio.controllers.ui.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class ApplicationController {
	@GetMapping("/**")
    String home() {
        return "test.html";
    }
}
