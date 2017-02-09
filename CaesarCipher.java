
/**
 * Write a description of CaesarCipher here.
 * 
 * @author Tom Courtney 
 * @version Feb 2, 2017*/

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher {
    
public boolean isEven(int n){
    if ((n % 2) == 0) return true; else return false; 
}
    
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
   int key = 15;
   //FileResource fr = new FileResource();
   //String message = fr.asString();
  String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
   String encrypted = encrypt(message, key);
   System.out.println("key is " + key + "\n" + encrypted);
   String decrypted = encrypt(encrypted, 26-key);
   System.out.println(decrypted);
}
    
 public String encryptTwoKeys(String input, int key1, int key2){
 String encrypt1 = encrypt(input, key1);
 String encrypt2 = encrypt(input, key2);
 StringBuilder encrypted= new StringBuilder(input);
 
    for (int i=0; i< input.length();i=i+1){
        if (isEven(i))
            encrypted.setCharAt(i, encrypt1.charAt(i));
            
        if (!isEven(i))encrypted.setCharAt(i, encrypt2.charAt(i));
    }
    
    return encrypted.toString();   
 }
    
 public void test_encryptTwoKeys(){
     String input = "Eren and Emily have evil eerie green eyes";
     int key1 = 22;
     int key2 = 19;
     System.out.println(input);
     System.out.println(encryptTwoKeys(input, key1, key2));
}

}
