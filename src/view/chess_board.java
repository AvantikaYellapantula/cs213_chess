package view;


import model.Pawn;
import model.Piece;
import model.Bishop;
import model.Rook;
import model.Knight;
import model.Queen;
import model.King;



public class chess_board {

	
    
		
		
	   
	}
	
	/*
	public void acceptArg(String input) {
		
		if(input.equals("draw?")) {
			this.drawProposal=true;
		}
		if(drawProposal==true) {
			System.out.println("Draw.");
			System.exit(0);
		}
		if (input.equals("resign")) {
			if(game_board.player_color==true) {
				System.out.print("Black Player wins!!!");
			}
			else {
				System.out.println("White Player wins!!");
			}
		//	System.out.println(this.vc.isBlackTurn() ? "White wins!" : "Black wins!");
		//	this.game_board.resign();
		}
		if (input.length() == 5){ //that means its the standard input i.e a2 a4
			char rankStart = input.charAt(0); char rankEnd = input.charAt(3);
			char fileStart = input.charAt(1); char fileEnd = input.charAt(4);
			
			
			try {
				vc.makeMove(rankStart, fileStart, rankEnd, fileEnd, null);
			} catch (InvalidCoordinateException ice) {
				System.out.println(ice.getMessage());
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
		} 
		
		if(input.length()==7) { //in case a promotion happens 
			char rankStart = input.charAt(0); char rankEnd = input.charAt(3);
			char fileStart = input.charAt(1); char fileEnd = input.charAt(4);
			char promote = input.charAt(6);
			try {
				vc.makeMove(rankStart, fileStart, rankEnd, fileEnd, null);
			} catch (InvalidCoordinateException ice) {
				System.out.println(ice.getMessage());
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
			
		}
	
		public void printBoard() {
			System.out.println(this.vc.getBoardString());
		}
		
		public void printPrompt() {
			System.out.print(vc.isBlackTurn() ? "Black's turn: " : "White's turn: ");
		}
		
		
		
	}
	
	//initialize method
	
	
	
}

/*
Sys.Out.Pr
8 bR bN bB bQ bK bB bN bR
7 bP bP bP bP bP bP bP bP
6    ##    ##    ##    ##
5 ##    ##    ##    ##
4	 ##    ##    ##	   ##
3 ## 	## 	  ##    ##
2 wP wP wP wP wP wP wP wP
1 wR wN wB wQ wK wB wN wR
0 1  2  3  4  5  6  7  8
 
 CodeView
0 bR bN bB bQ bK bB bN bR
1 bP bP bP bP bP bP bP bP
2    ##    ##    ##    ##
3 ##    ##    ##    ##
4	 ##    ##    ##	   ##
5 ## 	## 	  ##    ##
6 wP wP wP wP wP wP wP wP
7 wR wN wB wQ wK wB wN wR
8 1  2  3  4  5  6  7  8
 
 
 
 *
 *
 */