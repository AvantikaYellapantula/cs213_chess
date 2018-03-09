package chess;

import java.util.Scanner;

import controller.controllerView;
import view.chess_board_view;

public class chess {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		// TODO Auto-generated method stub
		

		controllerView gameController= new controllerView();
		
		
		chess_board_view gameView= new chess_board_view(gameController);
		
		
		
		
		
		while(gameController.isGameOver!=true) {
			
			boolean noMistake=false;
			gameView.printBoard();
			gameView.printPrompt();
		    //gameView.printBoard();
			
		    //gameView.printPrompt();
			
			String strInput;
		    
			while(noMistake==false) {
				
				
		    strInput=input.nextLine();
		    	noMistake=gameView.acceptArg(strInput);
		    	if(noMistake==false) {
		    	gameView.printBoard();
		    	gameView.printPrompt();
		    	}
		    	
		    	System.out.println();
		    
			}
			
		
		
		}
		
		
		
		
	}

}
