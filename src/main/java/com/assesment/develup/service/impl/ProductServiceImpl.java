package com.assesment.develup.service.impl;

import com.assesment.develup.constants.DbConstant;
import com.assesment.develup.entity.Products;
import com.assesment.develup.global.exception.CustomException;
import com.assesment.develup.repo.ProductRepository;
import com.assesment.develup.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;
    @Override
    public ResponseEntity<?> getTopSoldProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findTopSoldProducts(10));
    }

    @Override
    public ResponseEntity<?> getProductsDetails() {
        var productCountDTO=entityManager.createNativeQuery(DbConstant.COUNT_QUERY).getSingleResult();
        log.info(productCountDTO.toString());
        return ResponseEntity.status(HttpStatus.OK).body(productCountDTO);
    }

    @Override
    public ResponseEntity<?> updateProduct(Products products, long id) throws CustomException {
        var product= productRepository.findById(id).orElseThrow(()->new CustomException(HttpStatus.NOT_FOUND.value(), "Could not found product of the given id "+id));
        products.setId(id);
        product=productRepository.save(products);
        log.info(product.toString());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Override
    public ResponseEntity<?> deleteProduct(long id) throws CustomException {
        var product=productRepository.findById(id).orElseThrow(()->new CustomException(HttpStatus.NOT_FOUND.value(), "Could not found product of the given id "+id));
        productRepository.deleteById(id);
        log.info(product.toString());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
