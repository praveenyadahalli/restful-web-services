package com.mastermicroservicces.restfulwebservices.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // GET / users
    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }

    // GET / user by Id
    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable int id){
        User user=service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("Id:"+id);
        return user;
    }

    // POST / users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
