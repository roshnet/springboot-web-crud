package net.guides.springboot.todomanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import net.guides.springboot.todomanagement.service.ITodoService;

@Controller
public class TodoController {
  @Autowired
  private ITodoService todoService;

  @InitBinder
  public void initBinder(WebDataBinder binder){
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }


}
