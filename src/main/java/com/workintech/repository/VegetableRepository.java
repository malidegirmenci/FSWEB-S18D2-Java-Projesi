package com.workintech.repository;

import com.workintech.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    @Query(value = "SELECT f.id, f.name, f.price, f.is_grown_on_tree FROM s18d2.vegetable AS f " +
            "ORDER BY f.price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDESC();

    @Query(value = "SELECT f.id, f.name, f.price, f.is_grown_on_tree FROM s18d2.vegetable AS f " +
            "ORDER BY f.price ASC", nativeQuery = true)
    List<Vegetable> getByPriceASC();

    @Query(value = "SELECT f FROM Vegetable f WHERE f.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
