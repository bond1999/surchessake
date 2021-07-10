package piece;

import java.util.ArrayList;

public class pawn extends main.Piece {

	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();
	public static int points = 1;
	public boolean hasMoved = false;
	public boolean promoting = false;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public void updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);
		
		// UP
		if((super.getLocation() + up > -1) && (super.getLocation() + up < 64) &&  // If in bounds.
				indexedPieceArray[super.getLocation() + up] == -1) { // If the space is empty.
			legalMoves.add(super.getLocation() + up);
		}

		// UP TWO
		if((super.getLocation() + up*2 > -1) && (super.getLocation() + up*2 < 64) && // In bounds.
				!hasMoved && // Hasn't moved yet.
				indexedPieceArray[super.getLocation() + up] == -1 && indexedPieceArray[super.getLocation() + up*2] == -1 ) { // Both spaces are empty.
			legalMoves.add(super.getLocation() + up*2);
		}
		
		// UP LEFT
		if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && // In bounds.
				indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor() && // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left] != -1) { // Not a null space.
			legalMoves.add(super.getLocation() + up_left);
		}
		
		// UP RIGHT
		if((super.getLocation() + up_right > -1) && (super.getLocation() + up_right < 64) &&  // In bounds.
				indexedPieceArray[super.getLocation() + up_right] % 2 != super.getColor() && // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left] != -1) { // Not a null space.
			legalMoves.add(super.getLocation() + up_right);
		}

		// NEED PREVIOUS MOVES TRACKER TO IMPLEMENT EN PASSANT
		
		// EN PASSANT LEFT
		//if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && 
				//indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor()) {
			//legalMoves.add(super.getLocation() + up_left);
		//}
		
		// EN PASSANT RIGHT
		//if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && 
				//indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor()) {
			//legalMoves.add(super.getLocation() + up_left);
		//}

		// NEED FUNCTION TO CHECK IF KING IS IN CHECK
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves

		if (super.getLocation() <= 8 || super.getLocation() >= 56)
		{
			System.out.println("Pawn is promoting!");
			promoting = true;
		}

	}	

}
	
