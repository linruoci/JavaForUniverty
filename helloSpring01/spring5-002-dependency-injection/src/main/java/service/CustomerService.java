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

    public CustomerService(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void save(){
        vipDao.save();
    }


}
