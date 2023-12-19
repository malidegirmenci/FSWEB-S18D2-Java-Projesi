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
@Table(name = "vegetable", schema = "s18d2")
public class Vegetable extends Plant{
    @Column(name = "is_grown_on_tree")
    @NotNull
    private Boolean isGrownOnTree;
}
