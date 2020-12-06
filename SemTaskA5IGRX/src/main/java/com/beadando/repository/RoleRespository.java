package com.beadando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beadando.model.Role;
//adatbázis kapcsolat JpaRepo-n keresztül ami az application.propertiesben foglalt kapcsolódási adatokkal történik
@Repository("roleRepository")
public interface RoleRespository extends JpaRepository<Role, Integer> {

 Role findByRole(String role);
}