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
	
	}
}
