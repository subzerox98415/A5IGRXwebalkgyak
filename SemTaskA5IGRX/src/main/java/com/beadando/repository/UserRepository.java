package com.beadando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beadando.model.User;
//adatbázis kapcsolat JpaRepo-n keresztül ami az application.propertiesben foglalt kapcsolódási adatokkal történik
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>  {
 
 User findByEmail(String email);
}