package userdao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @DATE: 2022/10/30 14:19
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class VipDao {
    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);
    public void save(){
        logger.info("正在保存vip信息！！！");
    }

}
