package piece;
import java.util.ArrayList;

public class king extends main.Piece {
	
	public static int points = 1;
	public boolean isInCheck = false;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public void updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);
	
		// MOVES FOR KING
		
		// UP LEFT
		if((super.getLocation() + up_left > -1) && (super.getLocation() + up_left < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + up_left] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + up_left);
		}
		
		// UP
		if((super.getLocation() + up > -1) && (super.getLocation() + up < 64) &&  // If in bounds.
				(indexedPieceArray[super.getLocation() + up] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + up);
		}

		
		// UP RIGHT
		if((super.getLocation() + up_right > -1) && (super.getLocation() + up_right < 64) &&  // In bounds.
				(indexedPieceArray[super.getLocation() + up_right] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_right] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + up_right);
		}
		
		// LEFT
		if((super.getLocation() + left > -1) && (super.getLocation() + left < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + left] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + left] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + left);
		}
		
		// RIGHT
		if((super.getLocation() + right > -1) && (super.getLocation() + right < 64) &&  // If in bounds.
				(indexedPieceArray[super.getLocation() + right] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + right] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + right);
		}

		
		// DOWN LEFT
		if((super.getLocation() + down_left > -1) && (super.getLocation() + down_left < 64) &&  // In bounds.
				(indexedPieceArray[super.getLocation() + down_left] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down_left] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + down_left);
		}
		
		// DOWN
		if((super.getLocation() + down > -1) && (super.getLocation() + down < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + down] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + down);
		}
		
		// DOWN RIGHT
		if((super.getLocation() + down_right > -1) && (super.getLocation() + down_right < 64) &&  // If in bounds.
				(indexedPieceArray[super.getLocation() + down_right] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down_right] == -1)) { // If the space is empty.
			legalMoves.add(super.getLocation() + down_right);
		}
		
		// FUNCTION TO CHECK IF KING IS IN CHECK

		// MOVES AVAILABLE GIVEN KING IS IN CHECK



	}
}
