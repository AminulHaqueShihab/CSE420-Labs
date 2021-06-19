
package Lab1;

/**
 *
 * @author Asus
 */
import java.io.*;
import java.util.*;
public class lexicalAnalyzer {
    
    static ArrayList<String> keywords = new ArrayList(Arrays.asList("abstract", "assert", "boolean", "break", "byte",
                                                                    "case", "catch", "char", "class", "const",
                                                                    "continue", "default", "do", "double", "else",
                                                                    "enum", "extends", "final", "finally", "float",
                                                                    "for", "goto", "if", "implements", "import",
                                                                    "instanceof", "int", "interface", "long", "native",
                                                                    "new", "package", "private", "protected", "public",
                                                                    "return", "short", "static", "strictfp", "super",
                                                                    "switch", "synchronized", "this", "throw", "throws",
                                                                    "transient", "try", "void", "volatile", "while"));
    static ArrayList<String> identifiers = new ArrayList(Arrays.asList("a", "b", "c", "d", "e",
                                                                    "f", "g", "h", "i", "j",
                                                                    "k", "l", "m", "n", "o",
                                                                    "p", "q", "r", "s", "t",
                                                                    "u", "v", "w", "x", "y", "z"));
    static ArrayList<String> mathOp = new ArrayList(Arrays.asList("+", "-", "*", "/", "=", "%", "++", "--"));
    static ArrayList<String> logicalOp = new ArrayList(Arrays.asList("!", "<", ">", "<=", ">=", "!=", "&&", "||"));
    static ArrayList<String> others = new ArrayList(Arrays.asList(":", ";", ",", ".", "[", "]", "{", "}", "(", ")"));
    
    
    static Set<String> keywordIn = new HashSet<>();
    static Set<String> identifierIn= new HashSet<>();
    static Set<String> mathOpIn = new HashSet<>();
    static Set<String> logOpIn = new HashSet<>();
    static Set<String> numValueIn = new HashSet<>();
    static Set<String> otherIn = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException{
        File f= new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\CSE420\\src\\Lab1\\input.txt");
        try{
            Scanner sc=new Scanner(f);
            ArrayList<String> tokens = new ArrayList<String>();
            while(sc.hasNextLine()){
                String s=sc.nextLine();
                String [] str = s.split("\\s");
                
                for(String k:str){
                    String[] temp=k.split(",");
                    String[] temp2=temp[0].split(";");
                    tokens.add(temp2[0]);                
                }
                for(String i:str){
                    String [] s2 = i.split("\\w+");
                    
                    for(String j:s2){
                        tokens.add(j);
                    }
                }
            }
            

            for (String i : tokens) {
                if (keywords.contains(i)) {
                    keywordIn.add(i);
                } else if (identifiers.contains(i)) {
                    identifierIn.add(i);
                } else if (mathOp.contains(i)) {
                    mathOpIn.add(i);
                } else if (logicalOp.contains(i)) {
                    logOpIn.add(i);
                } else if (others.contains(i)){
                    otherIn.add(i);
                } else {
                    numValueIn.add(i);
                }
            }
            
            
            System.out.print("Keywords: ");
            for (String i : keywordIn) {
                System.out.print(i + ", ");
            }
            System.out.println();

            System.out.print("Identifiers: ");
            for (String i : identifierIn) {
                System.out.print(i + ", ");
            }
            System.out.println();

            System.out.print("Math Operators: ");
            for (String i : mathOpIn) {
                System.out.print(i + ", ");
            }
            System.out.println();

            System.out.print("Logical Operators: ");
            for (String i : logOpIn) {
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.print("Numerical Values: ");
            for (String i : numValueIn) {
                System.out.print(i + ", ");
            }
            System.out.println();

            System.out.print("Others: ");
            for (String i : otherIn) {
                System.out.print(i + " ");
            }
            System.out.println();
            
            
        } catch(Exception e){
            System.out.println("file not found!!");
        } 
        
    }
    
}

