package piece;
import java.util.ArrayList;

public class rook extends main.Piece {
	
	public static int points = 5;
	
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
		int i = 1;
		while((super.getLocation() + up * i > -1) && (super.getLocation() + up * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + up * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up * i] == -1)) { // If the space is empty.
				
				legalMoves.add(super.getLocation() + up * i);
				if(indexedPieceArray[super.getLocation() + up * i] != -1)
					break;
				i++;
		}
		
		// DOWN
		i = 1;
		while((super.getLocation() + down * i > -1) && (super.getLocation() + down * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + down * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down * i] == -1)) { // If the space is empty.
				
				legalMoves.add(super.getLocation() + down * i);
				if(indexedPieceArray[super.getLocation() + down * i] != -1)
					break;
				i++;
		}

		// LEFT
		int flag = 0;
		i = 1;
		while((super.getLocation() + left * i > -1) && (super.getLocation() + left * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + left * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + left * i] == -1)) { // If the space is empty.
				if((super.getColor() == 0 && (super.getLocation() + left * i) % 8 == 0) || // If it is a white piece
						(super.getColor() == 1 && (super.getLocation() + left * i) % 8 == 7)) // If it is a black piece
					flag = 1;
				if((super.getColor() == 0 && super.getLocation() % 8 != 0) || // If it is a white piece
						(super.getColor() == 1 && super.getLocation() % 8 != 7)) { // If it is white piece
					legalMoves.add(super.getLocation() + left * i);

					if (flag == 1)
						break;
				}
				if(indexedPieceArray[super.getLocation() + left * i] != -1)
					break;
				i++;
		}


		// RIGHT
		flag = 0;
		i = 1;
		while((super.getLocation() + right * i > -1) && (super.getLocation() + right * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + right * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + right * i] == -1)) { // If the space is empty.
				
				if((super.getColor() == 0 && (super.getLocation() + right * i) % 8 == 7) ||
						(super.getColor() == 1 && (super.getLocation() + right * i) % 8 == 0))
					flag = 1;
				if((super.getColor() == 0 && super.getLocation() % 8 != 7) || // If it is a white piece
						(super.getColor() == 1 && super.getLocation() % 8 != 0)) { // If it is white piece
					legalMoves.add(super.getLocation() + right * i);
				
					if (flag == 1)
						break;
				}
				if(indexedPieceArray[super.getLocation() + right * i] != -1)
					break;
				i++;
		}
		
		
		// NEED FUNCTION TO CHECK IF KING IS IN CHECK
		
		// KING IN CHECK
		// if kingIsInCheck
			// delete legal moves
		return legalMoves;
	}
}
