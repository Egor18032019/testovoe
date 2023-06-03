package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import com.example.demo.datebase.Notebook;
import com.example.demo.datebase.NotebookRepository;
import com.example.demo.exception.BadRequestException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(EndPoint.notebooks)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotebookController {
    NotebookRepository notebookRepository;

    public NotebookController(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @PostMapping(value = EndPoint.add)
    public void addProduct(@RequestBody() Notebook item) {
        System.out.println("addProduct");
        notebookRepository.save(item);
    }

    @PutMapping(value = EndPoint.update + "/{item_id}")
    public void updateProduct(
            @PathVariable(value = "item_id") String item_id,
            @RequestBody() Notebook item) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        }catch (NumberFormatException ex){
            throw new BadRequestException("bad request");
        }
        item.setId(id);
        notebookRepository.save(item);
    }

    @GetMapping()
    public List<Notebook> getAllProducts() {
         return notebookRepository.findAll();
    }

    @GetMapping(value = "/{item_id}")
    public Notebook getProduct(
            @PathVariable(value = "item_id") String item_id
    ) {
        Long id;
        try {
            id = Long.valueOf(item_id);
        }catch (NumberFormatException ex){
            throw new BadRequestException("bad request");
        }
        Optional<Notebook> item = notebookRepository.findById(id);
        return item.orElse(null);
    }
}
