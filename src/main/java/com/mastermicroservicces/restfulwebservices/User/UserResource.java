package com.mastermicroservicces.restfulwebservices.User;

import org.springframework.web.bind.annotation.*;

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
        return service.findOne(id);
    }

    // POST / users
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }
}
