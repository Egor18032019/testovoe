package com.example.demo.datebase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Notebooks")
@Getter
@Setter
public class Notebook extends AbstractBaseEntityProduct {
    @Column()
    Integer size;
}
