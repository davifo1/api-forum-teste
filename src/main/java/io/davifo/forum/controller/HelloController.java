package io.davifo.forum.controller;

import io.davifo.forum.controller.dto.UserDto;
import io.davifo.forum.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World! XD";
    }

    @RequestMapping("/users")
    public List<UserDto> users() {
        ArrayList<UserDto> l = new ArrayList<>();
        l.add(new UserDto("Davifo", "davifox@icloud.com"));
        l.add(new UserDto("Maria", "maria@icloud.com"));
        return l;
    }
}
