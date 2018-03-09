
package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class Queen extends Piece{
	public String type = chess_constants.Queen;

	
	public Queen(boolean color) {
		super(color);
		
	}
	
	
	public String toString() {
		if(this.color==true) {
			return "w"+chess_constants.Queen;
		}
		else {
			return "b"+chess_constants.Queen;
		}
	}
	
	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) { //MAY HAVE TO COME BACK TO THIS LATER!
		
	
	
	if(specialCase.pieceInPath==false) {
		if(start.distanceFormula(end) <= 7 ) {
			
			if((start.m_file==end.m_file)) {
			return true;
			}
		
			else if(start.m_rank==end.m_rank){
			return true;
			}
		
			else if ( start.hasDiagPath(end)) {
            return true;
			} 
		
			else {
				System.out.println("Cant do this move queen");
			return false;
			}
	   }
	
	}

	
	
		return false;
	
	
	
	}
	
	
}


