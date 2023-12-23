package com.example.productservice.Services;

import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Dtos.FakeStoreProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private RestTemplate restTemplate;

    private final String fakeStoreDomain ="https://fakestoreapi.com/products";
    @Autowired
    public ProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    private Product mapFakeStoreProductToProduct(FakeStoreProduct fakeStoreProduct){
        var product = new Product();
        product.setId(fakeStoreProduct.getId());
        product.setTitle(fakeStoreProduct.getTitle());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImageUrl());

        var category = new Category();
        category.setName(fakeStoreProduct.getCategory());

        product.setCategory(category);

        return product;

    }


    public List<Product> getAllProducts(){

        List<Product> products = new ArrayList<>();
        try{
            var list = List.of(restTemplate.getForEntity(fakeStoreDomain, FakeStoreProduct[].class).getBody());
            return list.stream().map(this::mapFakeStoreProductToProduct).toList();
        }catch (Exception ex){
            System.out.println("Error while getting products from fake store api" + ex);
        }
        return products;
    }
}
