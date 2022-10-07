import java.io.FileInputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/7 15:41
 */
public class FileInputStreamTest01 {


    public static void main(String[] args) {

        FileInputStream file = null;
        try {

            file = new FileInputStream("D:\\JavaForUniverty\\temp.txt");
            int rec = file.read();
            System.out.println(rec);

            rec = file.read();
            System.out.println(rec);

            rec = file.read();
            System.out.println(rec);

            rec = file.read();
            System.out.println(rec);


            rec = file.read();
            System.out.println(rec);


            rec = file.read();
            System.out.println(rec);


        } catch (IOException e) {

            throw new RuntimeException(e);

        } finally {

            if (file != null){

                try {
                    file.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }

    }


}
