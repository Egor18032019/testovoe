package com.example.demo.datebase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Displays")
@Getter
@Setter
public class Display extends AbstractBaseEntityProduct {
    @Column()
    Integer Diagonal;
}
