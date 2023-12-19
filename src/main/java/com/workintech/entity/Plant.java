package com.workintech.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "The value can not be null.")
    @NotBlank(message = "The value can not be empty.")
    @Size(min = 1, max = 30, message = "The value cannot be less than 3 or greater than 30.")
    private String name;

    @Column(name = "price")
    @NotNull(message = "The value can not be null.")
    @Min(1)
    private Integer price;
}
