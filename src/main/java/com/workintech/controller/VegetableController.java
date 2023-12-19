package com.workintech.controller;

import com.workintech.entity.Vegetable;
import com.workintech.services.VegetableService;
import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAll() {
        return vegetableService.getAll();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable Long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getAllByName(@PathVariable String name) {
        return vegetableService.getByName(name);
    }

    @GetMapping("/ASC")
    public List<Vegetable> getByPriceASC() {
        return vegetableService.getByPriceASC();
    }

    @GetMapping("/DESC")
    public List<Vegetable> getByPriceDES() {
        return vegetableService.getByPriceDESC();
    }

    @Transactional
    @PostMapping
    public Vegetable create(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @Transactional
    @PutMapping
    public Vegetable update(@Validated @RequestBody Vegetable vegetable) {
        return vegetableService.update(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id) {
        return vegetableService.delete(id);
    }
}
