import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION: 使用FileInputStream和FileOutPutStream完成对文件的拷贝, 这两者配合， 无论是什么文件，都能完成拷贝。
 * @author: 帅哥
 * @DATE: 2022/10/7 22:18
 */
public class Copy01 {

    public static void main(String[] args) {

        try (FileOutputStream fileOut = new FileOutputStream("lucy02.png");
                FileInputStream fileIn = new FileInputStream("lucy01.png")){

            byte[] readIn = new byte[1024];

            int readCount = 0;

            while ((readCount = fileIn.read(readIn)) != -1){

                fileOut.write(readIn, 0, readCount);


            }


        } catch (IOException e){

            e.printStackTrace();

        }

    }


}
