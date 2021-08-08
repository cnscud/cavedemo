package com.cnscud.cavedemo.fundmain.service.impl;

import com.cnscud.cavedemo.fundmain.dao.BlogDao;
import com.cnscud.cavedemo.fundmain.model.Blog;
import com.cnscud.cavedemo.fundmain.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Blog Service.
 *
 * @author Felix Zhang 2021-08-02 15:21
 * @version 1.0.0
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog queryBlog(int id) {
        return blogDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Blog> queryBlogsByUser(int userId) {
        return blogDao.selectByUserId(userId);
    }

    @Override
    public List<Blog> queryLatestBlogs(int limit) {
        return blogDao.selectLatest(limit);

    }
}
