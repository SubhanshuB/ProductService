package com.example.productservice.Dtos;

import com.example.productservice.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProduct {
    public Long id;
    public String title;
    public double price;
    public String category;
    public  String description;
    public String imageUrl;
}
