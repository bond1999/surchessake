package piece;
import java.util.ArrayList;

public class king extends main.Piece {
	
	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();
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
	
		// FUNCTION TO CHECK IF KING IS IN CHECK

		// MOVES AVAILABLE GIVEN KING IS IN CHECK



	}
}
