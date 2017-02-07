
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {

    
    
   public String halfOfString(String message, int start){
       String halfMessage = "";
       for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
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
