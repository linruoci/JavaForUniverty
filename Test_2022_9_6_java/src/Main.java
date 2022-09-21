import java.util.*;

public class Main{
    
    private static int size;
    private static int start;
    private static int end;

    private static int newStart;
    
    public static void getMaxLength(char[] arr, int begin){
        
        int count = 0;
        int j = 0;
        for (j = begin; j < arr.length; j++){
            
            char ch = arr[j];
            if (ch < '0' || ch > '9'){
                
                break;
                
            }
            
            count++;
        }

        newStart = j - 1;
        if (count > size){
            
            start = begin;
            end = j - 1;
            size = count;
        }
        
    }
    
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        String str = scan.nextLine();
        char[] ans = str.toCharArray();
        
        for (int i = 0; i < ans.length; i++){
            
            char ch = ans[i];
            if (ch < '0' || ch > '9'){
                
                continue;
                
            }
            
            getMaxLength(ans, i);
            
            i = newStart;
            
        }
        //在这里之后， start和end存储的是最长数字串的下标
        
        for (int i = start; i <= end; i++){
            
            char ch = ans[i];
            System.out.print(ch);
            
        }
        
        
    }
    
}