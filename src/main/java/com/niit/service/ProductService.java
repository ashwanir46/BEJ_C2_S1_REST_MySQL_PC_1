package com.niit.service;

import com.niit.domain.Product;
import com.niit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductByProductId(int productId) {
        Optional optional;
        optional = productRepository.findById(productId);
        return optional.isPresent() ? (Product) optional.get() : null;
    }

    @Override
    public boolean deleteProductByProductId(int productId) {
        productRepository.deleteById(productId);
        return false;
    }
}
