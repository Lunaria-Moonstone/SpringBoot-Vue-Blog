package org.luna.mapper;

import org.apache.ibatis.annotations.*;
import org.luna.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select(value = "SELECT * FROM user")
    List<User> query();

    @Select(value = "SELECT * FROM user WHERE id=#{id}")
    User select(int id);

    @Select(value = "SELECT * FROM user WHERE name=#{name} and password=#{password}")
    User selectByNameAndPassword(User user);

    @Insert(value = "INSERT INTO user (name, password, profile, root, sex) VALUES (#{name}, #{password}, " +
            "#{profile}, #{root}, #{sex})")
    void create(User user) throws Exception;

    @Delete(value = "DELETE FROM user WHERE id=#{id}")
    void delete(int id) throws Exception;

    @Update(value = "UPDATE user SET name=#{name}, password=#{password}, profile=#{profile}, " +
            "root=#{root}, sex=#{sex} WHERE id=#{id}")
    void edit(User user) throws Exception;
}
