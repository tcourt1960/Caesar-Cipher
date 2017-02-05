
/**
 * Write a description of WordLength2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordLength2 {

    public int indexOfMax(int[] values){
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
    
    public void countWordLengths(FileResource resource, int[] counts){
        
  		for(String word : resource.words()){
  		    int currLength = word.length();

	        for (int i=0; i<word.length();i++){
              char currChar = word.charAt(i);
                if ( (i==0) || (i==word.length()-1) ){
                    if (!Character.isLetter(currChar)) currLength--;
                }
            }  
            counts[currLength]++;   
            System.out.println(word + " Starts L= " + word.length() + " and finishes L = " + currLength);
        }
    }
    
   public void test_countWordLengths(){
       FileResource resource = new FileResource("data/smallHamlet.txt");
       int[] counts = new int[30];
       countWordLengths(resource, counts);
       System.out.println("The End.");
       System.out.println("Most common length is " + indexOfMax(counts));
    }
}
