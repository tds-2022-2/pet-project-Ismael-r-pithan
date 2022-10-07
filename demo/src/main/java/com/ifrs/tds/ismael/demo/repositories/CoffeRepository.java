package com.ifrs.tds.ismael.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifrs.tds.ismael.demo.models.Coffe;

public interface CoffeRepository extends JpaRepository<Coffe, UUID> {

}
