package com.github.andylke.demo.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ktcmaai.sandbox.demo.user.User;
import ktcmaai.sandbox.demo.user.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

  @Autowired
  private UserRepository repository;

  @GetMapping(params = { "nationality" })
  public Page<User> findAllByNationality(Pageable pageable, @RequestParam String nationality) {
    return repository.findAllByNationality(pageable, nationality);
  }

  @GetMapping(params = { "username" })
  public Optional<User> findByUsername(@RequestParam String username) {
    return repository.findByUsername(username);
  }
}
