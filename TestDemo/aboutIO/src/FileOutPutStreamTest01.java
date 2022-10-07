import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION:文件输出流
 * @author: 帅哥
 * @DATE: 2022/10/7 21:55
 */
public class FileOutPutStreamTest01 {

    public static void main(String[] args) {

        FileOutputStream file = null;

        try {
            //这种方式谨慎使用， 会清空源文件当中的内容， 然后重新写入
            file = new FileOutputStream("myfile.txt", true);

            //开始写
            byte[] bytes = {97, 98, 99, 100, 101, 48};

            file.write(new String("新年快乐").getBytes());

            //写完之后， 一定有要刷新

        } catch (IOException e) {

            throw new RuntimeException(e);

        } finally {

            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }

}
