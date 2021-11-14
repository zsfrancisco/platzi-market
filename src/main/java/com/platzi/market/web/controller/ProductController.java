package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "Products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    @ApiOperation("Get supermarket product by product id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Product> getProduct(
            @ApiParam(value = "The id of the product", required = true, example = "7")
            @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> ResponseEntity
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{id}")
    @ApiOperation("Get all supermarket products by category id")
    @ApiResponse(code = 200, message = "Products")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("id") int categoryId) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.getProductsByCategory(categoryId));
    }

    @PostMapping()
    @ApiOperation("Save a new supermarket product")
    @ApiResponse(code = 200, message = "Product created")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a supermarket product by product id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product deleted"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Void> deleteProduct(
            @ApiParam(value = "The id of the product", required = true, example = "7")
            @PathVariable("id") int productId) {
        return productService.deleteProduct(productId) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
