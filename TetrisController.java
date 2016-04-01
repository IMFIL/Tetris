package TPackage;

import java.awt.event.*;
import java.util.*;

public class TetrisController{
	
	TetrisBoard board = null;
	TetrisView view = null;
	Tetrimino startBlock = null;
	
	public TetrisController (TetrisBoard t, TetrisView tt){
		board = t;
		view = tt;
		play();
	}
	
	
	
	private Tetrimino create(){
		Tetrimino returned;
		Random random = new Random();
		int index = random.nextInt(6);
		
		if (index == 0){
			returned = new JTetrimino();
		}
		else if(index == 1){
			returned = new LTetrimino();
		}
		else if(index == 2){
			returned = new OTetrimino();
		}
		else if(index == 3){
			returned = new STetrimino();
		}
		else if(index == 4){
			returned = new StraightTetrimino();
		}
		else{
			returned = new ZTetrimino();
		}
		
		return returned;
				
	}
	
	

	
	private void play(){
		
		boolean keyG = true;
		boolean key = true;
		
		while (keyG){
		    startBlock = create();
		    board.AssignT(startBlock);
			key = true;
			while(key){

				startBlock.reset();
				startBlock.changeRec();
				startBlock.colorC();
				board.Update();
				startBlock.reset();
				boolean isStop = startBlock.down();
				TIMER timer = new TIMER(500);
				startBlock.reset();
				startBlock.changeRec();
				startBlock.colorC();
				board.Update();
				startBlock.reset();
				
				if (!isStop){
					key = false;
					startBlock.setDone();
					board.CheckIfDelete();
					
					if(!startBlock.checkiflosst()){
						startBlock.reset();
						startBlock.changeRec();
						startBlock.colorC();
						board.Update();
						startBlock.reset();
						keyG = false;
					}
				}	
			}
			
		}
	}
	

	
}
	
	
	


