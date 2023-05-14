package com.assesment.develup.service;

import com.assesment.develup.entity.Products;
import com.assesment.develup.global.exception.CustomException;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> getTopSoldProducts();
    ResponseEntity<?> getProductsDetails();
    ResponseEntity<?> updateProduct(Products products,long id) throws CustomException;
    ResponseEntity<?> deleteProduct(long id) throws CustomException;
}
