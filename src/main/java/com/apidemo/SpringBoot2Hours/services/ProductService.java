package com.apidemo.SpringBoot2Hours.services;

import com.apidemo.SpringBoot2Hours.models.Product;
import com.apidemo.SpringBoot2Hours.models.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ResponseEntity<ResponseObject> getAll();
    ResponseEntity<ResponseObject> findById(Long id);
    ResponseEntity<ResponseObject>  createUpdate(Product product);
    void  delete(Long id);
}

