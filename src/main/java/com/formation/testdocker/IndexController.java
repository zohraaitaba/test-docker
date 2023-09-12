package com.formation.testdocker;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

/*  @Value("${title}")
    private String title; */


    private final ProductRepository productRepository;

    public IndexController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/")
    public  Iterable<ProductEntity> index() {
        return productRepository.findAll();
    }

    @PostMapping("/")
    public ProductEntity create(@RequestBody ProductEntity product){
        return productRepository.save(product);
    }
    
}
