package TPackage;

import javax.swing.*;
import java.awt.*;

public class TetrisView extends JFrame {
	TetrisBoard tb;
	public TetrisView(TetrisBoard tb){
		super("Tetris");
		this.tb = tb;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		
		JPanel down = new JPanel();
		
		JButton quit = new JButton("Quit");
		JButton newG = new JButton("New Game");
		
		down.add(newG);
		down.add(quit);
		
		
		add(down,BorderLayout.SOUTH);
		add(tb,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	


}
