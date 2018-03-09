

package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class Knight extends Piece{
	
public String type = chess_constants.Knight;
	
	public Knight(boolean color) {
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
		
if( (start.m_file-2==end.m_file||start.m_file+2==end.m_file)&&(start.m_rank-1==end.m_rank||start.m_rank+1==end.m_rank) ) {
		  return true;
	}
else if( (start.m_rank+2==end.m_rank||start.m_rank-2==end.m_rank)&&(start.m_file-1==end.m_file)||(start.m_file+1==end.m_file) ) {
	    return true;
}
else {
	return false;
}
		
	
	
	}
	

}