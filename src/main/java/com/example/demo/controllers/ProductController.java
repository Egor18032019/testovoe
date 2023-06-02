package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.Computer;
import com.example.demo.datebase.ComputerRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(EndPoint.computers)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ComputerRepository computerRepository;

    public ProductController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @PostMapping(value = EndPoint.add)
    public void addProduct(@RequestBody() Computer item) {
        System.out.println("addProduct");
        computerRepository.save(item);
    }

    // редактирование как по ид или еще как то ??
    @PutMapping(value = EndPoint.update + "/{item_id}")
    public void updateProduct(
            @PathVariable(value = "item_id", required = true) String item_id,
            @RequestBody() Computer item) {
        System.out.println("updateProduct");
        Long id = Long.valueOf(item_id); // todo проверку
        item.setId(id);
        computerRepository.save(item);
    }

    @GetMapping()
    public List<Computer> getAllProducts() {
        return computerRepository.findAll();
    }

    @GetMapping(value = "/{item_id}")
    public Computer getProduct(
            @PathVariable(value = "item_id", required = true) String item_id
    ) {
        Long id = Long.valueOf(item_id);
        Optional<Computer> item = computerRepository.findById(id);
        return item.orElse(null);
    }
}
