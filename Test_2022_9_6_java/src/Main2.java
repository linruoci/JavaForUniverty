import java.util.*;

public class Main2{
    
    
    
    public static void reverse(char[] arr, int begin, int end){


        while (begin <= end){
            
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
            
            
        }
        
        
    }
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        String str = scan.nextLine();
        
        int indexSpace = 0;
        
        char[] array = str.toCharArray();
        
        
        for (int i = 0; i < array.length; i++){
            
            int j = 0;
            for (j = i + 1; j < array.length; j++){
                
                
                if (j == array.length|| array[j] == ' '){
                    break;  
                }
          
            }
            indexSpace = j;
            reverse(array, i, j - 1);
            i = indexSpace;
            
        }
        reverse(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++){

            System.out.print(array[i]);


        }
    }
    
}