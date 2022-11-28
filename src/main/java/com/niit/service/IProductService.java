package com.niit.service;

import com.niit.domain.Product;

import java.util.List;

public interface IProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

    Product getProductByProductId(int productId);

    boolean deleteProductByProductId(int productId);

}
