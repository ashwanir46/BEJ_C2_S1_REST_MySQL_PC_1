package com.niit.controller;

import com.niit.domain.Product;
import com.niit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    private ProductService productService;

    @Autowired
    ProjectController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/productPost")
    public ResponseEntity<?> saveDataIntoProduct(@RequestBody Product product) {
        Product product1 = productService.saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/productGet")
    public ResponseEntity<?> getAllDataFromProduct() {
        List<Product> productList = productService.getAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<?> getDataById(@PathVariable Integer id) {
        Product product = productService.getProductByProductId(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @DeleteMapping("/productDelete/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable int productId) {
        return new ResponseEntity<>(productService.deleteProductByProductId(productId), HttpStatus.OK);
    }

}
