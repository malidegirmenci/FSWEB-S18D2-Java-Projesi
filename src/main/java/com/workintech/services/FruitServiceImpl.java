package com.workintech.services;

import com.workintech.entity.Fruit;
import com.workintech.exceptions.PlantException;
import com.workintech.repository.FruitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if (optionalFruit.isPresent()) {
            return optionalFruit.get();
        }
        throw new PlantException("Plant with given id is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> getByPriceASC() {
        return fruitRepository.getByPriceASC();
    }

    @Override
    public List<Fruit> getByPriceDESC() {
        return fruitRepository.getByPriceDESC();
    }

    @Override
    public List<Fruit> getByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit deletedFruit = getById(id);
        fruitRepository.delete(deletedFruit);
        return deletedFruit;
    }


    @Override
    public Fruit update(Fruit newFruit) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(newFruit.getId());
        fruitOptional.ifPresent(fruit ->
                {
                    fruit.setName(newFruit.getName());
                    fruit.setPrice(newFruit.getPrice());
                    fruit.setFruitType(newFruit.getFruitType());
                    fruitRepository.save(fruit);
                }
        );
        return newFruit;
    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }
}
