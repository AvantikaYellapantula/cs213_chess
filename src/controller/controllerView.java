package controller;

import model.Board;
import utility.PairCoordinate;

public class controllerView {

	
	public Board board;
	
	public boolean isGameOver;
	
	
	public controllerView() {
		this.board= new Board();
		this.isGameOver=false;
	}
	
	
	public void isDraw() {
		 isGameOver=true;
		 
	}
	
	public void Resign() {
	    isGameOver=true;
	    
	    
	}
	
	
	public boolean doMove(char file, char rank, char fileEnd, char rankEnd, String promotion) {
		boolean isValidMove=false;
	
		
		
			PairCoordinate start=new PairCoordinate(file,rank);
			
			PairCoordinate end= new PairCoordinate(fileEnd,rankEnd);
			/*
			 CHECK TO SEE IF THESE COORDINATES ARE WITHIN BOUND!!!!
			 */
			if(start.m_file<0||start.m_file>7||start.m_rank<0||start.m_rank>7||
			   end.m_file<0||end.m_file>7||end.m_rank<0||end.m_rank>7){
			
				System.out.println("Invalid Coordinate out of bounds");
				return false;
				//Maybe throw some exception 
	
				
			}

			
			if(start!=null && end!=null && promotion!=null) {
				isValidMove=board.boardMove(start, end, promotion);
			}
			
			
			
			if(start!=null && end!=null) {
				
				/*
				 CHECK TO SEE IF THE MOVE IS A VALID MOVE 
				 */
				isValidMove=board.boardMove(start,end,null);
				
			
			}
			
		return isValidMove;
			
		
	}
	public String getBoard() {
	
		String str= this.board.toString();
		if(str==null) {
			System.out.print("no board");
		}
		return str;
	}

	public boolean isWhiteTurn() {
		return board.whiteTurn;
	}

	
	
	
	
	
	
}
