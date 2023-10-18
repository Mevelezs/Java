package com.ecomerce.java;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class HolaMundo {

  @GetMapping("hello")
  public static String Hello (){
    return "Hello World";
  }
}
