package TPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TetrisBoard extends JPanel {
	
	public static Rectangles [][] rectangles = new Rectangles [15][10];
	JPanel [] panels = new JPanel [15] ;
	Tetrimino moved = null;
	
	final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    final String MOVE_RIGHT = "move right";
    final String MOVE_LEFT = "move left";
    final String ROTATE = "move rotate";

    JLabel obj1 = new JLabel();
    JLabel obj2 = new JLabel();
	
	public TetrisBoard(){
		for (int i = 0; i < 15; i++){
			JPanel tmp = new JPanel();
			tmp.setBackground(Color.white);
			tmp.setVisible(true);
			for ( int j =0; j < 10; j++){
				rectangles[i][j] = new Rectangles(Color.DARK_GRAY);
				Color color = rectangles[i][j].getColor();
				rectangles[i][j].setBackground(color); 
				tmp.add(rectangles[i][j]);
			}
			

			panels[i] = tmp;
		}
		
		for (int i = 0; i < 15; i++){
			add(panels[i]);
		}



	    obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
	    obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
	    obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("R"), ROTATE);    
        obj1.getActionMap().put(MOVE_RIGHT, new MoveActionR());
	    obj1.getActionMap().put(MOVE_LEFT, new MoveActionL());
	    obj1.getActionMap().put(ROTATE, new RotateAction());
	    
	    
	    add(obj1);
	        
		setBackground(Color.white);
		setPreferredSize(new Dimension(400,625));
		setVisible (true);
		
	}
	
	protected void Update(){
		for (int i = 0; i < 15;i++){
			for(int j =0; j < 10; j++){
				Color color = rectangles[i][j].getColor();
				rectangles[i][j].setBackground(color);
			}
		}
	}
	
	private class MoveActionR extends AbstractAction{

		public void actionPerformed(ActionEvent e) {
			moved.right();
		}
		
	}
	
	private class MoveActionL extends AbstractAction{

		public void actionPerformed(ActionEvent e) {
			moved.left();
		}
		
	}
	
	private class RotateAction extends AbstractAction{

		public void actionPerformed(ActionEvent e) {
			moved.rotate();
		}
		
	}
	
	public void CheckIfDelete(){
		boolean key = true;
		int counter =0;
		
		for (int i = 0; i < 15;i++){
			for(int j =0; j< 10;j++){
				if (!(rectangles[i][j].getColor()  == Color.RED  || rectangles[i][j].getColor()  == Color.DARK_GRAY)){
					counter+=1;

			}
				if (counter == 10){
						for(int z =i; z >= 1;z--){
							for(int k=0; k < 10; k++ ){
								

							rectangles[z][k].setColor(rectangles[z-1][k].getColor());
							}
						}
						}
				
				//}
				
			}
			counter = 0;			
			System.out.println();


		}
		

		
		

	}
	
	public void AssignT(Tetrimino tmp){
		moved = tmp;
	}
	
	static public void main (String [] args){
		TetrisBoard what = new TetrisBoard();
		
		TetrisController TC = new TetrisController(what, new TetrisView(what));
		
		
	}

	
}
