package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.cavedemo.fundmain.model.Blog;
import com.cnscud.cavedemo.fundmain.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Blog Service.
 *
 * @author Felix Zhang 2021-08-04 20:00
 * @version 1.0.0
 */
@RestController
@RequestMapping("/blog")
public class BlogServiceController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/queryById")
    public Blog queryBlog(int id){
        return blogService.queryBlog(id);
    }

    @RequestMapping("/queryByUser")
    public List<Blog> queryBlogsByUser(Integer userId){
        return blogService.queryBlogsByUser(userId);
    }

    @RequestMapping("/queryLatestList")
    public List<Blog> queryLatestBlogs(){
        return blogService.queryLatestBlogs(10);
    }


}
