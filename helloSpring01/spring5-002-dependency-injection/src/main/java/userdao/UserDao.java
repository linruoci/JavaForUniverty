package userdao;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * @DATE: 2022/10/30 13:19
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert(){
        //log4j日志框架
        logger.info("数据库正在保存用户信息");
    }

}
