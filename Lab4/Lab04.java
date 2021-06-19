package Lab4;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab04 {
    
    static int index;
    static String str;
    static Pattern p= Pattern.compile("(public|protected|private)(\\s(static))* \\w+ \\w+\\(.*\\) *");
    static Matcher m;
    
    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\CSE420\\src\\Lab4\\input.txt"));
        System.out.println("Methods:");
        while(sc.hasNext()){
            str=sc.nextLine();
            m= p.matcher(str);
            if(m.matches()){
                //for method
//                Pattern p2 = Pattern.compile("\\w+\\(.*\\)");
//                m= p2.matcher(str);
//                if(m.find())
//                    index = m.start();
//                String method=str.substring(index);
                
                //for type
                Pattern p2 = Pattern.compile("\\w+ \\w+\\(.*\\)");
                m= p2.matcher(str);
                if(m.find())
                    index = m.start();
                String method=str.substring(index);
                String[] type = method.split(" ");

                   
                if(!method.contains("main"))
                    print(type);
//                    System.out.println(method+", return type: "+type[0]);
            }
        }
    }
    
    static void print(String [] a){
        for(int i=1; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(", return type: "+a[0]);
    }
}
