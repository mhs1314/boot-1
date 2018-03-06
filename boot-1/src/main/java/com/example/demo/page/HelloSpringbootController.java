package com.example.demo.page;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloSpringbootController {
	@RequestMapping("/index")
    public String index() {
        return "hello boot";
    }
}
