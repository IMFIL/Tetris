package TPackage;

import java.awt.Color;
import java.util.*;

public abstract class Tetrimino {
	Point [] points = new Point[4];
	Rectangles [] recs = new Rectangles [4];
	
	public abstract void rotate();
	
	public void colorC(){
		TetrisBoard.rectangles[points[0].x][points[0].y].removeAll();
		TetrisBoard.rectangles[points[1].x][points[1].y].removeAll();
		TetrisBoard.rectangles[points[2].x][points[2].y].removeAll();
		TetrisBoard.rectangles[points[3].x][points[3].y].removeAll();
		
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(Color.RED);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(Color.RED);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(Color.RED);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(Color.RED);

		
		
		
		
	}
	
	public void right() {
		boolean canmove = true;
		boolean possible = true;
		
		TetrisBoard.rectangles[points[0].x][points[0].y].removeAll();
		TetrisBoard.rectangles[points[1].x][points[1].y].removeAll();
		TetrisBoard.rectangles[points[2].x][points[2].y].removeAll();
		TetrisBoard.rectangles[points[3].x][points[3].y].removeAll();
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(Color.DARK_GRAY);	
		

		
			if(points[3].y >= 9){
				canmove = false;
			
		}
		    for (int i =0; i< 4;i++){
				 if (points[i].y == 9){
					 possible = false;
				 }

		    }
		    if(possible){
			for (int i =0; i < 4; i++){
				if (!(TetrisBoard.rectangles[points[i].x][points[i].y + 1].getColor()  == Color.RED  || TetrisBoard.rectangles[points[i].x][points[i].y + 1].getColor()  == Color.DARK_GRAY)){
					canmove = false;
				}
		}
		    }
		if(canmove){
		for (int i =0; i < 4; i++){
			points[i].IncrementX();		
		}
		
	}
	}

	public void left() {
		
		boolean canmove = true;
		boolean possible = true;
		
		TetrisBoard.rectangles[points[0].x][points[0].y].removeAll();
		TetrisBoard.rectangles[points[1].x][points[1].y].removeAll();
		TetrisBoard.rectangles[points[2].x][points[2].y].removeAll();
		TetrisBoard.rectangles[points[3].x][points[3].y].removeAll();
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(Color.DARK_GRAY);	
		
		
			if(points[0].y == 0){
				
				canmove = false;
		}
		    for (int i =0; i< 4;i++){
				 if (points[i].y == 0){
					 possible = false;
				 }

		    }
		    if(possible){
			for (int i =0; i < 4; i++){
				if (!(TetrisBoard.rectangles[points[i].x][points[i].y - 1].getColor()  == Color.RED  || TetrisBoard.rectangles[points[i].x][points[i].y -1].getColor()  == Color.DARK_GRAY)){
					canmove = false;
				}
		}
		    }
		if(canmove){
		for (int i =0; i < 4; i++){
			points[i].DecrementX();

		}
		
	}
		
	}
	public void changeRec(){
		
		recs[0] = TetrisBoard.rectangles[points[0].x][points[0].y];
		recs[1] = TetrisBoard.rectangles[points[1].x][points[1].y];
		recs[2] = TetrisBoard.rectangles[points[2].x][points[2].y];
		recs[3] = TetrisBoard.rectangles[points[3].x][points[3].y];	

	}
	
	public void reset(){
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(Color.DARK_GRAY);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(Color.DARK_GRAY);
	}
	
	public boolean down(){
		
		for (int i =0; i < 4; i++){
			if (!(TetrisBoard.rectangles[points[i].x + 1][points[i].y].getColor()  == Color.RED  || TetrisBoard.rectangles[points[i].x + 1][points[i].y].getColor()  == Color.DARK_GRAY)){
				return false;
			}
	}
		
		for (int i =0; i < 4; i++){
			if (points[i].x  == 13){
				return false;
			}
		}
			
		
		for (int i =0; i < 4; i++){
			points[i].DecrementY();
		}
		
		return true;
		

	}
	
	public void setDone(){
		
		Random rand = new Random();
		
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		Color color = new Color(r,g,b);
		
		TetrisBoard.rectangles[points[0].x][points[0].y].setColor(color);
		TetrisBoard.rectangles[points[1].x][points[1].y].setColor(color);
		TetrisBoard.rectangles[points[2].x][points[2].y].setColor(color);
		TetrisBoard.rectangles[points[3].x][points[3].y].setColor(color);
		
	}
	
	public boolean checkiflosst(){
		
		for (int i =0; i < 4; i++){
			if (points[i].x  == 0){
				return false;
			}
		}
		return true;
	}
	

	
}
