import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    public static void main(String[] args) {

        //怎么获取一个时间?
        //在这里的话，需要借助我们的两个类。

        Date date = new Date();

        System.out.println("不加格式化的:> " + date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(date);

        System.out.println(now);


    }

}