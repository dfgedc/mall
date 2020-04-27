package com.example.mall.service;

import com.example.mall.dao.UserDao;
import com.example.mall.pojo.User;
import com.example.mall.util.Page4Navigate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserDao userDao;

    public Page4Navigate<User> list(int start,int size,int navigatePages) {
        Sort sort =new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFormJPA=userDao.findAll(pageable);
        return new Page4Navigate<>(pageFormJPA,navigatePages);
    }
    }
