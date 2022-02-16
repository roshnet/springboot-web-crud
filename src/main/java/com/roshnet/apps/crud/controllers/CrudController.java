package com.roshnet.apps.crud.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.roshnet.apps.crud.models.User;
import com.roshnet.apps.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping("/all")
  private Object[] getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.toArray();
  }

  @GetMapping("/{id}")
  private String getUserById(@PathVariable long id) {
    Optional<User> users = userRepository.findById(id);
    return users.toString();
  }

  @PostMapping("/new")
  private String createNewUser() {
    String uuid = UUID.randomUUID().toString().substring(0, 12).replaceAll("-", "");
    User user = new User(uuid, "member");
    userRepository.save(user);
    return String.format("Created user %s ", uuid);
  }

}
