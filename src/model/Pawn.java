package model;

import utility.PairCoordinate;
import utility.chess_constants;

public class Pawn extends Piece{
	
	

	public String type = chess_constants.Pawn;
	

	//actually write the name
	public Pawn(boolean color) {
		super(color);
	}//constructor
	
	
	public String toString() {
		if(color==true) {
			//white pawn
			return  "w" + this.type;
		}else {
			//black pawn
			return  "b" + this.type;
		}
	}
	
	

	public boolean isOkMove(PairCoordinate start, PairCoordinate end,allCases specialCase) {
	 
		 if(specialCase.enPassant==true) {
	    	 //Still dont know yet
	      }
		
		  
	if(specialCase.isCapturing==true) { //checks for capture for pawn
	    	
		if(color==true) {
		if((start.m_rank==end.m_rank+1 && start.m_file+1==end.m_file) || (start.m_rank==end.m_rank+1 && start.m_file-1==end.m_file) ) {
				return true;
		}
		else {
			System.out.println("Pawn cant capture like that");
			return false;
		}
	 }
			   
		
		else {
	
	if((start.m_rank+1==end.m_rank && start.m_file+1==end.m_file) || (start.m_rank+1==end.m_rank && start.m_file-1==end.m_file) ) {
				return true;
		}
	
	else {
			System.out.println("Pawn cant capture like that");
			return false;
		   } 
				   
		}
			   
    }
		   
   	        
   	      
   	  if(specialCase.pieceInPath==false) {
		
	  if(color==true) {
		 
		  if(start.m_rank==6) {//white pawn start
			    specialCase.isFirstMove=true;
		  }
		  if(start.m_rank==0) {
			  specialCase.isPromoting=true; //has made it to promotion 
		  }
		  
	  }
	  
	  if(color==false) {   
		  if(start.m_rank==1) {//black pawn start 
			  specialCase.isFirstMove=true; 
		  }
		  if(start.m_rank==7) {
			  specialCase.isPromoting=true;
			  
		  }
	  }
      
       if(specialCase.isFirstMove==true) { //FIRST MOVE
    		if(start.isSameFile(end)==false) {
    		   return false;
    		}
    		
    		if((start.m_rank + 1 == end.m_rank || start.m_rank + 2 == end.m_rank)&&color==false) {
    	    	return true;
    	    }
    		if((start.m_rank - 1 == end.m_rank || start.m_rank - 2 == end.m_rank)&&color==true) {
    	    return true;
    		}
    		
     
      
      }
    
    
    else {//NOT FIRST MOVE  
    	if(color==false) { 
    		if((start.isSameFile(end)) && (start.m_rank+1==end.m_rank)) {
    		return true;
   
    		}
    	}
    	else {
    		if(start.isSameFile(end) && (start.m_rank-1==end.m_rank)){
    			return true;
    		}
    	}
    	
    	return false;
    }
   
    
   
	
	}
	
   	     
		return false;
	
	
	}
	
	
	

}
