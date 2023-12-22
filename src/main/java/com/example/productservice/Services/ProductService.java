package com.example.productservice.Services;

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
    @Autowired
    public ProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<FakeStoreProduct> getAllProducts(){

        List<FakeStoreProduct> products = new ArrayList<>();
        try{
            return List.of(restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProduct[].class).getBody());
        }catch (Exception ex){

        }
        return products;
    }
}
