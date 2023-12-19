package com.workintech.services;

import com.workintech.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    Vegetable getById(Long id);
    Vegetable save(Vegetable vegetable);
    Vegetable delete(Long id);
    Vegetable update(Vegetable vegetable);
    List<Vegetable> getByPriceASC();
    List<Vegetable> getAll();
    List<Vegetable> getByPriceDESC();
    List<Vegetable> getByName(String name);
}
