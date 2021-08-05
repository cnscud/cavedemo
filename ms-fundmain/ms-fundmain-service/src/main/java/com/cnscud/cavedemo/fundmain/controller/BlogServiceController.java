package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.cavedemo.fundmain.dao.BlogDao;
import com.cnscud.cavedemo.fundmain.model.Blog;
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
    private BlogDao blogdao;

    @RequestMapping("/view")
    public Blog queryBlog(int id){
        return blogdao.selectByPrimaryKey(id);
    }

    @RequestMapping("/list")
    public List<Blog> queryLatestBlogs(){
        return blogdao.selectLatest(10);
    }

}
