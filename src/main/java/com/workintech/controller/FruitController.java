package com.workintech.controller;

import com.workintech.entity.Fruit;
import com.workintech.services.FruitService;
import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAll() {
        return fruitService.getAll();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id) {
        return fruitService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getAllByName(@PathVariable String name) {
        return fruitService.getByName(name);
    }

    @GetMapping("/ASC")
    public List<Fruit> getByPriceASC() {
        return fruitService.getByPriceASC();
    }

    @GetMapping("/DESC")
    public List<Fruit> getByPriceDES() {
        return fruitService.getByPriceDESC();
    }

    @Transactional
    @PostMapping
    public Fruit create(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @Transactional
    @PutMapping
    public Fruit update(@Validated @RequestBody Fruit fruit) {
        return fruitService.update(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id) {
        return fruitService.delete(id);
    }

}
