package com.example.mall.dao;


import com.example.mall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ${DX} on 2018/12/16.
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
