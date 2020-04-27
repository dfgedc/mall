package com.example.mall.service;

import com.example.mall.dao.PropertyDAO;
import com.example.mall.pojo.Category;
import com.example.mall.pojo.Property;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyService {
    @Resource
    PropertyDAO propertyDAO;


    @Resource
    CategoryService categoryService;

    public void add(Property bean){
        propertyDAO.save(bean);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }

    public Property get(int id){
        return propertyDAO.findOne(id);
    }

    public void  update(Property bean){
        propertyDAO.save(bean);
    }

    public List<Property> listByCategory(Category category){
        return propertyDAO.findByCategory(category);
    }

}
