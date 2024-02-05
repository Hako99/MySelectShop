package com.sparta.spring0402myselectshop.controller;

import com.sparta.spring0402myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.spring0402myselectshop.dto.ProductRequestDto;
import com.sparta.spring0402myselectshop.dto.ProductResponseDto;
import com.sparta.spring0402myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor    // 생성자 주입
@RequestMapping("/api")     //중복되는 경로
public class ProductController {

    private final ProductService productService;
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.createProduct(requestDto);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.updateProduct(id, requestDto);
    }
}


