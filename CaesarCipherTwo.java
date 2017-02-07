
/**
 * Write a description of CaesarCipherTwo here.
 *   The "Two" means we have two keys, one for odd and one for even characters
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1, key2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
    }


    public String encrypt(String input){
     String encrypt1 = halfOfString(input,0);
     String encrypt2 = halfOfString(input,1);
     StringBuilder encrypted= new StringBuilder(input);
 
    for (int i=0; i< input.length();i=i+1){
        if (isEven(i))
            encrypted.setCharAt(i, encrypt1.charAt(i));
            
        if (!isEven(i))encrypted.setCharAt(i, encrypt2.charAt(i));
    }
    
    return encrypted.toString();   
   }
       
   
       public String halfOfString(String message, int start){
       String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }
   
   public String decrypt(String encrypted){
 
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       StringBuilder theAnswer = new StringBuilder(encrypted);

       
       String d_message1=cc1.encrypt(message1,(26-key1));
       String d_message2=cc1.encrypt(message2,(26-key2));
       
       //build up the final answer
       
       for (int k=0; k<(message1.length());k++){
           theAnswer.setCharAt((2*k), d_message1.charAt(k) );
           }
           
       for (int k=0; k<(message2.length());k++){
           theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
           }
           
       System.out.println(key1+" "+key2+" " + theAnswer.toString());    
        
    
       return theAnswer.toString();    
    }
    
}