
package Lab3;

import java.util.*;
import java.util.regex.*;

public class lab03 {
    
    static Queue<String> q=new LinkedList<String>();
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Number of RE:");
        int n = sc.nextInt();
        String[] arr = new String [n];
        
        for (int  i = 0 ; i < n ; i++){
          System.out.println("Enter RE no. "+ (i+1));
          arr[i] = sc.next();
        }

        System.out.println("Number of Sentences:");
        n = sc.nextInt();
        
        for (int  i = 0 ; i < n ; i++){
          System.out.println("Enter Sentence no. "+ (i+1));
          q.add(sc.next());
        }

        while (!q.isEmpty()) {
            
            boolean flag = false;
            String s=q.remove();
            
            for(int i=0; i<arr.length; i++){
                flag = Pattern.matches(arr[i], s);
                if(flag==true){
                    System.out.println("Yes, " + (i+1));
                    break;
                }
            }
            
            if(flag==false)
                System.out.println("No, " + "0");
        }

    }
}
