
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if (Character.isLowerCase(currChar)) newChar=Character.toLowerCase(newChar);
                if (Character.isUpperCase(currChar)) newChar=Character.toUpperCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
public void testCaesar() {
   int key = 17;
   FileResource fr = new FileResource();
   String message = fr.asString();
   message = "First Legion";
   String encrypted = encrypt(message, key);
   System.out.println("key is " + key + "\n" + encrypted);
   String decrypted = encrypt(encrypted, 26-key);
   System.out.println(decrypted);
}
    
 public String encryptTwoKeys(String input, int key1, int key2){
 String oddInput = "";
 String evenInput = "";
    for (int i=0; i< input.length();i=(i+2)){
        oddInput = oddInput + input.charAt(i);
        evenInput = evenInput + input.charAt(i+1);
    }
    
  
    System.out.println(oddInput + "   " + evenInput);
    return "Almost there";   
 }
    
 public void test_encryptTwoKeys(){
     String input = "First Legion";
     int key1 = 23;
     int key2 = 17;
     System.out.println(input);
     System.out.println(encryptTwoKeys(input, key1, key2));
}

}
