// package com.example.restservice.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.restservice.model.User;
// import com.example.restservice.services.UserService;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/users")
// public class UserController {
// @Autowired
// private UserService userService;

// @PostMapping
// public User createUser(@RequestBody User user) {
// return userService.creatUser(user);
// }

// @GetMapping
// List<User> getAllUsers() {
// return userService.getAllUsers();
// }

// @GetMapping("/{id}")
// public Optional<User> getUserById(@PathVariable Long id) {
// return userService.getUserById(id);
// }

// @PutMapping("/{id}")
// public User updateUser(@PathVariable Long id, @RequestBody User userDetails)
// {
// return userService.updateUser(id, userDetails);
// }
// }
