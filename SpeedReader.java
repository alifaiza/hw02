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

public SpeedReader(String filename, int width, int height, int fontSize, int wpm) throws IOException {
	this.filename = filename;
	this.width = width;
	this.height = height;
	this.fontSize = fontSize;
	this.wpm = wpm;
//	WordGenerator boom = new WordGenerator(filename);
}
	
	
public void demonstratePanel() throws InterruptedException, IOException {
	Scanner text = new Scanner(new File(filename));
	while(true) {
	DrawingPanel panel = new DrawingPanel(width, height);
    Graphics g = panel.getGraphics();
    Font f = new Font("Courier", Font.BOLD, fontSize);
    g.setFont(f);
    
    while (text.hasNext()) {
    g.drawString(text.next(), 100, 100);
    Thread.sleep(60000/wpm);
    g.clearRect(0,0,width,height);
	}
    text.close();
	}
}



public static void main(String[] args) throws InterruptedException, IOException {
	SpeedReader boom = new SpeedReader("/home/alifaiza/workspace/hw02/src/hw02/test", 400, 300, 46, 45);
	boom.demonstratePanel();
		
}


}



