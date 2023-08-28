package com.sha.springbootproductseller.controller;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.model.Purchase;
import com.sha.springbootproductseller.service.ProductService;
import com.sha.springbootproductseller.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    /*request body example
    {
        "name": "product-x",
            "description": "best-product eva",
            "price" : 10
    }*/
    @PostMapping()
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

//    @DeleteMapping("{purchaseId}")
//    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
//        productService.deleteProduct(productId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllPurchaseOfUser(@PathVariable Long userId) {
        return new ResponseEntity<>(purchaseService.findPurchaseItemOfUser(userId), HttpStatus.OK);
    }
}





