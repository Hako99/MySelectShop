package com.sparta.spring0402myselectshop.service;

import com.sparta.spring0402myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.spring0402myselectshop.dto.ProductRequestDto;
import com.sparta.spring0402myselectshop.dto.ProductResponseDto;
import com.sparta.spring0402myselectshop.entity.Product;
import com.sparta.spring0402myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public static final int MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();
        if(myprice <MIN_MY_PRICE){
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE +"원 이상으로 설정해 주십시오");
        }

        Product product = productRepository.findById(id).orElseThrow(()->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        product.update(requestDto);
        return new ProductResponseDto(product);
    }
}
