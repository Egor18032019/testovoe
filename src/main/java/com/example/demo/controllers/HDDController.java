package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.HDD;
import com.example.demo.datebase.HDDRepository;
import com.example.demo.exception.BadRequestException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EndPoint.hdd)
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
        Long id;
        try {
            id = Long.valueOf(item_id);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("bad request");
        }
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
        Long id;
        try {
            id = Long.valueOf(item_id);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("bad request");
        }
        Optional<HDD> item = repositoryHDD.findById(id);
        return item.orElse(null);
    }
}
