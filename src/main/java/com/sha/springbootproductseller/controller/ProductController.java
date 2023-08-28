package com.sha.springbootproductseller.controller;


import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*request body example
    {
        "name": "product-x",
            "description": "best-product eva",
            "price" : 10
    }*/
    @PostMapping()
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }



    @GetMapping("/home") // This maps to the URL path "/home"
    public String getAllProduct(Model model) {
        // Retrieve the product list and add it to the model
        List<Product> products = productService.findAllProducts();

        model.addAttribute("products", products);


        // Return the name of the Thymeleaf template (without the ".html" extension)
        return "home";
    }
}
