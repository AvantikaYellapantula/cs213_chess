package model;

import utility.PairCoordinate;

public class Board {
	 Tile[][] game_board;
      public boolean drawProposal;
      public boolean whiteTurn;
		
		public Board() {
			game_board = new Tile[8][8];
			whiteTurn=true;
			this.initialize_board();
			
		}
		
		public void turnPicker() {
			
			this.whiteTurn=!(this.whiteTurn);
			//System.out.println("switch");
		}
		
		public void initialize_board() {
			
			for(int i=0;i<8;i++) {
				for(int j=0;j<8;j++) {
					game_board[i][j]=new Tile(new PairCoordinate(i,j),null );
				}
			}	
//set up the board
			
		//set up white pieces
			//pawns -> white:
			
			for(int i=0;i<8;i++) {
				game_board[1][i].piece = new Pawn(false);
			}
			
			//pawns -> black
			for(int i=0;i<8;i++) {
			game_board[6][i].piece = new Pawn(true);
			}
			
			//Rook -> black
			game_board[0][0].piece = new Rook(false);
			game_board[0][7].piece = new Rook(false);
			//Rook -> white
			game_board[7][0].piece = new Rook(true);
			game_board[7][7].piece = new Rook(true);
			//Knight -> black
			game_board[0][1].piece = new Knight(false);
			game_board[0][6].piece = new Knight(false);
			//Knight -> white
			game_board[2][1].piece = new Knight(true);
			game_board[7][6].piece = new Knight(true);
			//Bishop -> black
			game_board[0][2].piece = new Bishop(false);
			game_board[0][5].piece = new Bishop(false);
			//Bishop -> white
			game_board[7][2].piece = new Bishop(true);
			game_board[7][5].piece = new Bishop(true);
			//Queen -> black
			game_board[0][3].piece = new Queen(false);
			//Queen -> white
			game_board[7][3].piece = new Queen(true);
			//King -> black
			game_board[0][4].piece = new King(false);
			//King -> white
			game_board[7][4].piece = new King(true);
			
			
			
		}
		
		
		public void check() {
			//sees if a player has a check on king!
		}
		
		
		
	
		
		public boolean boardMove(PairCoordinate start,PairCoordinate end,String Promote) {
			
			allCases special = new allCases();
			                                        //MAY NEED TO SWAP THESE two file and rank
			Tile startTile=game_board[start.m_rank][start.m_file];
			
			Tile endTile=game_board[end.m_rank][end.m_file];
			
			Piece movingPiece=startTile.piece;
			
			Piece endPiece=endTile.piece;
			
			
			
			
			if(movingPiece==null) {
				System.out.println("No piece to move is at this spot");
				return false;
					
			}
			
			if(endPiece!=null) {
				special.isCapturing=true;
				
			}
			else {
				special.isCapturing=false;
			}
			
			
			
			/*
			 	special.isCapturing = takenPiece == null ? false : true;
		special.isPromoting = ChessPieceConstant == null ? false : true;
		special.pieceInPath = this.boardHasPieceInPathBetween(startAddress, endAddress);
			 */
			
		
			
			special.pieceInPath=this.hasPieceInPath(start, end);
			
			
			if(start.equals(end)) {
				System.out.println("Cant move to the same tile your on");
				return false;
			}
			if (movingPiece.color==false && this.whiteTurn) {
				System.out.println("Can not move opponents piece");
				return false;
			}
			if(movingPiece.color==true && this.whiteTurn==false) {
				System.out.println("Can not move opponents piece");
				return false;
			}
			
			
	if( (endPiece != null && (endPiece.color==true && this.whiteTurn==true)) || (endPiece != null && (endPiece.color==false && this.whiteTurn==false))) {
			   System.out.println("Can NOT capture your own piece");
			   return false;
			}
			 
			 
		
			 
			 
			 
			 
			 
       if(movingPiece.isOkMove(start, end, special)) { //this checks to see if it has special cases
    	   //below stuff may be placed in wrong area
    	         if(special.isPromoting==true) {
    	        	  
    	        	 this.game_board[end.m_rank][end.m_file]=this.getPromotedPiece(Promote);
    	        	 
    	        	 
    	        	 return true;
    	         }
				 
				 
				  this.game_board[end.m_rank][end.m_file].piece=this.game_board[start.m_rank][start.m_file].piece;
				  
				  this.game_board[start.m_rank][start.m_file].piece=null;
				  
				  this.turnPicker();
				  
				  return true;
				  
				
			 }
			 
       else {
    	   return false;
       }
			
			 
 
			 //NEEEEED TO COME BACK HERE
			 
			 /*
			 if (special.isPromoting) {
					board[end.m_file][endAddress.m_rank].piece = this
							.getChessPieceFrom(ChessPieceConstant);
				}

			} 
			else {
				throw new InvalidMoveException(
						"That is not a valid move for this piece.");
			}
			*/
			 
		
		}
		private Tile getPromotedPiece(String s) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean check(PairCoordinate start, PairCoordinate end ){
			
			
			
			
			return false;
		}
		
		
		
		
		
		public boolean hasPieceInPath(PairCoordinate start, PairCoordinate end) {
		//DO A SCAN ON ALL DIRECTIONS LEFT RIGHT UP DOWN AND FINALLY ALL DIAGONALS
			
			if(start.m_file==end.m_file && start.m_rank>end.m_rank) {
				// do a scan to see if any pieces are in its path in its moving direction
			for(int i=start.m_rank-1;i>end.m_rank;i--) {
				Tile space= game_board[i][start.m_file];
				if(space.isEmpty()==false) {
					return true;
				}
			}
		}
	
		if(start.m_file==end.m_file && start.m_rank<end.m_rank) {
			// do a scan to see if any pieces are in its path in its moving direction
		for(int i=start.m_rank+1;i<end.m_rank;i++) {
			Tile space= game_board[i][start.m_file];
			if(space.isEmpty()==false) {
				return true;
			}
		}
	}
		

		if(start.m_rank==end.m_rank && start.m_file>end.m_rank) {
			// do a scan to see if any pieces are in its path in its moving direction
		for(int i=start.m_file-1;i>end.m_file;i--) {
			Tile space= game_board[start.m_rank][i];
			if(space.isEmpty()==false) {
				return true;
			}
		}
	}
		
		if(start.m_rank==end.m_rank && start.m_file<end.m_rank) {
			// do a scan to see if any pieces are in its path in its moving direction
		for(int i=start.m_file+1;i<end.m_file;i++) {
			Tile space= game_board[start.m_rank][i];
			if(space.isEmpty()==false) {
				return true;
			}
		}
	}
		
		if(start.hasDiagPath(end)) {
			
			int tempFile=start.m_file;
			int tempRank=start.m_rank;
			
			if(start.m_file<end.m_file && start.m_rank<end.m_rank) {
				
				while(tempFile+1!=end.m_file&&tempRank+1!=end.m_rank) {
				     if(game_board[tempRank+1][tempFile+1].isEmpty()==false) {
				    	    return true;
				     }
				 tempFile+=1;
				 tempRank+=1;
				}
				
			}
             
			if(start.m_file>end.m_file && start.m_rank>end.m_rank) {
				
				while(tempFile-1!=end.m_file&&tempRank-1!=end.m_rank) {
				     if(game_board[tempRank-1][tempFile-1].isEmpty()==false) {
				    	    return true;
				     }
					
					 tempFile-=1;
					 tempRank-=1;
				}
				
			}
			
            
			if(start.m_file<end.m_file && start.m_rank>end.m_rank) {
				
				while(tempFile+1!=end.m_file&&tempRank-1!=end.m_rank) {
				     if(game_board[tempRank-1][tempFile+1].isEmpty()==false) {
				    	    return true;
				     }
				    
				     
				     tempFile+=1;
					 tempRank-=1;
				     
				}
				
			}
			
			
			
             if(start.m_file>end.m_file && start.m_rank<end.m_rank) {//d0 a3 stuck in here
				
				while(tempFile-1!=end.m_file&&tempRank+1!=end.m_rank) {
				     if(game_board[tempRank+1][tempFile-1].isEmpty()==false) {
				    	    return true;
				     }
				     tempFile-=1;
					 tempRank+=1;
				}
				 
			  }
			
			
			
			
		}
					

		return false;
		
		}
		
		
		
		
		
		
		
		
		public String toString() {
			String str = "";
             int count=0;
			for (int i = 0; i < game_board.length; i++) {
			  for (int j = 0; j < game_board[i].length; j++) {
				//	str += this.game_board[i][j].toString() + " "; //one tile
				 
				  
				  str+=this.game_board[i][j].toString()+" ";
					
					//System.out.print("hate");
				}

				str+=(count+"\n");
				count++;//this is to generate rank number on the side 
			}

			str+=" a  b  c  d  e  f  g  h";

			return str;
		}
		
		
		
		
		
		
		
		
		
		
}
