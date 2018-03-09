package model;
import utility.chess_constants;
import utility.PairCoordinate;
import utility.*;


public class Tile {
	//using vector type of system that requires location and piece
	
	public final PairCoordinate location;
	public Piece piece;
	
	//constructor
	public Tile(PairCoordinate location, Piece piece) {
			this.location=location; this.piece=piece;
	}
		//is the tile a white tile or a black tile?
	public String toString() {
		if(this.piece==null) {
			//both x and y are even OR both x and y are odd
			//then the tile should be white
	if((this.location.m_file % 2 == 0 && this.location.m_rank % 2 == 0) || (this.location.m_file % 2 != 0 && this.location.m_rank % 2 != 0) ) {
				return chess_constants.WHITE_T;
			}else {
				return chess_constants.BLACK_T;
			}
		}else {
			return piece.toString();
		}
	}//end toString method
	

	//is the tile free?
	public boolean isEmpty() {
		return this.piece==null;
	}
	

}
