package com.regmi.users.controller;

import com.regmi.users.exception.UserNotFoundException;
import com.regmi.users.service.UserService;
import com.regmi.users.util.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class userController {
    private UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userEntity.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody UserEntity userEntity,@PathVariable int id){
        userEntity.setId(id);
        userService.saveUser(userEntity);

        return ResponseEntity.ok(userEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        if (userService.getUserById(id)==null){
            throw new UserNotFoundException("No User with -"+id);
        }
        userService.deleteUser(id);
    }
    @GetMapping("/query")
    public UserEntity getUserByName(@RequestParam (value="name")String name){
        return userService.getUserByName(name);
    }
}
