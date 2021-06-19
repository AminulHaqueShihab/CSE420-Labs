
package Lab2;

import java.util.*;
import java.io.*;
public class Lab2 {
    
    static ArrayList<Integer> webCount = new ArrayList<Integer>();
    static ArrayList<Integer> emailCount = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Number of lines:");
        int n = sc.nextInt();

        String str[] = new String[n];
        int errorCheck = 0;

        for (int i = 0 ; i < n ; i++){
          System.out.println("Enter Web/Email:");
          str[i] = sc.next();
        }
        
        for (int i = 0 ; i < n ; i++){
          String type = null;
            
            if (str[i].contains("@")) {
                mailCheck(str[i],i);
            } else if (!(str[i].contains("@")) && (str[i].contains("www."))) {
                webCheck(str[i],i);
            }   
        }
        
        //print
        System.out.print("Email, ");
        for(int i = 0 ; i < emailCount.size() ; i++){
          System.out.print(emailCount.get(i)+" ");
        }
        System.out.println();
        System.out.print("Web, ");
        for(int i = 0 ; i < webCount.size() ; i++){
          System.out.print(webCount.get(i)+" ");
        }
        System.out.println();
        
        
    }

    static void webCheck(String s, int line){
        String[] split = s.split("\\.");
        int countWeb = 0;

        for (int i = 0; i < split.length; i++) {
            char[] ch = split[i].toCharArray();
            int count = 0;
             
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] >= 'A' && ch[j] <= 'Z' || ch[j] >= 'a' && ch[j] <= 'z' || ch[j] >= '0' && ch[j] <= '9') {
                    count++;
                } else {
                    count--;
                }
            }
            if (count == ch.length) {
                countWeb++;
            }
        }
        if (countWeb == split.length) {
            webCount.add(line+1);
        } 
    }
    
  
    static void mailCheck(String s, int line){
        String[] split = s.split("\\@");
  
        int mailCount = 0;
        
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("\\.");
            int mail = 0;
            for (int j = 0; j < split2.length; j++) {
                char[] ch = split2[j].toCharArray();
                int count=0;
                for (int k = 0; k < ch.length; k++) {
                    if (ch[k] >= 'A' && ch[k] <= 'Z' || ch[k] >= 'a' && ch[k] <= 'z' || ch[k] >= '0' && ch[k] <= '9') {
                        count++;
                    } else {
                        count--;
                    }

                }
                if (count == ch.length) {
                    mail++;
                }

            }
            if (mail == split2.length) {
                mailCount++;
            }
        }
        if (mailCount == 2) {
            emailCount.add(line+1);
        } 
    }
}
