package main;

public class algorithm {
	static int whiteKingLoc = -1;
	static int blackKingLoc = -1;

	public static void updateAllPossibleLegalMoves() {

		for (int i = 0; i < chessboard.LAN_BOARD.size(); i++) {
			chessboard.LAN_BOARD.get(i).resetLegalMoves();
			chessboard.LAN_BOARD.get(i).legalMoves = chessboard.LAN_BOARD.get(i).updateLegalMoves(chessboard.checkPiece);
			if(chessboard.LAN_BOARD.get(i).getType() == 10)
				whiteKingLoc = chessboard.LAN_BOARD.get(i).location;
			if(chessboard.LAN_BOARD.get(i).getType() == 11)
				blackKingLoc = chessboard.LAN_BOARD.get(i).location;
		}
		
		int[] nextCheckPiece = chessboard.checkPiece;
		for (int i = 0; i < chessboard.LAN_BOARD.size(); i++) {
			for(int j = 0; j < chessboard.LAN_BOARD.get(i).getLegalMoves().size(); j++) {
				int temploc = chessboard.LAN_BOARD.get(i).getLegalMoves().get(j);
				int origloc = chessboard.LAN_BOARD.get(i).location;
				int tempCheckPiece = nextCheckPiece[temploc];
				nextCheckPiece[temploc] = nextCheckPiece[origloc];
				nextCheckPiece[origloc] = tempCheckPiece;
				
				for (int k = 0; k < chessboard.LAN_BOARD.size(); k++)
					chessboard.LAN_BOARD.get(k).nextlegalMoves = chessboard.LAN_BOARD.get(k).updateLegalMoves(nextCheckPiece);						
				
				for (int k = 0; k < chessboard.LAN_BOARD.size(); k++)
					for(int l = 0; l < chessboard.LAN_BOARD.get(k).nextlegalMoves.size(); l++) {
						// Need to code If it is Black's move vs White's Move
						if(PGN.turnOrder == 0) {						
							if(chessboard.LAN_BOARD.get(k).nextlegalMoves.get(l) == whiteKingLoc && chessboard.LAN_BOARD.get(k).getColor() == 1) {
								System.out.print("Legal Move Removed!");
								chessboard.LAN_BOARD.get(i).legalMoves.remove(j);
								j--;
							}
						}
						else if(PGN.turnOrder == 1) {
							if(chessboard.LAN_BOARD.get(k).nextlegalMoves.get(l) == blackKingLoc && chessboard.LAN_BOARD.get(i).getColor() == 0) {
								System.out.print("Legal Move Removed!");
								chessboard.LAN_BOARD.get(i).legalMoves.remove(j);
								j--;
							}
						}							
					}
					
				
				tempCheckPiece = nextCheckPiece[origloc];
				nextCheckPiece[origloc] = nextCheckPiece[temploc];
				nextCheckPiece[temploc] = tempCheckPiece;
			}
		}
	}
}
