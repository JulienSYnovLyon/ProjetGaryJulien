package com.project.springproject.controller;

import com.project.springproject.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.springproject.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{idUsers}", method = RequestMethod.GET)
    public User get(@PathVariable(name = "idUsers") Long idUsers) {
        return userService.getUserById(idUsers);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User createOrUpdate(@RequestBody User user) {
        return userService.createOrUpdate(user);
    }
}
