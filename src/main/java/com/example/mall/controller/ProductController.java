package com.example.mall.controller;

import com.example.mall.pojo.Product;
import com.example.mall.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class ProductController {
    @Resource
    ProductService productService;
    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id)
    {
        Product product = productService.get(id);
        return product;
    }
    @PostMapping("/products")
    public Object add(@RequestBody Product bean)
    {
        bean.setCreateDate(new Date());
        productService.add(bean);
        return bean;
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable("id")int id, HttpServletRequest request)throws Exception{
        productService.delete(id);
        return null;
    }

    @PutMapping("/products")
    public Object update(@RequestBody Product bean) throws Exception{
        productService.update(bean);
        return bean;
    }
}
