package com.wolterskluwer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolterskluwer.exceptions.ResourceNotFoundException;
import com.wolterskluwer.model.Product;
import com.wolterskluwer.repository.ProductRepository;


@RestController
@RequestMapping("/api")
public class ProductController {
	

    @Autowired
    private ProductRepository productRepository;

    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){

        return  ResponseEntity.ok(productRepository.findAll());
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id")
                                                    Integer id){
    	Product product= productRepository.findById(id).orElseThrow(
               ()->new ResourceNotFoundException("Product not found"+id));
               return ResponseEntity.ok().body(product);

    }
    
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){

        return productRepository.save(product);
    }
    
    
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                   @RequestBody Product productDetails) {
    	Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);

    }
    
    

}
