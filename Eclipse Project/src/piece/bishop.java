package piece;

import java.util.ArrayList;

public class bishop extends main.Piece {

	public static int points = 3;
	
	@Override
	public ArrayList<Integer> getLegalMoves() {
		super.getLegalMoves();
		return legalMoves;
	}
	
	@Override
	public ArrayList<Integer> updateLegalMoves(int[] indexedPieceArray) {	
		super.updateLegalMoves(indexedPieceArray);

		int flag = 0;
		ArrayList<Integer> legalMoves = new ArrayList<Integer>();
		// UP LEFT DIAGONAL
		int i = 1;
		while((super.getLocation() + up_left * i > -1) && (super.getLocation() + up_left * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + up_left * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_left * i] == -1)) { // If the space is empty.
//				System.out.printf("%s bishop Up left gives %d%n", super.getColor(super.getColor()), super.getLocation() + up_left * i);
				if((super.getColor() == 0 && (super.getLocation() + up_left * i) % 8 == 0) || // If it is a white piece
						(super.getColor() == 1 && (super.getLocation() + up_left * i) % 8 == 7)) // If it is a black piece
					flag = 1;
				if((super.getColor() == 0 && super.getLocation() % 8 != 0) ||  // If it is a white piece
						(super.getColor() == 1 && super.getLocation() % 8 != 7)) { // If it is a black piece
					legalMoves.add(super.getLocation() + up_left * i);
					if(flag == 1)
						break;
				}
				if(indexedPieceArray[super.getLocation() + up_left * i] != -1)
					break;
				i++;
		}
		
		// UP RIGHT DIAGONAL
		flag = 0;
		i = 1;
		while((super.getLocation() + up_right * i > -1) && (super.getLocation() + up_right * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + up_right * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + up_right * i] == -1)) { // If the space is empty.

				if((super.getColor() == 0 && (super.getLocation() + up_right * i) % 8 == 7) || // If it is a white piece
						(super.getColor() == 1 && (super.getLocation() + up_right * i) % 8 == 0)) // If it is a black piece
					flag = 1;
				if((super.getColor() == 0 && super.getLocation() % 8 != 7) || 
						(super.getColor() == 1 && super.getLocation() % 8 != 0)) {
					legalMoves.add(super.getLocation() + up_right * i);
					if(flag == 1)	
						break;
				}
				if(indexedPieceArray[super.getLocation() + up_right * i] != -1)
					break;
				i++;
		}


		// DOWN LEFT DIAGONAL
		flag = 0;
		i = 1;
		while((super.getLocation() + down_left * i > -1) && (super.getLocation() + down_left * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + down_left * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down_left * i] == -1)) { // If the space is empty.
				
				if((super.getColor() == 0 && (super.getLocation() + down_left * i) % 8 == 0) || // If it is a white piece
						(super.getColor() == 1 && (super.getLocation() + down_left * i) % 8 == 7)) // If it is a black piece
					flag = 1;
				if((super.getColor() == 0 && this.getLocation() % 8 != 0) ||  // If it is a white piece
						(super.getColor() == 1 && this.getLocation() % 8 != 7)) { // If it is a black piece
					legalMoves.add(super.getLocation() + down_left * i);
					if(flag == 1)
						break;
				}
				if(indexedPieceArray[super.getLocation() + down_left * i] != -1)
					break;
				i++;
		}

		// DOWN RIGHT DIAGONAL
		flag = 0;
		i = 1;
		while((super.getLocation() + down_right * i > -1) && (super.getLocation() + down_right * i < 64) && // In bounds.
				(indexedPieceArray[super.getLocation() + down_right * i] % 2 != super.getColor() || // Opposite color to capture.
				indexedPieceArray[super.getLocation() + down_right * i] == -1)) { // If the space is empty.
				
				if((super.getColor() == 0 && (super.getLocation() + down_right * i) % 8 == 7) || // If it is a white piece
						(super.getColor() == 1 && (super.getLocation() + down_right * i) % 8 == 0)) // If it is a black piece
					flag = 1;
				if((super.getColor() == 0 && super.getLocation() % 8 != 7) || // If it is a white piece
						(super.getColor() == 1 && super.getLocation() % 8 != 0)) { // If it is a black piece
					legalMoves.add(super.getLocation() + down_right * i);
					if(flag == 1)	
						break;
				}
				if(indexedPieceArray[super.getLocation() + down_right * i] != -1)
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
