package com.example.cypheredu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("main")
    public String main(Map<String, Object> model){
        return "index";
    }

    @GetMapping("hash")
    public String hach(Map<String, Object> model){
        return "hash";
    }

    @GetMapping("encode")
    public String encod(Map<String, Object> model){
        return "encode";
    }

    @GetMapping("encrypt")
    public String encrypt(Map<String, Object> model){
        return "encrypt";
    }

}
