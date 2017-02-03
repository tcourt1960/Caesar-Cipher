
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class WordLengths {

    public String[] getCommon(){
        FileResource resource = new FileResource("data/common.txt");
        String[] common = new String[20];
        int index = 0;
        for(String s : resource.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
    
    public int indexOf(String[] list, String word) {
        for (int k=0; k<list.length; k++) {
            if (list[k].equals(word)) {
                   return k;
               }
           }
        return -1;
    }
    
    public void countWordLengths(FileResource resource,  int[] counts){
        for(String word : resource.words()){
            int adjustedLength = word.length();
            for(int k=0; k<word.length();k++){
              if( (k==0) || (k==(word.length()-1) )) {
                  if (!Character.isLetter(word.charAt(k))) adjustedLength--;}
            }
            counts[adjustedLength]++;      
    }
}
    
void test_countWordLengths(){
    String[] plays = {"smallHamlet.txt"};
    int[] counts = new int[30];
    for(int k=0; k < plays.length; k++){
        FileResource resource = new FileResource("data/" + plays[k]);
        countWordLengths(resource,counts);
        System.out.println("done with " + plays[k]);
    }
    
    for(int k=0; k < counts.length; k++){
        System.out.println(k + "  " + counts[k]);
    }
    
    System.out.println("Index of Max count is " + indexOfMax(counts));
}


public int indexOfMax(int[] values){
    int maxIndex = 0;
    int maxCount = 0;
    
    for (int k=0; k<values.length; k++){
        if (values[k]>maxCount) {
            maxIndex=k;
            maxCount=values[k];
        }
    }
    return maxIndex;
}


}
