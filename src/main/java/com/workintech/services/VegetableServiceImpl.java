package com.workintech.services;

import com.workintech.entity.Vegetable;
import com.workintech.exceptions.PlantException;
import com.workintech.repository.VegetableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {
    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable getById(Long id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if (optionalVegetable.isPresent()) {
            return optionalVegetable.get();
        }
        throw new PlantException("Plant with given id is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Vegetable save(Vegetable Vegetable) {
        return vegetableRepository.save(Vegetable);
    }

    @Override
    public List<Vegetable> getByPriceASC() {
        return vegetableRepository.getByPriceASC();
    }

    @Override
    public List<Vegetable> getByPriceDESC() {
        return vegetableRepository.getByPriceDESC();
    }

    @Override
    public List<Vegetable> getByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable deletedVegetable = getById(id);
        vegetableRepository.delete(deletedVegetable);
        return deletedVegetable;
    }


    @Override
    public Vegetable update(Vegetable newVegetable) {
        Optional<Vegetable> VegetableOptional = vegetableRepository.findById(newVegetable.getId());
        VegetableOptional.ifPresent(vegetable ->
                {
                    vegetable.setName(newVegetable.getName());
                    vegetable.setPrice(newVegetable.getPrice());
                    vegetable.setIsGrownOnTree(newVegetable.getIsGrownOnTree());
                    vegetableRepository.save(vegetable);
                }
        );
        return newVegetable;
    }

    @Override
    public List<Vegetable> getAll() {
        return vegetableRepository.findAll();
    }
}
