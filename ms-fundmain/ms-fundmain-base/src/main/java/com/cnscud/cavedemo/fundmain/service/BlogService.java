package com.cnscud.cavedemo.fundmain.service;

import com.cnscud.cavedemo.fundmain.model.Blog;

import java.util.List;

/**
 * Blog Service.
 *
 * @author Felix Zhang 2021-08-02 11:05
 * @version 1.0.0
 */
public interface BlogService {

    public Blog queryBlog(int id);

    public List<Blog> queryBlogs(int userId);

}
