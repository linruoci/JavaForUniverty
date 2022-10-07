import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

        } catch (FileNotFoundException e) {

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
