package com.roshnet.apps.crud.controllers;

import com.roshnet.apps.crud.models.User;
import com.roshnet.apps.crud.services.UserDAOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertController {

  @Autowired
  private UserDAOService userDAOService;

  @GetMapping("/add")
  private String add() {
    User user = new User("roshnet2", "member");
    long newUserId = userDAOService.insert(user);
    return "New user created with ID " + newUserId;
  }

  @GetMapping("/role")
  private String getRole() {
    String role = userDAOService.getRoleByName("roshnet");
    System.out.println("[OK] Got query result: " + role);
    return role;
  }

}
