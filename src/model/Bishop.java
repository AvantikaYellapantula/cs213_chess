package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class Bishop extends Piece{ //think this is working Ok not fully yet 
	public String type = chess_constants.Bishop;

	
	public Bishop(boolean color) {
		super(color);
		
	}
	
	
	public String toString() {
		if(this.color==true) {
			return "w"+chess_constants.Bishop;
		}
		else {
			return "b"+chess_constants.Bishop;
		}
	}
	
	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) { //MAY HAVE TO COME BACK TO THIS LATER!
		
	
				
	if(specialCase.pieceInPath==false) {
		
		if ( start.distanceFormula(end) <= 7 && start.hasDiagPath(end)) {
            return true;
		} 
		
		else {
			System.out.println("cant do this move bishop");
			return false;
		}
	}
	
	
	
	else {
		System.out.println("has a piece in its path");
        return false;
	}
	

}
	
	
}
