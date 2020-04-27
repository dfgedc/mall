package com.example.mall.service;

import com.example.mall.dao.PropertyValueDAO;
import com.example.mall.pojo.Product;
import com.example.mall.pojo.Property;
import com.example.mall.pojo.PropertyValue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyValuesService {

    @Resource
    PropertyValueDAO propertyValueDAO;
    @Resource
    PropertyService propertyService;

    public void update(PropertyValue bean){
        propertyValueDAO.save(bean);
    }

    public void init(Product product){
        List<Property> properties=propertyService.listByCategory(product.getCategory());

        for(Property property:properties){
            PropertyValue propertyValue=getByPropertyAndProduct(product,property);
            if(null==propertyValue){
                propertyValue=new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDAO.save(propertyValue);
            }
        }

    }

    public PropertyValue getByPropertyAndProduct(Product product,Property property){
        return propertyValueDAO.getByPropertyAndProduct(property,product);
    }

    public List<PropertyValue> list(Product product){
        return propertyValueDAO.findByProductOrderByIdDesc(product);

    }


}
