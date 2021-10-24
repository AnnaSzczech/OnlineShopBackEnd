package team.java.auction.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends BasicResponse {

    @Autowired
    private UserService userService;

    @PostMapping
    public Response<UserEntity> createUser(@RequestBody UserEntity user) {
        user.setRole("ADMIN");
        return createOkResponse(userService.saveUser(user));
    }

    @GetMapping
    public UserEntity user(UserEntity user) {
        return user;
    }

    @GetMapping("/id")
    public String users(UserEntity user) {
        return "Test autentykacji!";
    }


}
