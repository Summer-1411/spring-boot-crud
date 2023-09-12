package com.apidemo.SpringBoot2Hours.controllers;

import com.apidemo.SpringBoot2Hours.models.Product;
import com.apidemo.SpringBoot2Hours.models.ResponseObject;
import com.apidemo.SpringBoot2Hours.repositories.ProductRepository;
import com.apidemo.SpringBoot2Hours.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    //DI = Dependence Injection
    @Autowired
    private ProductService productService;
    @GetMapping("/get-all")
    ResponseEntity<ResponseObject> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getDetail(@PathVariable Long id){

        return productService.findById(id);
    }

    @PostMapping("/create-update")
    ResponseEntity<ResponseObject>  createUpdate(@RequestBody Product product){
        return productService.createUpdate(product);
    }

    @PostMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
