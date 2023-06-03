package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.Computer;
import com.example.demo.datebase.ComputerRepository;
import com.example.demo.exception.BadRequestException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(EndPoint.computers)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComputerController {

    ComputerRepository computerRepository;

    public ComputerController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @PostMapping(value = EndPoint.add)
    public void addProduct(@RequestBody() Computer item) {
        computerRepository.save(item);
    }

    // редактирование как по ид и полностью или только по одному полю?
    @PutMapping(value = EndPoint.update + "/{item_id}")
    public void updateProduct(
            @PathVariable(value = "item_id", required = true) String item_id,
            @RequestBody() Computer item) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("bad request");
        }
        item.setId(id);
        computerRepository.save(item);
    }

    @GetMapping()
    public List<Computer> getAllProducts() {
        return computerRepository.findAll();
    }

    @GetMapping(value = "/{item_id}")
    public Computer getProduct(
            @PathVariable(value = "item_id") String item_id
    ) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        } catch (NumberFormatException ex) {
            throw new BadRequestException("bad request");
        }
        Optional<Computer> item = computerRepository.findById(id);
        return item.orElse(null);
    }
}
