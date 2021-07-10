package piece;
import java.util.ArrayList;

public class knight extends main.Piece {
	
	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();
	public static int points = 3;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public void updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);

		// UP RIGHT FORWARD

		// UP RIGHT SIDE

		// DOWN RIGHT SIDE

		// DOWN RIGHT BACKWARDS

		// DOWN LEFT BACKWARDS

		// DOWN LEFT SIDE

		// UP LEFT SIDE

		// UP LEFT FORWARD

	
		// NEED FUNCTION TO CHECK IF KING IS IN CHECK
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves

	}
}
