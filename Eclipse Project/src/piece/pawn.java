package piece;

import java.util.ArrayList;

import main.chessboard;

public class pawn extends main.Piece {

	public static int points = 1;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public ArrayList<Integer> updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);
		
		ArrayList<Integer> legalMoves = new ArrayList<Integer>();
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
			if((super.getLocation()) % 8 != 0)
				legalMoves.add(super.getLocation() + up_left);
		}
		
		// UP RIGHT
		if((super.getLocation() + up_right > -1) && (super.getLocation() + up_right < 64) &&  // In bounds.
				indexedPieceArray[super.getLocation() + up_right] % 2 != super.getColor() && // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_right] != -1) { // Not a null space.
			if((super.getLocation()) % 8 != 7)
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

		// ADD BOOLEAN DELETE TO GET BELOW TO WORK

		// if (delete) {

		// 	ArrayList<Integer> movesToDelete = new ArrayList<Integer>();
			
		// 	// Makes copy of the old check piece array.
		// 	int oldCheckPiece[] = new int[64];
		// 	for (int i = 0; i < indexedPieceArray.length; i++) {
		// 		oldCheckPiece[i] = indexedPieceArray[i];
		// 	}

		// 	for (int i = 0; i < legalMoves.size(); i++) {

		// 		int tempArray[] = new int[64];
		// 		for (int j = 0; i < indexedPieceArray.length; j++) {
		// 			tempArray[j] = oldCheckPiece[j];
		// 		}

		// 		tempArray[legalMoves.get(i)] = this.getType();
		// 		if (main.Piece.isInCheck(tempArray, this.getColor()))
		// 			movesToDelete.add(legalMoves.get(i));

		// 	}

		// 	for (int i = 0; i < movesToDelete.size(); i++) {
		// 		if (movesToDelete.get(i) == legalMoves.get(i))
		// 			legalMoves.remove(i);
		// 	}

		// }


		return legalMoves;
	}

		//if(hasMoved == true && isInCheck(chessboard.checkPiece, color)) {	

}
	
