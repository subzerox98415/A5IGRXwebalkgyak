package com.beadando.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beadando.model.Prod;
//adatbázis kapcsolat JpaRepo-n keresztül ami az application.propertiesben foglalt kapcsolódási adatokkal történik
@Repository
public interface ProdRepository extends JpaRepository<Prod, Long>{

}
