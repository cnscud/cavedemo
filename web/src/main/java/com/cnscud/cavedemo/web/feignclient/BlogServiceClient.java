package com.cnscud.cavedemo.web.feignclient;

import com.cnscud.cavedemo.fundmain.model.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign client.
 *
 * @author Felix Zhang 2021-08-07 15:55
 * @version 1.0.0
 */
//@FeignClient(value = "ms-fundmain-service", contextId = "blog")
//@RequestMapping("/blog")
@FeignClient(value = "ms-gateway", contextId= "blog")
@RequestMapping("/fundmain/blog")
public interface BlogServiceClient  {


    @RequestMapping("/queryById")
    Blog queryBlog(@RequestParam("id") int id);


    @RequestMapping("/queryByUser")
    List<Blog> queryBlogsByUser(@RequestParam("userId") int userId);



    @RequestMapping("/queryLatestList")
    List<Blog> queryLatestBlogs(@RequestParam("limit") int limit);
}
