package com.sparta.spring0402myselectshop.service;

import com.sparta.spring0402myselectshop.dto.ProductRequestDto;
import com.sparta.spring0402myselectshop.dto.ProductResponseDto;
import com.sparta.spring0402myselectshop.entity.Product;
import com.sparta.spring0402myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
}
