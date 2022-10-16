import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @DATE: 2022/10/12 10:15
 * @PROJECT_NAME: TestDemo
 * @author: 帅哥
 * @DESCRIPTION: BufferReader 带有缓冲区的字符输入流。
 * 使用这个类不需要定义char数组或者byte数组
 */


public class BufferReaderTest01 {


    public static void main(String[] args) {



        try (FileReader fileReader = new FileReader("./aboutIO/src/BufferReaderTest01.java");
             BufferedReader reader = new BufferedReader(fileReader)){

            String str = new String();
            while ((str = reader.readLine()) != null){

                System.out.print(str);



            }

        } catch (IOException e){


        }

    }


}
