package team.java.auction.house.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping
public class LoginController {

    @GetMapping
    public Map<String, String> home() {
        Map<String, String> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
}
