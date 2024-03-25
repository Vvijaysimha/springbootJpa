package com.vijay.productservice.Service;

import com.vijay.productservice.DTO.ProductResponse;
import com.vijay.productservice.Model.Product;
import com.vijay.productservice.DTO.ProductRequest;
import com.vijay.productservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //at compile time it will create all the constructors
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){
        Product product= Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {

        List<Product> products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
