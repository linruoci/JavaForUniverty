import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @DATE: 2022/10/8 23:20
 * @PROJECT_NAME: TestDemo
 * @author: 帅哥
 * @DESCRIPTION:
 */
public class Copy02 {


    public static void main(String[] args) {

        try (FileReader fileIn = new FileReader("myfile.txt"); FileWriter fileOut = new FileWriter("myfile2.txt");){

            char[] ch = new char[4];

            int readCount = 0;

            fileIn.read(ch);

            System.out.println(Arrays.toString(ch));

            fileIn.read(ch);

            System.out.println(Arrays.toString(ch));




        } catch (IOException e){

            e.printStackTrace();

        }



    }

}
