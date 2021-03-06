package piece;
import java.util.ArrayList;

public class knight extends main.Piece {
	
	public static int points = 3;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public ArrayList<Integer> updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);

		ArrayList<Integer> legalMoves = new ArrayList<Integer>();
		// UP LEFT FORWARD
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() / 8 != 1) && (super.getLocation() / 8 != 0) && 
				(super.getLocation() + N_up_left > -1) && (super.getLocation() + N_up_left < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_left] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_left] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_left);

			}
		} else {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() <= 47) && 
				(super.getLocation() + N_up_left > -1) && (super.getLocation() + N_up_left < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_left] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_left] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_left);

			}
		}

		// UP RIGHT FORWARD
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() / 8 != 0) && (super.getLocation() / 8 != 1) && 
				(super.getLocation() + N_up_right > -1) && (super.getLocation() + N_up_right < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_right] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_right] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_right);

			}
		} else {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() <= 47) && 
				(super.getLocation() + N_up_right > -1) && (super.getLocation() + N_up_right < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_right] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_right] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_right);

			}
		}

		// UP LEFT SIDE
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() % 8 != 1) && (super.getLocation() / 8 != 0) && 
				(super.getLocation() + N_up_left_side > -1) && (super.getLocation() + N_up_left_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_left_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_left_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_left_side);
			}
		} else {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() % 8 != 6) && (super.getLocation() <= 55) && 
				(super.getLocation() + N_up_left_side > -1) && (super.getLocation() + N_up_left_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_left_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_left_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_left_side);

			}
		}

		// UP RIGHT SIDE
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() % 8 != 6) && (super.getLocation() / 8 != 0) && 
				(super.getLocation() + N_up_right_side > -1) && (super.getLocation() + N_up_right_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_right_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_right_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_right_side);

			}
		} else {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() % 8 != 1) && (super.getLocation() <= 55) && 
				(super.getLocation() + N_up_right_side > -1) && (super.getLocation() + N_up_right_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_up_right_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_up_right_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_up_right_side);

			}
		}

		// BACK LEFT SIDE
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() % 8 != 1) && (super.getLocation() / 8 != 0) && 
				(super.getLocation() + N_back_left_side > -1) && (super.getLocation() + N_back_left_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_left_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_left_side] == -1)) {

					legalMoves.add(super.getLocation() + N_back_left_side);

			}
		} else {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() % 8 != 6) && (super.getLocation() >= 8) && 
				(super.getLocation() + N_back_left_side > -1) && (super.getLocation() + N_back_left_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_left_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_left_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_left_side);

			}
		}
		
		// BACK RIGHT SIDE
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() % 8 != 6) && (super.getLocation() / 8 != 0) && 
				(super.getLocation() + N_back_right_side > -1) && (super.getLocation() + N_back_right_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_right_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_right_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_right_side);

			}
		} else {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() % 8 != 1) && (super.getLocation() >= 8) && 
				(super.getLocation() + N_back_right_side > -1) && (super.getLocation() + N_back_right_side < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_right_side] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_right_side] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_right_side);

			}
		}

		// BACK LEFT 
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() / 8 != 7) && (super.getLocation() / 8 != 6) && 
				(super.getLocation() + N_back_left > -1) && (super.getLocation() + N_back_left < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_left] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_left] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_left);

			}
		} else {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() >= 16) && 
				(super.getLocation() + N_back_left > -1) && (super.getLocation() + N_back_left < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_left] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_left] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_left);

			}
		}

		// BACK RIGHT
		if (super.getColor() == 0) {
			if ((super.getLocation() % 8 != 7) && (super.getLocation() / 8 != 7) && (super.getLocation() / 8 != 6) && 
				(super.getLocation() + N_back_right > -1) && (super.getLocation() + N_back_right < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_right] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_right] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_right);

			}
		} else {
			if ((super.getLocation() % 8 != 0) && (super.getLocation() >= 16) && 
				(super.getLocation() + N_back_right > -1) && (super.getLocation() + N_back_right < 64) && 
				(indexedPieceArray[super.getLocation() + N_back_right] % 2 != super.getColor() ||
				indexedPieceArray[super.getLocation() + N_back_right] == -1)) {
					
					legalMoves.add(super.getLocation() + N_back_right);

			}
		}

	
		// NEED FUNCTION TO CHECK IF KING IS IN CHECK
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves
		return legalMoves;
	}
}
