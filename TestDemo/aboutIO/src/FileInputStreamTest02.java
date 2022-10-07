import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION: 对第一个程序进行改进
 * @author: 帅哥
 * @DATE: 2022/10/7 15:53
 */
public class FileInputStreamTest02 {

    public static void main(String[] args) {

//        try (FileInputStream file = new FileInputStream("D:\\JavaForUniverty\\temp.txt");){
//
//
//        } catch (IOException e){
//
//            e.printStackTrace();
//
//        }

        FileInputStream file = null;
        try {

            file = new FileInputStream("D:\\JavaForUniverty\\temp.txt");


            int rec = 0;
            while ((rec = file.read()) != -1){


                System.out.println(rec);
            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        } finally{

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
