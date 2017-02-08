
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
       FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
       String message = resource.asString();

       CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
       String encrypted = cc.encrypt(message);
       String decrypted = cc.decrypt(encrypted);
       System.out.println(message);
       System.out.println(encrypted);
       System.out.println(decrypted);
       System.out.println("Encrypted message is: " + encrypted);
       String codeBreak = breakCaesarCipher(encrypted);
       System.out.println("Code break answer is: " + codeBreak);
    }
    
    public int getKey(String e_message){
       int[] freqs = countLetters(e_message);
       int maxDex = maxIndex(freqs);
       int dkey = maxDex-4;
       if (maxDex < 4) {
           dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    
    public String breakCaesarCipher(String encrypted){
       CaesarCipher cc1 = new CaesarCipher();
       CaesarCipher cc2 = new CaesarCipher();
       
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
    
       int k1= getKey(message1);
       int k2= getKey(message2);
       
       System.out.println("This is CodeBreak Section");
       System.out.println("Keys found are " + k1 + "  " + k2);
       
       CaesarCipherTwo cc3 = new CaesarCipherTwo(k1, k2);
       
       String theAnswer=cc3.decrypt(encrypted);
       
       return theAnswer.toString();
        
        
    }
    
}
