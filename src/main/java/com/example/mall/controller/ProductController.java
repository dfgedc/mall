package com.example.mall.controller;

import com.example.mall.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProductController {
    @Resource
    ProductService productService;

}
