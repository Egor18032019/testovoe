package com.example.demo.datebase;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HDDRepository extends CrudRepository<HDD, Long> {
    List<HDD> findAll();

}
