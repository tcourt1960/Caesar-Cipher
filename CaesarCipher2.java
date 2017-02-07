

/**
 * This Class extends Caesar Cipher to include Object Oriented programming practices
 * 
 * @author Tom Courtney 
 * @version Feb 7, 2017*/

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher2 {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher2(int key){
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        mainKey = key;
    }
    
    
public boolean isEven(int n){
    if ((n % 2) == 0) return true; else return false; 
}
    
public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);

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
    
public String decrypt(String input) {
    CaesarCipher2 cc = new CaesarCipher2(26 - mainKey);
    return cc.encrypt(input);
}
    
    
public void testCaesarCipher() {
   int key = 15;
   FileResource fr = new FileResource();
   String message = fr.asString();
   message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
   String encrypted = encrypt(message);
   System.out.println("key is " + key + "\n" + encrypted);
   String decrypted = encrypt(encrypted);
   System.out.println(decrypted);
}
    
 public String encryptTwoKeys(String input, int key1, int key2){
 String encrypt1 = encrypt(input);
 String encrypt2 = encrypt(input);
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

