package service.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @DATE: 2022/11/2 0:22
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Person {

    //注入list集合
    private List<Woman> names;
    //注入set集合
    private Set<String> addresss;



    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addresss=" + addresss +
                ", properties=" + properties +
                ", map=" + map +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<Integer, String> map) {
        this.map  = map;
    }

    private Map<Integer, String> map;

    public void setNames(List<Woman> names) {
        this.names = names;
    }


    public void setAddresss(Set<String> addresss) {
        this.addresss = addresss;
    }

    public Person() {
    }
}
