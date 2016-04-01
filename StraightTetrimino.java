package TPackage;

import java.awt.Color;

public class StraightTetrimino extends Tetrimino {
	
	int rotationstate = 0;    /* 0 is for horizontal and 1 is for vertical */
	// --------> is Y
	//
	// ^
	// |
	// |
	// |
	// | is X
	
	public StraightTetrimino(){
		//CHANGE
		points[0] = new Point(1,0);
		points[1] = new Point(1,1);
		points[2] = new Point(1,2);
		points[3] = new Point(1,3);
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
		if(rotationstate == 0){
			
			if (points[0].x < 14 && points[0].x > 0){
				
				
				points[0].y = points[1].y;
				points[0].x = points[1].x - 1;
				
				points[2].y = points[1].y;
				points[2].x = points[1].x + 1;
				
				points[3].y = points[1].y;
				points[3].x = points[1].x + 2;
				
				rotationstate = 1;
			}

		}
		else {
			
			if (points[3].y < 9 && points[3].y > 1 ){
				points[0].y = points[1].y+1;
				points[0].x = points[1].x;
				
				points[2].y = points[1].y-1;
				points[2].x = points[1].x;
			    points[3].y = points[1].y-2;
				points[3].x = points[1].x;
				
				rotationstate = 0;
			}
			
		}
	}
	

	



	}


