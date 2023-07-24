package org.luna.controller;

import org.luna.bean.User;
import org.luna.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value="/query")
    public List<User> query() {
        return userMapper.query();
    }

    @GetMapping(value = "/query/{id}")
    public User query(@PathVariable("id") int id) {
        return userMapper.select(id);
    }

    @GetMapping(value = "/login")
    public User login(@RequestBody User userMsg)  {
        User user = new User(userMsg.getName(), userMsg.getPassword());
        User resUser = null;
        try {
            resUser = userMapper.selectByNameAndPassword(user);
        } catch (Exception ignored) {}
        return resUser;
    }

    @PostMapping(value = "/add")
    public String create(@RequestBody User userMsg) {
        User user = new User(userMsg.getName(), userMsg.getPassword(), userMsg.getProfile(), userMsg.getRoot(), userMsg.getSex());
        try {
            userMapper.create(user);
        } catch (Exception _e) {
            return "Error";
        }
        return "Ok";
    }

    @DeleteMapping(value = "/del")
    public String delete(@RequestParam("id") int id) {
        try {
            userMapper.delete(id);
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
        return "Ok";
    }

    @PutMapping(value = "/edit")
    public String edit(@RequestParam("id") int id, @RequestBody User userMsg) {
        User user = new User(id, userMsg.getName(), userMsg.getPassword(), userMsg.getProfile(), userMsg.getRoot(), userMsg.getSex());
        try {
            userMapper.edit(user);
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
        return "Ok";
    }
}
