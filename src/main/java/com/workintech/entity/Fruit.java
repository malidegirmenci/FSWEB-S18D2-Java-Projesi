package com.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "fruit", schema = "s18d2")
public class Fruit extends Plant {
    @Enumerated(EnumType.STRING)
    @NotNull(message = "The value can not be null.")
    @Column(name = "fruit_type")
    private FruitType fruitType;
}
