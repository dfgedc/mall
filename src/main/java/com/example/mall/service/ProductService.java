package com.example.mall.service;

import com.example.mall.dao.ProductDAO;
import com.example.mall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;


    public void add(Product bean)
    {
        productDAO.save(bean);
    }
    public void delete(int id)
    {
        productDAO.delete(id);
    }
    public Product get(int id)
    {
        return productDAO.findOne(id);
    }
    public void update(Product product)
    {
        productDAO.save(product);
    }
}
