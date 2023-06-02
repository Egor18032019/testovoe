package com.example.demo.datebase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "HDD")
@Getter
@Setter
public class HDD extends AbstractBaseEntityProduct {
    @Column()
    Integer size;
}
