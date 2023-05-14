package com.assesment.develup.controller;

import com.assesment.develup.entity.Products;
import com.assesment.develup.global.exception.CustomException;
import com.assesment.develup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("top_selling")
    ResponseEntity<?> getTopSoldProducts(){
        return productService.getTopSoldProducts();
    }
    @GetMapping("product_details")
    ResponseEntity<?> getProductsDetails(){
        return productService.getProductsDetails();
    }
    @PutMapping("update/{id}")
    ResponseEntity<?> updateProduct(@RequestBody Products products,@PathVariable long id) throws CustomException {
        return productService.updateProduct(products,id);
    }
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteProduct(@PathVariable long id) throws CustomException {
        return productService.deleteProduct(id);
    }
}
