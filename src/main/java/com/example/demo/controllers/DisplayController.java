package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.Display;
import com.example.demo.datebase.DisplayRepository;
import com.example.demo.exception.BadRequestException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EndPoint.displays)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DisplayController {
    DisplayRepository displayRepository;

    public DisplayController(DisplayRepository displayRepository) {
        this.displayRepository = displayRepository;
    }


    @PostMapping(value = EndPoint.add)
    public void addProduct(@RequestBody() Display item) {
        displayRepository.save(item);
    }

    @PutMapping(value = EndPoint.update + "/{item_id}")
    public void updateProduct(
            @PathVariable(value = "item_id") String item_id,
            @RequestBody() Display item) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        }catch (NumberFormatException ex){
            throw new BadRequestException("bad request");
        }
        item.setId(id);
        displayRepository.save(item);
    }

    @GetMapping()
    public List<Display> getAllProducts() {
        return displayRepository.findAll();
    }

    @GetMapping(value = "/{item_id}")
    public Display getProduct(
            @PathVariable(value = "item_id") String item_id
    ) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        }catch (NumberFormatException ex){
            throw new BadRequestException("bad request");
        }
        Optional<Display> item = displayRepository.findById(id);
        return item.orElse(null);
    }
}

