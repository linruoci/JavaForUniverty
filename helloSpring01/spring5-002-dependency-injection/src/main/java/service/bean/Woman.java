package service.bean;

/**
 * @DATE: 2022/10/31 13:31
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Woman {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Women{" +
                "name='" + name + '\'' +
                '}';
    }
}
