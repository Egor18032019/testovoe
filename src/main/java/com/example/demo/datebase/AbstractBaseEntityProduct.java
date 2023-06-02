package com.example.demo.datebase;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@MappedSuperclass
@Access(AccessType.FIELD)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class AbstractBaseEntityProduct {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
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
