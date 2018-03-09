package view;


import model.Pawn;
import model.Piece;
import controller.controllerView;
import model.Bishop;
import model.Rook;
import model.Knight;
import model.Queen;
import model.King;



public class chess_board_view {

	
    controllerView CV;
    
    boolean resign;
    boolean draw;
    
    
    public chess_board_view(controllerView CV) {
    	this.CV=CV;
    }
    
		
		
	  
	public boolean acceptArg(String input) {
		boolean noMistake = false;
		if(input.equals("draw?")) {
			this.draw=true;
		}
		
		if(draw==true) {
			System.out.println("Draw.");
			System.exit(0);
		}
		if (input.equals("resign")) {
			if(CV.board.whiteTurn==true) {
				System.out.print("Black Player wins!!!");
				System.exit(0);
			}
			else {
				System.out.println("White Player wins!!");
				System.exit(0);
			}
		//	System.out.println(this.vc.isBlackTurn() ? "White wins!" : "Black wins!");
		//	this.game_board.resign();
		}
		if (input.length() == 5){ //that means its the standard input i.e a2 a4
			char rankStart = input.charAt(1); char rankEnd = input.charAt(4);
			//row
			char fileStart = input.charAt(0); char fileEnd = input.charAt(3);
			//col
			
			
			   noMistake= CV.doMove(fileStart, rankStart, fileEnd, rankEnd,null);
			   
			  
			    
			    
			} 
		
		if(input.length()==7) { //in case a promotion happens 
			char rankStart = input.charAt(1); char rankEnd = input.charAt(4);
			char fileStart = input.charAt(0); char fileEnd = input.charAt(3);
			String promote = input.charAt(6)+"";
			
			 noMistake= CV.doMove(fileStart, rankStart, fileEnd, rankEnd,promote) ;
			 
		}
		
		
		
		if(noMistake==false) {
			   System.out.println("Player made invalid move please try again");
			   return false;
		   }
		   else {
			    return true;
		   }
		
		
	}
	

	
		public void printBoard() {
			System.out.print( CV.getBoard() );
		}
		
		public void printPrompt() {
			if(CV.isWhiteTurn()) {
				
			System.out.println("\n\n White Player Turn");		
		}
			
			
			
		else {
				System.out.println(" \n\n Black Player Turn");
			
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