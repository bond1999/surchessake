package main;

import java.util.ArrayList;

public class PGN {
	
	static ArrayList<Tag> Tags = new ArrayList<Tag>();
	static ArrayList<Move> Moves = new ArrayList<Move>();
	static int turnOrder = 0; // 0 is White, 1 is Black to move
	static int moveNumber = 1;
	static boolean capture = false;
	
	
	static class Move {
		int moveNumber;
		String algebraicNotationWhite;
		String algebraicNotationBlack;
		
		Move(int m, String anw, String anb) {
			moveNumber = m;
			algebraicNotationWhite = anw;
			algebraicNotationBlack = anb;
		}
		
		Move(int m, String anw) {
			moveNumber = m;
			algebraicNotationWhite = anw;		
		}
		// Getters
		public int getMoveNumber() { return moveNumber; }
		public String getAlgebraicNotationWhite() { return algebraicNotationWhite; }
		public String getAlgebraicNotationBlack() { return algebraicNotationBlack; }
		
	}
	
	public String getLastMove() {
		if (turnOrder == 1)
			return Moves.get(Moves.size() - 1).getAlgebraicNotationBlack();
		else
			return Moves.get(Moves.size() - 1).getAlgebraicNotationWhite();
	}
	
	static class Tag {
		String header;
		String description;
		
		Tag(String h, String d) {
			header = h;
			description = d;
		}
		
		// Getters
		public String getTagHeader() { return header; }
		public String getTagDescription() { return description; }
		
	}

	// Test PGN: [Location "Surya's Apartment"]
	
	public static void readPGN(String givenPGN) {
		char charPGN[] = givenPGN.toCharArray();
		for(int i = 0; i < charPGN.length; i++) {
			
			if(charPGN[i] == '[') {
				String header = "";
				String description = "";
				i++; // Gets inside the starting bracket.
				do { 
					header += Character.toString(charPGN[i]);
					i++;
				} while(charPGN[i]!=' ');
				if(charPGN[i] != '"')
					i++; // Gets inside the double quotes.
				i++;
				do {
					description += Character.toString(charPGN[i]);
					i++;
					if(charPGN[i] == '"')
						i++;
				} while(charPGN[i]!=']');
				Tags.add(new Tag(header, description));
			}
			
			int moveNumber;
			String algebraicNotationWhite = "";
			String algebraicNotationBlack = "";
			if(Character.isDigit(charPGN[i])) {
				moveNumber = charPGN[i] - 48;
				if(Character.isDigit(charPGN[i+1]) && !Character.isDigit(charPGN[i+2])) {
					moveNumber *= 10;
					moveNumber += charPGN[i+1] - 48;
					i++;
				}
				if(Character.isDigit(charPGN[i+2])) {
					moveNumber *= 10;
					moveNumber += charPGN[i+2] - 48;
					i+=2;
				}
								
				
				i+=3; // From move number to first character of move.

				do {
					algebraicNotationWhite += Character.toString(charPGN[i]);
					i++;
				} while (charPGN[i]!= ' ');
				i++;
				do {
					if(charPGN[i] == '{') {
						do { i++; } while(charPGN[i] != '}');
						i+=2;
					}
					algebraicNotationBlack += Character.toString(charPGN[i]);
					i++;
				} while (charPGN[i]!= ' ' && i + 1 < charPGN.length);
				
				Moves.add(new Move(moveNumber, algebraicNotationWhite, algebraicNotationBlack));
			}
		}
		Moves.get(Moves.size() - 1).algebraicNotationBlack += charPGN[charPGN.length - 1];
	}
	
	public static void updatePGN(Piece pieceAtOriginalLocation, int currentSquare) {
		
		char letterIndex = (char) ((currentSquare % 8) + 97);
		char pieceType = (char) pieceAtOriginalLocation.getType(pieceAtOriginalLocation.getType());
		char letterIndexOriginal = (char) ((pieceAtOriginalLocation.getLocation() % 8) + 97);
		int numberIndex = 8 - (currentSquare / 8);

		
		
		if (Piece.isPiece(currentSquare, chessboard.LAN_BOARD))
			capture = true;
		else
			capture = false;

		// Now it's black's move
		
		
		// If pawn , then dont display pieceType
		if(pieceType == 'P')
			pieceType = '\0';
		
		String moveAN;
		
		// PGN Notation to store the current half-move
		if(capture && pieceType == '\0') { // Pawn capture.
			System.out.printf("%cx%c%d ", letterIndexOriginal, letterIndex, numberIndex);
			moveAN = Character.toString(letterIndexOriginal) + "x" + Character.toString(letterIndex) + Integer.toString(numberIndex);
		} else if(capture) { // Other piece capture.
			System.out.printf("%c%c%d ", pieceType, letterIndex, numberIndex);
			moveAN = Character.toString(pieceType) + "x" + Character.toString(letterIndex) + Integer.toString(numberIndex);
		} else { // Regular piece move. 
			moveAN = Character.toString(pieceType) + Character.toString(letterIndex) + Integer.toString(numberIndex);
			System.out.printf("%c%c%d ", pieceType, letterIndex, numberIndex);
		}
		// Only increase moveNumber after black moves
		if (turnOrder == 1)
			moveNumber++;
		
		if(turnOrder == 0) { // White move, create new move.
			turnOrder = 1;
			Moves.add(new Move(moveNumber, moveAN));
		} else { // Black move, get old move.
			turnOrder = 0; 
			Moves.get(moveNumber - 2).algebraicNotationBlack = moveAN;
		}
			
		System.out.println(Moves.size());
	}
	
	
	public static String writePGN() {
		
		String PGNFormat = "";
		
		for(int i = 0; i < Tags.size(); i++) {
			PGNFormat += "[" + Tags.get(i).header + " \"" + Tags.get(i).description + "\"]\r\n";
		}
		PGNFormat += "\r\n";
		for(int i = 0; i < Moves.size(); i++) {
			PGNFormat += Moves.get(i).moveNumber + ". " + Moves.get(i).algebraicNotationWhite + " " + Moves.get(i).algebraicNotationBlack + " ";
		}
		return PGNFormat;
	}
}
