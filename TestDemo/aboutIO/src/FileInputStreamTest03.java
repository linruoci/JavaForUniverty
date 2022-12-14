import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/7 16:15
 */


public class FileInputStreamTest03 {

    public static void main(String[] args) {

        FileInputStream file = null;

        try {
            file = new FileInputStream("tempFile.txt");
            byte[] bytes = new byte[4];

            //成功读到的字节数。
            int readCount = file.read(bytes);
            System.out.println(readCount);
            System.out.println(new String(bytes, 0, readCount, "utf-8"));

            readCount = file.read(bytes);
            System.out.println(readCount);
            System.out.println(new String(bytes, 0, readCount));


            readCount = file.read(bytes);
            System.out.println(readCount);



        } catch (IOException e) {

            throw new RuntimeException(e);

        } finally {

            if (file != null ){

                try {
                    file.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }

    }


}
