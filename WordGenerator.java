package hw02;
import java.util.Scanner;
import java.io.*;
import java.io.File;




public class WordGenerator {

    public String filename;
    public Scanner text = null;
    public int wordCounter = 0;
    public int sentenceCounter = 0;

    public WordGenerator(String filename) throws IOException {
        this.filename = filename;
        this.text = new Scanner(new File(filename));
    }

    public boolean hasNext() {
        return text.hasNext();
    }

    public String next() {
        String nextToken = text.next();
        return nextToken;
    }

    public int getWordCount() {
        while(text.hasNext()) {
        	if(text.next().equals(null)){
        		break;
        	}
            wordCounter += 1;
        }
        
        return wordCounter;
     }
    
    public int getSentenceCount() {

    	
    	while(text.hasNext()) {
 
    String nextToken = text.next();
    String ch = Character.toString(nextToken.charAt(nextToken.length() -1));
    System.out.println(ch);
    	if(ch.equals(".") || ch.equals("!") || ch.equals("?")) {
   
    		sentenceCounter = sentenceCounter + 1;
    	}
    	}   	
    	return sentenceCounter;
    }
    	

    public static void main(String[] args) throws IOException  {
        WordGenerator boom = new WordGenerator("test");
       System.out.println(boom.getSentenceCount());
    }

}