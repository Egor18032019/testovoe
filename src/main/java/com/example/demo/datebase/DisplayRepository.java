package com.example.demo.datebase;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisplayRepository extends CrudRepository<Display, Long> {
    List<Display> findAll();

}
