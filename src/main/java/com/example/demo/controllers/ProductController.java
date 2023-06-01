package com.example.demo.controllers;

import com.example.demo.Utils.EndPoint;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(EndPoint.rest)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    @PostMapping(value = EndPoint.add)
    public void addProduct() {
        System.out.println("addProduct");
    }

    @PutMapping(value = EndPoint.update)
    public void updateProduct() {
        System.out.println("updateProduct");
    }

    @GetMapping(value = EndPoint.products)
    public void getAllProducts() {
        System.out.println("getAllProduct");
    }

    @GetMapping(value = "/products/{product_id}")
    public void getProduct(
            @PathVariable(value = "product_id", required = true) String product_id
    ) {
        System.out.println("getAllProduct " + product_id);
    }
}
