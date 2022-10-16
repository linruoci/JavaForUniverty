import java.io.FileReader;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @author: 帅哥
 * @DATE: 2022/10/7 23:13
 * @DESCRIPTION: 文件字符输出流， 只能读取普通文本， 读取文本内容时， 比较方便
 */
public class FileReaderTest01 {


    public static void main(String[] args) {

        try (FileReader reader = new FileReader("tempFile.txt")){

            char[] chars = new char[1024];

            int readCount = 0;
            while ((readCount = reader.read(chars)) != -1){

                System.out.println(new String(chars, 0, readCount));

            }

        } catch (IOException e){

            e.printStackTrace();

        }



    }

}
