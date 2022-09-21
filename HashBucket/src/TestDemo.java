import java.util.HashMap;
import java.util.Map;

/**
 * @PROJECT_NAME: HashBucket
 * @DESCRIPTION:
 * @USER: 帅哥
 * @DATE: 2022/9/13 21:37
 */
public class TestDemo {


    public static void main(String[] args) {

        HashBucket hashBucket = new HashBucket();

        hashBucket.put(9, 88);
        hashBucket.put(15, 88);
        hashBucket.put(17, 88);
        hashBucket.put(26, 88);
        hashBucket.put(36, 88);

        hashBucket.put(18, 88);
        hashBucket.put(10, 88);
        System.out.println("fafafa");


    }


}
