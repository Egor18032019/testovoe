package com.example.demo.datebase;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotebookRepository extends CrudRepository<Notebook, Long> {
    List<Notebook> findAll();

}
