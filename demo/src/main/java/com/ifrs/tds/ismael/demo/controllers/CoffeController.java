package com.ifrs.tds.ismael.demo.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifrs.tds.ismael.demo.models.Coffe;
import com.ifrs.tds.ismael.demo.models.dtos.CreateCoffe;
import com.ifrs.tds.ismael.demo.services.CoffeService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coffes")
public class CoffeController {

    @Autowired
    private CoffeService coffeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CreateCoffe createCoffe) {

        var coffe = new Coffe();

        BeanUtils.copyProperties(createCoffe, coffe);
        coffe.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(coffeService.save(coffe));
    }

    @GetMapping
    public ResponseEntity<Page<Coffe>> list(
            @PageableDefault(page = 0, size = 10, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.coffeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable(value = "id") UUID id) {
        Optional<Coffe> coffe = this.coffeService.findById(id);

        if (!coffe.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coffe not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(coffe.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        Optional<Coffe> coffe = this.coffeService.findById(id);

        if (!coffe.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coffe not found");
        }

        this.coffeService.delete(coffe.get());

        return ResponseEntity.status(HttpStatus.OK).body("Coffe deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
            @RequestBody @Valid CreateCoffe coffeUpdate) {

        Optional<Coffe> coffeOptional = coffeService.findById(id);

        if (!coffeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coffe not found");
        }

        var coffe = new Coffe();

        BeanUtils.copyProperties(coffeUpdate, coffe);
        coffe.setId(coffeOptional.get().getId());
        coffe.setCreatedAt(coffeOptional.get().getCreatedAt());
        coffe.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.OK).body(this.coffeService.save(coffe));
    }
}
