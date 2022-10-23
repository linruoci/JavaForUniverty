package model;

/**
 * @DATE: 2022/10/20 0:18
 * @PROJECT_NAME: blog-system_front_rear_separation
 * @author: 帅哥
 * @DESCRIPTION: 实体类， 用来表示数据库里user表的一条记录
 */
public class User {

    private int userId;
    private String username;
    private String password;

    private int isYourBlog;

    public int getIsYourBlog() {
        return isYourBlog;
    }

    public void setIsYourBlog(int isYourBlog) {
        this.isYourBlog = isYourBlog;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
