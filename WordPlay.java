
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class WordPlay {

    public boolean IsVowel(char ch){
        char lower = Character.toLowerCase(ch);
        if ( (lower=='a') || (lower=='e') || (lower=='i') || (lower=='o') || (lower=='u'))
            return true;
        else return false;
    }
    
    public void test_isVowel(){
        char test1 = 'e';
        char test2 = 'a';
        char test3 = 'B';
      System.out.println("Is " +test1 + " vowel " + IsVowel(test1));
      System.out.println("Is " +test2 + " vowel " + IsVowel(test2));
      System.out.println("Is " +test3 + " vowel " + IsVowel(test3));
    }
    
    public String replaceVowels(String phrase, char ch){
        String newString ="";
        for (int i=0; i<phrase.length();i++){
            char currChar =phrase.charAt(i);
            if (IsVowel(currChar))
                newString = newString+ch;
            else    
                newString =newString+currChar;
        }
        return newString;
    }
    
    public void test_replaceVowels(){
    System.out.println("Hello World" + " " + replaceVowels("HELLO World",'*'));    
    }
    
    
    public boolean isEven(int n){
        if ((n % 2) == 0) return true; else return false;
        
    }
    
    public String emphasize(String phrase, char ch){
        String newString ="";
        for (int i=0; i<phrase.length();i++){
              
            char currChar = phrase.charAt(i);

            if (Character.toLowerCase(currChar)==ch) {
               if (isEven(i+1)) newString=newString + "+";
               else newString=newString + "*";
               }
               else newString=newString + currChar;
        }
        return newString;
        
    }
    
    public void test_emphasize(){
    String test1 = "dna ctgaaactga";
    String test2 = "Mary Bella Abracadabra";
    System.out.println(test1);
    System.out.println(emphasize(test1,'a'));
    System.out.println(test2);
    System.out.println(emphasize(test2,'a'));
    }
    
    
    
}
