package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class Rook extends Piece{

	
	
	
public String type = chess_constants.Rook;
	
	public Rook(boolean color) {
		super(color);
		
	}
	
	public String toString() {
		if(this.color==true) {
			return "w"+type;
		}
		else {
			return "b"+type;
		}
	}
	
	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) { //MAY HAVE TO COME BACK TO THIS LATER!
		
	 if(specialCase.pieceInPath==false) {
		 
   if ( (start.distanceFormula(end) <=7 && start.isSameFile(end)) || ( (start.distanceFormula(end)<=7) && start.isSameRank(end)) ) {//unless king can switch with rook
            return true;
	     } 
		
		else {
			System.out.println("cant do this move rook");
			return false;
		}
	}
	
	 else {
		 return false;
	 }
	
	
	
	
	}

}
