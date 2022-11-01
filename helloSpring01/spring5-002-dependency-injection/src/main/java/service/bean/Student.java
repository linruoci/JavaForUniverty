package service.bean;

/**
 * @DATE: 2022/10/31 13:03
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Student {
    private String name;
    private Clazz clazz;

    public String getName() {
        return name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
