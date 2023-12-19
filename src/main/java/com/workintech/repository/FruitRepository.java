package com.workintech.repository;

import com.workintech.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Long> {
    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM s18d2.fruit AS f " +
            "ORDER BY f.price DESC",nativeQuery = true)
    List<Fruit> getByPriceDESC();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type FROM s18d2.fruit AS f " +
            "ORDER BY f.price ASC",nativeQuery = true)
    List<Fruit> getByPriceASC();

    @Query(value = "SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);
}
