//package hw02;
//import java.util.Scanner;
//import java.io.*;
//import java.io.File;
//
//
//
//
//public class WordGenerator {
//
//	public String filename;
//	public Scanner text = null;
//	public int wordCounter = 0;
//	public int sentenceCounter = 0;
//
//	public WordGenerator(String filename) throws IOException {
//		this.filename = filename;
//		this.text = new Scanner(new File(filename));
//	}
//
//	public boolean hasNext() {
//		return text.hasNext();
//	}
//
//	public String next() {
//		String nextToken = text.next();
//		return nextToken;
//	}
//
//	public int getWordCount() {
//		
//		while(text.hasNext()) {
//			String nextToken = text.next();
//			String ch = Character.toString(nextToken.charAt(nextToken.length() -1));
//			if(ch.equals){
//			//	break;
//				//}
//			wordCounter = wordCounter + 1;
//		}
//	}
//	return wordCounter;
//	}
//
//	public int getSentenceCount() {
//
//
//		while(text.hasNext()) {
//
//			String nextToken = text.next();
//			String ch = Character.toString(nextToken.charAt(nextToken.length() -1));
//			//System.out.println(ch);
//			if(ch.equals(".") || ch.equals("!") || ch.equals("?")) {
//
//				sentenceCounter = sentenceCounter + 1;
//			}
//		}   	
//		return sentenceCounter;
//	}
//
//
//	public static void main(String[] args) throws IOException  {
//		WordGenerator boom = new WordGenerator("/home/alifaiza/workspace/hw02/src/hw02/test");
//		System.out.println(boom.getSentenceCount());
//		System.out.println(boom.getWordCount());
//	}
//
//}




package hw02;
import java.util.Scanner;
import java.io.*;
import java.io.File;




public class WordGenerator {

	public String filename;
	public Scanner text = null;
	public int wordCounter = 0;
	public int sentenceCounter = 0;

	public WordGenerator(String filename) throws IOException  {
		this.filename = filename;
	}

	public boolean hasNext()  {
		return text.hasNext();
	}

	public String next() throws IOException  {
		this.text = new Scanner(new File(filename));
		String nextToken = text.next();
		text.close();
		return nextToken;
	}

	public int getWordCount() throws IOException  {
		this.text = new Scanner(new File(filename));
		while(text.hasNext())  {
			if(text.next().equals(null))  {
				break;
			}
			wordCounter += 1;
		}
		text.close();
		return wordCounter;
	}

	public int getSentenceCount() throws IOException  {

		this.text = new Scanner(new File(filename));
		while(text.hasNext())  {
			String nextToken = text.next();
			String ch = Character.toString(nextToken.charAt(nextToken.length() -1));
			if(ch.equals(".") || ch.equals("!") || ch.equals("?"))  {
				sentenceCounter = sentenceCounter + 1;
			}
		}  
		text.close();
		return sentenceCounter;
	}


	public static void main(String[] args) throws IOException  {
		WordGenerator boom = new WordGenerator("/home/alifaiza/workspace/hw02/src/hw02/test");
		System.out.println(boom.getSentenceCount());
		System.out.println(boom.getWordCount());
	}

}
