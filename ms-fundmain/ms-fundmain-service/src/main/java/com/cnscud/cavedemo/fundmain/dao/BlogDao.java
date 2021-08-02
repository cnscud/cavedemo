package com.cnscud.cavedemo.fundmain.dao;

import com.cnscud.cavedemo.fundmain.model.Blog;

import java.util.List;

public interface BlogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    List<Blog> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}