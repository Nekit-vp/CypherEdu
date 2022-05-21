package com.example.cypheredu.controller;

import com.example.cypheredu.hashing.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HashController {

    @Qualifier("md5")
    @Autowired
    private Hashing hashingMD5;

    @Qualifier("sha1")
    @Autowired
    private Hashing hashingSHA1;

    @Qualifier("sha256")
    @Autowired
    private Hashing hashingSHA256;

    @GetMapping("/md5")
    public String md5(Map<String, Object> model){
        model.put("text", "");
        return "hash_md5";
    }

    @PostMapping("/md5")
    public String getMD5(@RequestParam String text, Map<String, Object> model){
        System.out.println(text);
        model.put("text", hashingMD5.getHash(text));
        return "hash_md5";
    }

    @GetMapping("/sha")
    public String sha1(Map<String, Object> model){
        model.put("sha1", "");
        model.put("sha2", "");
        return "hash_sha";
    }

    @PostMapping("/sha")
    public String getSHA1(@RequestParam String text,
                          @RequestParam String isFirstForm,
                          Map<String, Object> model){
        if (isFirstForm.equals("true")){
            boolean cyrillic = text.chars()
                    .mapToObj(Character.UnicodeBlock::of)
                    .anyMatch(b -> b.equals(Character.UnicodeBlock.CYRILLIC));
            if (!cyrillic) {
                model.put("sha1", hashingSHA1.getHash(text));
            }else {
                model.put("sha1", "Only latin alphabet");
            }
            model.put("sha2", "");
        } else {
            model.put("sha2", hashingSHA256.getHash(text));
            model.put("sha1", "");
        }
        return "hash_sha";
    }
}
