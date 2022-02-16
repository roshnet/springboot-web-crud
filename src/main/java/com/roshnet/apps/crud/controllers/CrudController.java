package com.roshnet.apps.crud.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.roshnet.apps.crud.models.User;
import com.roshnet.apps.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CrudController {

  @Autowired
  private UserRepository userRepository;

  private String generateRandomName() {
    return UUID.randomUUID().toString().substring(0, 12).replaceAll("-", "");
  }

  @GetMapping("")
  private List<User> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  @GetMapping("/{id}")
  private String getUserById(@PathVariable long id) {
    Optional<User> users = userRepository.findById(id);
    return users.toString();
  }

  @PostMapping("")
  private String createNewUser() {
    User user = new User(generateRandomName(), "member");
    userRepository.save(user);
    return String.format("Created user %s ", user.getName());
  }

  @DeleteMapping("/{id}")
  private String removeUserById(@PathVariable long id) {
    Optional<User> user = userRepository.findById(id);
    if (!user.isPresent()) return "No such user found";
    User foundUser = user.get();
    userRepository.delete(foundUser);
    return String.format("Deleted user %s", foundUser.getName());
  }

  @PostMapping("/{id}")
  private String updateUser(@PathVariable long id) {
    Optional<User> savedUser = userRepository.findById(id);
    if (!savedUser.isPresent()) return "No such user found";
    User user = savedUser.get();
    String oldUsername = user.getName();
    user.setName(generateRandomName());
    userRepository.save(user);
    return String.format("User %s updated to %s", oldUsername, user.getName());
  }

}
