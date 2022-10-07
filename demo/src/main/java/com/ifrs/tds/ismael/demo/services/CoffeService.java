package com.ifrs.tds.ismael.demo.services;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ifrs.tds.ismael.demo.models.Coffe;
import com.ifrs.tds.ismael.demo.repositories.CoffeRepository;

@Service
public class CoffeService {

    @Autowired
    private CoffeRepository coffeRepository;

    @Transactional
    public Coffe save(Coffe coffe) {
        coffe.setPrice(coffe.getPrice().multiply(BigDecimal.valueOf(100)));
        return this.coffeRepository.save(coffe);
    }

    public Page<Coffe> findAll(Pageable pageable) {
        return this.coffeRepository.findAll(pageable);
    }

    public Optional<Coffe> findById(UUID id) {
        return this.coffeRepository.findById(id);
    }

    @Transactional
    public void delete(Coffe coffe) {
        this.coffeRepository.delete(coffe);
    }

}
