package com.example.mall.controller;

import com.example.mall.pojo.Product;
import com.example.mall.pojo.PropertyValue;
import com.example.mall.service.ProductService;

import com.example.mall.service.PropertyValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PropertyValueController {
    @Resource
    PropertyValuesService propertyValueService;
    @Resource
    ProductService productService;

    @GetMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid)throws Exception{
        Product product=productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> propertyValues=propertyValueService.list(product);
        return propertyValues;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception{
        propertyValueService.update(bean);
        return bean;
    }

}
