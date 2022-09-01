package com.example.productservice.controllers;

import com.example.productservice.converters.ProductConverter;
import com.example.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.example.api.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> getAllProducts() {
       return productService.getAll().stream().map(productConverter::entityToDto).collect(Collectors.toList());
    }
}
