package com.apidemo.SpringBoot2Hours.services.impl;

import com.apidemo.SpringBoot2Hours.models.Product;
import com.apidemo.SpringBoot2Hours.models.ResponseObject;
import com.apidemo.SpringBoot2Hours.repositories.ProductRepository;
import com.apidemo.SpringBoot2Hours.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Get all successfully", productRepository.findAll())
        );
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query successfully", product)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new ResponseObject("false", "Cannot find product with id = " + id, "")
            );
        }
    }

    @Override
    public  ResponseEntity<ResponseObject>  createUpdate(Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Save successfully", productRepository.save(product))
        );
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(pro -> {
            pro.setStatus(false);
            productRepository.save(pro); // Lưu lại thay đổi vào cơ sở dữ liệu (nếu cần)
        });

    }
}
