package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class King extends Piece{
	
public String type = chess_constants.King;
	
	public King(boolean color) {
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
		
	if(specialCase.pieceInPath==false) {  //maybe giving an issue
		
		
		
		if ( start.distanceFormula(end) == 1 && start.isTouching(end)) {//unless king can switch with rook
        
			return true;
	     } 
		
	
	}
	
	
		return false;
	
	
	

}
	
}
