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
}
	
	
public void demonstratePanel() throws InterruptedException, IOException {
	
	Scanner text = new Scanner(new File(this.filename));
	Font f = new Font("Courier", Font.BOLD, this.fontSize);
	DrawingPanel panel = new DrawingPanel(100, 100);
	Graphics g = panel.getGraphics();
	g.setFont(f);
	
    
	while (text.hasNext()) {
   	g.setColor(Color.black);
    g.drawString(text.next(), 50, 50);
    Thread.sleep(200);
    g.setColor(Color.white);
    g.fillRect(0, 0, 399, 399);
    }
	text.close();
    
}



public static void main(String[] args) throws InterruptedException, IOException {
	
	System.out.println("HIE");
	String filename = args[0];
	int width = Integer.parseInt(args[1]);
	int height = Integer.parseInt(args[2]);
	int fontSize = Integer.parseInt(args[3]);
	int wpm = Integer.parseInt(args[4]);
	
	
	SpeedReader sReader = new SpeedReader(filename, width, height, fontSize,wpm);
	sReader.demonstratePanel();
	
	
	}
}