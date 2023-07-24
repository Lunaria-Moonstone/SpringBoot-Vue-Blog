package org.luna.controller;

import org.luna.bean.Blog;
import org.luna.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/")
    public List<Blog> query(@RequestParam(value = "id", required = false) Integer id) {
        List<Blog> blogs = null;
        try {
            if (id == null) blogs = blogMapper.query();
            else {
                blogs = new ArrayList<Blog>();
                blogs.add(blogMapper.select(id));
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
        return blogs;
    }

    @PostMapping("/")
    public String create(@RequestBody Blog blogMsg) {
        Blog blog = new Blog(blogMsg.getTitle(), blogMsg.getContent(), blogMsg.getRelease_datetime(), blogMsg.getLastest_upload_datetime(), blogMsg.getAuthor_id());
        try {
            blogMapper.create(blog);
        } catch (Exception _e) {
            System.out.println(_e);
            return "Error";
        }
        return "Ok";
    }

    @PutMapping("/")
    public String edit(@RequestParam("id") Integer id, @RequestBody Blog blogMsg) {
        Blog blog = new Blog(id, blogMsg.getTitle(), blogMsg.getContent(), blogMsg.getRelease_datetime(), blogMsg.getLastest_upload_datetime(), blogMsg.getAuthor_id());
        try {
            blogMapper.update(blog);
        } catch (Exception ignore) {
            System.out.println(ignore);
            return "Error";
        }
        return "Ok";
    }

    @DeleteMapping("/")
    public String delete(@RequestParam("id") Integer id) {
        try {
            blogMapper.delete(id);
        } catch (Exception ignore) {
            System.out.println(ignore);
            return "Error";
        }
        return "Ok";
    }
}
