package com.beadando.service;

import com.beadando.model.User;
//interface készítése metódusoknak
public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}