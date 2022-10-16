import java.io.*;
import java.nio.Buffer;

/**
 * @DATE: 2022/10/12 14:53
 * @PROJECT_NAME: TestDemo
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class BufferWriterTest01 {


    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("./aboutIO/src/BufferWriterTest01.java"));
        BufferedWriter out = new BufferedWriter(new FileWriter("copy03.java"));

        String line = new String();

        while ((line = reader.readLine()) != null){

            out.write(line);

        }
        out.flush();



    }


}
