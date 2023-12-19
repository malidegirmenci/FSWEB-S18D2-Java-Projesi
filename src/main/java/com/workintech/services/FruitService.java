package com.workintech.services;

import com.workintech.entity.Fruit;



import java.util.List;

public interface FruitService {
    Fruit getById(Long id);
    Fruit save(Fruit fruit);
    Fruit delete(Long id);
    Fruit update(Fruit fruit);
    List<Fruit> getByPriceASC();
    List<Fruit> getAll();
    List<Fruit> getByPriceDESC();
    List<Fruit> getByName(String name);

}
