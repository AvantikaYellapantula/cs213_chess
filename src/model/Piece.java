package model;


import utility.PairCoordinate;
import utility.chess_constants;

public abstract class Piece {


/*
 * This decides how exactly the pieces can move
 * 
 * First of all, there are two main players, White and black.
 * So no matter which piece is moving, there needs to be a player_color
 *  --> That can be a boolean value
 *  A piece can only move to a spot given two options:
 *  --> if that spot is empty
 *  --> kill shot
 *  Both can be represented by boolean values 
 * */
	public boolean color;
	
	
	public Piece(boolean color) {
		this.color=color;
	}

public boolean isWhite(Piece p) { //white is true black is false
		if(p.color==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * How do we decide if a player can  move or not
	 * - we need the old coordinates
	 * - we need the new coordinates
	 * - boolean can move
	 * */
public boolean isOkMove(PairCoordinate start, PairCoordinate end, allCases specialCase) {//MAY HAVE TO COME BACK TO THIS LATER!
	
    if ( start.distanceFormula(end) <= 7) {
		return true;
	} 
	
	else {
		System.out.print("cant do this move");
		return false;
	}
}


   public String toString() {
	   String ans;
	   
	   if(this.color==true) {
		   ans=chess_constants.WHITE_T;
		   return ans;
	   }
	   else {
		   ans=chess_constants.BLACK_T;
		   return ans;
	   }
	   
   }

	//public abstract boolean movePiece(int oX, int oY, int nX, int nY, boolean canMove);

	//we need another abstract class to write the name of the piece on the console that can be used for each one of the pieces
	//public abstract String writeName();
	
	
}
