package com.example.mall.controller;

import com.example.mall.pojo.Category;
import com.example.mall.service.CategoryService;
import com.example.mall.util.ImageUtil;
import com.example.mall.util.Page4Navigate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;

@RestController
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigate<Category> list(@RequestParam(value = "start" ,
            defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size)throws Exception{
        start = start<0?0:start;
        Page4Navigate<Category> page=categoryService.list(start,size,5);
        return  page;
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request)throws
            Exception{
        categoryService.add(bean);
        saveOrUpdateImageFile(bean,image,request);
        return bean;
    }
    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
            throws Exception{
        File imageFolder=new File(request.getServletContext().getRealPath("img/category"));
        File file=new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        image.transferTo(file);
        BufferedImage img= ImageUtil.change2jpg(file);
        ImageIO.write(img,"jpg",file);
    }
    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id,HttpServletRequest request) throws Exception{
        categoryService.delete(id);
        File imageFolder=new File(request.getServletContext().getRealPath("img/category"));
        File file=new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id)throws Exception{
        Category category= categoryService.get(id);
        return category;
    }
}
