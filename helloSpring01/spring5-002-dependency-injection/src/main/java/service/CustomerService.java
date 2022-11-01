package service;

import userdao.UserDao;
import userdao.VipDao;

/**
 * @DATE: 2022/10/30 15:26
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class CustomerService {

    private VipDao vipDao;
    private UserDao userDao;

    public CustomerService(VipDao vipDao, UserDao userDao) {
        this.vipDao = vipDao;
        this.userDao = userDao;
    }

    public void save(){
        vipDao.save();
        userDao.insert();
    }


}
