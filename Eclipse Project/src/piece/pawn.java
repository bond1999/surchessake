package piece;

import java.util.ArrayList;

public class pawn extends main.Piece {

	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();
	public static int points = 1;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public void updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);
		
		// UP
		if((super.getLocation() + up > -1) && (super.getLocation() + up < 64) && 
				indexedPieceArray[super.getLocation() + up] == -1) {
			legalMoves.add(super.getLocation() + up);
		}

		// UP TWO
		if((super.getLocation() + up*2 > -1) && (super.getLocation() + up*2 < 64) && 
				indexedPieceArray[super.getLocation() + up] == -1 && indexedPieceArray[super.getLocation() + up*2] == -1 ) {
			legalMoves.add(super.getLocation() + up*2);
		}
		
		// UP LEFT
		if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && 
				indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor() && // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left] != -1) { // Not a null space.
			legalMoves.add(super.getLocation() + up_left);
		}
		
		// UP RIGHT
		if((super.getLocation() + up_right > -1) && (super.getLocation() + up_right < 64) && 
				indexedPieceArray[super.getLocation() + up_right] % 2 != super.getColor() && // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left] != -1) { // Not a null space.
			legalMoves.add(super.getLocation() + up_right);
		}
		
		// EN PASSANT LEFT
		//if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && 
				//indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor()) {
			//legalMoves.add(super.getLocation() + up_left);
		//}
		
		// EN PASSANT RIGHT
		//if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && 
				//indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor()) {
			//legalMoves.add(super.getLocation() + up_left);
		}
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves
			
}
	
