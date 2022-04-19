package com.example.cypheredu.controller;

import com.example.cypheredu.hashing.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HashController {

    private final Hashing hashing;

    @GetMapping("/md5")
    public String md5(Map<String, Object> model){
        model.put("text", "");
        return "hash_md5";
    }

    @PostMapping("/md5")
    public String getMD5(@RequestParam String text, Map<String, Object> model){
        System.out.println(text);
        model.put("text", hashing.getHash(text));
        return "hash_md5";
    }
}
