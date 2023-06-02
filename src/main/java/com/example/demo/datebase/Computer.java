package com.example.demo.datebase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "COMPUTER")
@Getter
@Setter
public class Computer extends AbstractBaseEntityProduct {

    @Column()
    String formComputer;

}
