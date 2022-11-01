package service.bean;

import java.util.Arrays;

/**
 * @DATE: 2022/10/31 13:26
 * @PROJECT_NAME: helloSpring01
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Guys {
    private String[] hobbies;


    private Woman[] womens;

    public Woman[] getWomens() {
        return womens;
    }

    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    @Override
    public String toString() {
        return "Guys{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", womens=" + Arrays.toString(womens) +
                '}';
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
