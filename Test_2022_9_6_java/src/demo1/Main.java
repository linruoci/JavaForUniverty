package demo1;

import java.util.*;


public class Main {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        int transfer = scan.nextInt();
        
        int n = scan.nextInt();
        
        //首先判断是否能被整除。
        
//        if (transfer % n == 0){
//
//            int bit = transfer / n;
//
//            int ans = (int)Math.pow(10, bit - 1);
//
//            System.out.println(ans);
//
//            return;
//        }
//
        //到这里是无法被整除的情况， 我们分为小于9 和大于9的情况。
        

        
        if (n < 10){
            StringBuffer ans = new StringBuffer();
            while (transfer > 0){
                
                int tmp = transfer % n;

                String str = String.valueOf(tmp);

                ans.append(str);
                
                transfer = transfer / n;
                
                
            }

            ans = ans.reverse();

            System.out.println(ans.toString());
            
        } else {
            StringBuffer ans = new StringBuffer();
            
            while (transfer > 0){
                
                int tmp = transfer % n;
                
                if (tmp > 10){
                    
                    char ch = (char)((tmp - 10) + 'a');
                    ans.append(ch + "");
                    
                } else {
                    
                    String str = String.valueOf(tmp);
                    ans.append(str);
                    
                }
                transfer = transfer / n;
                
            }
            ans = ans.reverse();
            System.out.println(ans.toString());
            
        }
        
        
        
        
    }
}