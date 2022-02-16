package com.roshnet.apps.crud.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  @GetMapping("/home")
  private String index() {
    return "See docs for more info.";
  }
}
