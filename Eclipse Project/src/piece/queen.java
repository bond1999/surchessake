package piece;
import java.util.ArrayList;

public class queen extends main.Piece {
	
	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();
	public static int points = 9;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public void updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);

		// UP

		// DOWN

		// LEFT

		// RIGHT

		// UP LEFT DIAGONAL

		// UP RIGHT DIAGONAL

		// DOWN RIGHT DIAGONAL

		// DOWN LEFT DIAGONAL
	
		// NEED FUNCTION TO CHECK IF KING IS IN CHECK
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves

	}
}
