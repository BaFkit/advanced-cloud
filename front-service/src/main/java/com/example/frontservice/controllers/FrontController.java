package com.example.frontservice.controllers;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/front")
public class FrontController {

    private final RestTemplate restTemplate;

    @GetMapping("/products")
    public List<ProductDto> getListProducts() {
        return restTemplate.getForObject("http://product-service/api/v1/products", List.class);
    }
}
