package org.luna.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.javalite.activejdbc.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Blog {
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date release_datetime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date lastest_upload_datetime;
    private Integer author_id;

    public Blog() {}

    public Blog(String title, String content, Date release_datetime, Date lastest_upload_datetime, Integer author_id) {
        this.title = title;
        this.content = content;
        this.release_datetime = release_datetime;
        this.lastest_upload_datetime = lastest_upload_datetime;
        this.author_id = author_id;
    }

    public Blog(Integer id, String title, String content, Date release_datetime, Date lastest_upload_datetime, Integer author_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.release_datetime = release_datetime;
        this.lastest_upload_datetime = lastest_upload_datetime;
        this.author_id = author_id;
    }
}
