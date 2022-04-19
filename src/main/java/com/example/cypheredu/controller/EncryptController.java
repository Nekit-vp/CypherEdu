package com.example.cypheredu.controller;

import com.example.cypheredu.encryption.Encryption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EncryptController {

    private final Encryption encryption;

    @GetMapping("/caesar")
    public String md5(Map<String, Object> model){
        model.put("encrypt", "");
        model.put("decrypt", "");
        return "caesar";
    }

    @PostMapping("/caesar")
    public String getMD5E(@RequestParam String text,
                          @RequestParam String isEncrypt,
                          @RequestParam String number,
                          Map<String, Object> model){
        if (isEncrypt.equals("true")){
            model.put("encrypt", encryption.encrypt(text, Integer.parseInt(number)));
            model.put("decrypt", "");
        } else {
            model.put("decrypt", encryption.decrypt(text, Integer.parseInt(number)));
            model.put("encrypt", "");
        }
        return "caesar";
    }


}
