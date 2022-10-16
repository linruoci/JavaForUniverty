import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @DATE: 2022/10/12 10:59
 * @PROJECT_NAME: TestDemo
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class BufferReaderTest02 {


    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream("lucy02.png");

        InputStreamReader reader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(reader);



    }


}
