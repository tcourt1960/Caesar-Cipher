
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestCaesarCipherTwo {

    
    
   public String halfOfString(String message, int start){
       String halfMessage = "";
       for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
   }
    
   public boolean isEven(int n){
    if ((n % 2) == 0) return true; else return false; 
   }
   
   
       public int[] countLetters(String message){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for(int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
    }
    return counts;
    }
   
   public void test_countLetters(){
       FileResource resource = new FileResource("data/romeo.txt");
       //FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
       String message = resource.asString();       
   
       int[] counts = countLetters(message);
       System.out.println("Most common length is " + maxIndex(counts));
   }
    
     public int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;
        
        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }
    
    public void simpleTests(){
       FileResource resource = new FileResource("data/smallHamlet.txt");
       String message = resource.asString();
       CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
       String encrypted = cc.encrypt(message);
       
       
        
        
    }
    
}
