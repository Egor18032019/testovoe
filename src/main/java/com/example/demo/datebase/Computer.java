package com.example.demo.datebase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "COMPUTER")
public class Computer extends AbstractBaseEntityProduct {
    @Column()
    String formComputer;

}
