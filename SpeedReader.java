package hw02;
import java.awt.*;

public class SpeedReader {
	public String filename;
	public int width;
	public int height;
	public int fontSize;
	public int wpm;


public void demonstratePanel() {
    DrawingPanel panel = new DrawingPanel(400, 300);
    Graphics g = panel.getGraphics();
    Font f = new Font("Courier", Font.BOLD, 46);
    g.setFont(f);
    g.drawString("Hello World!", 100, 100);
}

public void printStaggered() throws InterruptedException {
    while(true) {
        System.out.println("Hello World");
        Thread.sleep(1000);
    }
}




}



