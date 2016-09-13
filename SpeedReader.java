package hw02;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class SpeedReader {

	public String filename;
	public int width;
	public int height;
	public int fontSize;
	public int wpm;

	public SpeedReader(String filename, int width, int height, int fontSize, int wpm) 
			throws IOException  {
		this.filename = filename;
		this.width = width;
		this.height = height;
		this.fontSize = fontSize;
		this.wpm = wpm;
	}

	public void demonstratePanel() throws InterruptedException, IOException  {

		Scanner text = new Scanner(new File(filename));
		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);

		while (text.hasNext())  {
			String word = text.next();

			//Could not completely get text centering to work
			//        FontMetrics mets = g.getFontMetrics(); 
			//		int fontHeight = mets.getHeight();
			//		int fontWidth = mets.stringWidth(word);
			//		g.drawString(word, 
			//				(int) (0.5 * height - 0.5 * fontHeight), 
			//				(int) (0.5 * width - 0.5 * fontWidth));

			g.setColor(Color.BLACK);
			g.drawString(word, 100, 100);
			Thread.sleep(60000/wpm);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
		}

		text.close();
	}



	public static void main(String[] args) throws InterruptedException, IOException  {
		if (args.length != 5)  {
			System.out.println("Invalid input! Please enter your command this way--> \n"
					+ "SpeedReader <filename> <width> <height> <fontSize> <wpm>");
			return;
		}

		String filename = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontSize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);

		WordGenerator wordGen = new WordGenerator(filename);
		SpeedReader sReader = new SpeedReader(filename, width, height, fontSize, wpm);
		sReader.demonstratePanel();
		System.out.printf("Number of sentences read: %d\n", wordGen.getSentenceCount());
		System.out.printf("Number of words read: %d", wordGen.getWordCount());

	}
}

