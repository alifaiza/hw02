package hw02;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class SpeedReader {
//	public String filename;
//	public int width;
//	public int height;
//	public int fontSize;
//	public int wpm;
//
//

	public static void main(String[] args) throws InterruptedException, IOException {
		if (args.length != 5)  {
			System.out.println(" Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			return;
		}
		String filename = args[0];
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		int fontSize = Integer.parseInt(args[3]);
		int wpm = Integer.parseInt(args[4]);

		DrawingPanel panel = new DrawingPanel(width, height);
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, fontSize);
		g.setFont(f);
		WordGenerator boom = new WordGenerator("/src/test");
		while (boom.hasNext()) {
			g.drawString(boom.next(), 100, 100);
			Thread.sleep(60000/wpm);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);


			//SpeedReader boom = new SpeedReader("/home/alifaiza/workspace/hw02/src/hw02/test", 400, 300, 46, 45);
			//boom.demonstratePanel();

		}


	}
