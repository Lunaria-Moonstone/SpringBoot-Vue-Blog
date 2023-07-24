package org.luna.mapper;

import org.apache.ibatis.annotations.*;
import org.luna.bean.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    @Insert(value = "INSERT INTO `blog`(`title`, `content`, `release_datetime`, `lastest_upload_datetime`" +
            ", `author_id`) VALUES(#{title}, #{content}, #{release_datetime}, #{lastest_upload_datetime}, " +
            "#{author_id})")
    void create(Blog blog) throws Exception;

    @Select(value = "SELECT * FROM `blog`")
    List<Blog> query() throws Exception;

    @Select(value = "SELECT * FROM `blog` where `id`=#{id}")
    Blog select(int id) throws Exception;

    @Update(value = "UPDATE `blog` SET `title`=${title}, `content`=${content}, `release_datetime`=${release_datetime}" +
            ", `lastest_upload_datetime`=${lastest_upload_datetime}, `author_id`=${author_id} WHERE `id`=${id}")
    void update(Blog blog) throws Exception;

    @Delete(value = "DELETE FROM `blog` WHERE `id`=${id}")
    void delete(int id) throws Exception;
}
