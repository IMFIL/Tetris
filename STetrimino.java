package TPackage;

import java.awt.Color;

public class STetrimino extends Tetrimino {
	
	int status = 0; /*0 -> initial, 1 -> veritcal view Work on the rotation of ALL of your tetriminos*/

	// --------> is Y
	//
	// ^
	// |
	// |
	// |
	// | is X

	public STetrimino(){
			
			points[0] = new Point(1,0);
			points[1] = new Point(1,1);
			points[2] = new Point(0,1);
			points[3] = new Point(0,2);
			
		}

	public void rotate() {
		TetrisBoard.rectangles[points[0].x][points[0].y].removeAll();
		TetrisBoard.rectangles[points[1].x][points[1].y].removeAll();
		TetrisBoard.rectangles[points[2].x][points[2].y].removeAll();
		TetrisBoard.rectangles[points[3].x][points[3].y].removeAll();
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(Color.DARK_GRAY);
		
		 if (status == 0){
			 if(points[0].x >= 1){
			 points[0].y = points[1].y;
			 points[0].x = points[1].x -1;
			 		 
			 points[2].y = points[1].y+1;
			 points[2].x = points[1].x;
			 
			 points[3].y = points[1].y+1;
			 points[3].x = points[1].x +1;
			 
			 status = 1;
		 }
			 else{
				 
			 }
		 }
		 
		 else if(status == 1){
				 if(points[0].y < 8){
					 
			     points[0].y = points[1].y-1;
			     points[0].x = points[1].x; 
				 points[2].y = points[1].y;
				 points[2].x = points[1].x -1;
				 
				 points[3].y = points[1].y + 1;
				 points[3].x = points[1].x -1;
				 
				 status = 0;
			 }
				 else{
					 
				 }
			 
		 }

	}

}
