package jdbc;

import java.util.Properties;

/**
 * @DATE: 2022/11/2 18:27
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class DBUtil2 {

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DBUtil1{" +
                "properties=" + properties +
                '}';
    }
}

