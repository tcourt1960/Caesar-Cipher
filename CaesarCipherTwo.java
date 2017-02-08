
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
    public int key1, key2;
    
    public CaesarCipherTwo(int k1, int k2){
        key1=k1;
        key2=k2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
    }


    public String encrypt(String input){
     StringBuilder encrypted= new StringBuilder(input);
     String inputEven = halfOfString(input,0);
     String inputOdd = halfOfString(input,1);
     CaesarCipher2 ccEven = new CaesarCipher2(key1);
     CaesarCipher2 ccOdd = new CaesarCipher2(key2);
     String outputEven = ccEven.encrypt(inputEven);
     String outputOdd = ccOdd.encrypt(inputOdd);
     
     
            //build up the final answer
       
       for (int k=0; k<(inputEven.length());k++){
           encrypted.setCharAt((2*k), outputEven.charAt(k) );
           }
           
       for (int k=0; k<(inputOdd.length());k++){
           encrypted.setCharAt((2*k)+1, outputOdd.charAt(k) );
        }
    return encrypted.toString();   
   }
   
   public String decrypt(String input) {
       CaesarCipherTwo cc = new CaesarCipherTwo((26-key1), (26-key2));
       return cc.encrypt(input);
    }
       
   public boolean isEven(int n){
    if ((n % 2) == 0) return true; else return false; 
}
   
    public String halfOfString(String message, int start){
       String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }
   

}