package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.HDD;
import com.example.demo.datebase.HDDRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EndPoint.notebooks)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HDDController {
    HDDRepository repositoryHDD;

    public HDDController(HDDRepository repositoryHDD) {
        this.repositoryHDD = repositoryHDD;
    }


    @PostMapping(value = EndPoint.add)
    public void addProduct(@RequestBody() HDD item) {
        repositoryHDD.save(item);
    }

    @PutMapping(value = EndPoint.update + "/{item_id}")
    public void updateProduct(
            @PathVariable(value = "item_id") String item_id,
            @RequestBody() HDD item) {
        System.out.println("updateProduct");
        Long id = Long.valueOf(item_id); // todo проверку
        item.setId(id);
        repositoryHDD.save(item);
    }

    @GetMapping()
    public List<HDD> getAllProducts() {
        return repositoryHDD.findAll();
    }

    @GetMapping(value = "/{item_id}")
    public HDD getProduct(
            @PathVariable(value = "item_id") String item_id
    ) {
        Long id = Long.valueOf(item_id);
        Optional<HDD> item = repositoryHDD.findById(id);
        return item.orElse(null);
    }
}
