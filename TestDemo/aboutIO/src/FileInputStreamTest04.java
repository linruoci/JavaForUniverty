import java.io.FileInputStream;
import java.io.IOException;

/**
 * @PROJECT_NAME: TestDemo
 * @DESCRIPTION:
 * @author: 帅哥
 * @DATE: 2022/10/7 17:11
 */
public class FileInputStreamTest04 {


    public static void main(String[] args) {

        FileInputStream file = null;
        try {
            file = new FileInputStream("tempFile.txt");
            byte[] bytes = new byte[1024];

//            while (true){
//
//                int readCount = file.read(bytes);
//
//                if (readCount == -1){
//                    break;
//                }
//
//                System.out.print(new String(bytes, 0, readCount, "utf-8"));
//
//
//            }
            System.out.println("总字节数量>" + file.available());
            int readCount = 0;
            readCount = file.read();
            System.out.println(readCount);
//            while ((readCount = file.read()) != -1){
//
//                System.out.println(readCount);
//
//            }



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
