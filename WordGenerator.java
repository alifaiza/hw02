package hw02;
import java.util.Scanner;
import java.io.*;

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
        
        if (nextToken instanceof String) {
            wordCounter = +1;
        }
        if (nextToken.endsWith(".") || nextToken.endsWith("!") || nextToken.endsWith("?")) {
            sentenceCounter += 1;
        }
        return nextToken;
    }

    public int getWordCount() {
        
        return wordCounter;
    }

    public int getSentenceCount() {

        return sentenceCounter;
    }
    
    public void printWords() {
        while (text.hasNext()) {
            System.out.println(text.next());
        }
    }
    
    public int count() {
        while (text.hasNext()) {
            return (text.getWordCount());
            //System.out.println(getSentenceCount());
            
        }
    }
    
    public static void main(String[] args) throws IOException  {
        WordGenerator boom = new WordGenerator("/home/zvidzwat/Desktop/CSC207/hw02/src/hw02/test");
        System.out.println(boom.next());
        boom.printWords();
        System.out.println(boom.count());
        System.out.println(boom.getWordCount()); 
        
    }

}