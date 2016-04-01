package TPackage;
import java.awt.*;
import javax.swing.*;

public class Rectangles extends JPanel {
	private Color color;

	public Rectangles(Color color){
		
		this.color = color;
		setPreferredSize(new Dimension(30,30));
		setVisible(true);
} 
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	

	
}