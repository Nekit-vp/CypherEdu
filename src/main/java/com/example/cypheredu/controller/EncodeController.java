package com.example.cypheredu.controller;

import com.example.cypheredu.encoding.Encoding;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class EncodeController {

    private final Encoding encoding;

    @GetMapping("/base64")
    public String md5(Map<String, Object> model){
        model.put("encode", "");
        model.put("decode", "");
        return "base64";
    }

    @PostMapping("/base64")
    public String getMD5E(@RequestParam String text,
                          @RequestParam String isEncode,
                          Map<String, Object> model){
        if (isEncode.equals("true")){
            model.put("encode", encoding.encode(text.getBytes(StandardCharsets.UTF_8)));
            model.put("decode", "");
        } else {
            model.put("decode", new String(encoding.decode(text), StandardCharsets.UTF_8));
            model.put("encode", "");
        }
        return "base64";
    }
}
