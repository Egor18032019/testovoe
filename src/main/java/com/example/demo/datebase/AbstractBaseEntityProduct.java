package com.example.demo.datebase;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@MappedSuperclass
@Access(AccessType.FIELD)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class AbstractBaseEntityProduct {

    @Id
    Long id;
    @Column()
    Long serialNumber;
    @Column()
    String producerType;
    @Column()
    Long price;
    @Column()
    Long balance;
}
