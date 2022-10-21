package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @DATE: 2022/10/20 0:18
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION:实体类， 用来表示数据库里blog表的一条记录
 */
public class Blog {

    private int blogId;
    private String title;
    private String content;
    private int userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTime() {


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(this.postTime);


    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }
}
