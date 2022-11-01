package service;

import userdao.UserDao;
import userdao.VipDao;

/**
 * @DATE: 2022/10/30 13:28
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class UserService {

    private UserDao userDao;
    private VipDao vipDao;
    //set注入必须有set方法，
    //spring容器会调用这个set方法， 来给UserDao属性赋值


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;

    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void savaMessage(){
        userDao.insert();
        vipDao.save();
    }

}
