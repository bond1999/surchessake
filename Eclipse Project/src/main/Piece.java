package main;

import java.util.ArrayList;

public class Piece {
	
	public ArrayList<Integer> legalMoves = new ArrayList<Integer>();

	public int up = -8;
	public int down = 8;
	public int left = -1;
	public int right = 1;
	
	public int up_left = -9;
	public int down_left = 7;
	public int up_right = -7;
	public int down_right = 9;

	public int N_up_left = -17;
	public int N_up_left_side = -10;
	public int N_back_left_side = 6;
	public int N_back_left = 15;
	public int N_up_right = -15;
	public int N_up_right_side = -6;
	public int N_back_right_side = 10;
	public int N_back_right = 17;
	
	public boolean hasMoved = false;
	public int originalLocation;
	
	private int location;
	private int color = 0; // 0 = White, 1 = Black
	private int type;
	private String imgsrc;
	
	// Getters
	public int getLocation() { return location; }
	public int getColor() { return color; }
	public String getColor(int color) { 
		if (color == 0)
			return "White";
		else 
			return "Black";
	}
	public int getType() { return type; }
	public int getType(int type) { 		
		switch(type) {
			case 0:
			case 1: return 'P';
			case 2:
			case 3: return 'R';
			case 4:
			case 5: return 'N';
			case 6:
			case 7: return 'B';
			case 8:
			case 9: return 'Q';
			case 10:
			case 11: return 'K';
		}
		return type;
	
	}
	public String getImgsrc() { return imgsrc; }
	
	// Setters
	public void setLocation(int l) { location = l; }
	public void setColor(int c) { color = c; }
	public void setType(char t) { 
		switch(t) {
			case 'P': type = 0; break;
			case 'p': type = 1;	break;
			case 'R': type = 2; break;
			case 'r': type = 3; break;
			case 'N': type = 4; break;
			case 'n': type = 5; break;
			case 'B': type = 6; break;
			case 'b': type = 7; break;
			case 'Q': type = 8; break;
			case 'q': type = 9; break;
			case 'K': type = 10; break;
			case 'k': type = 11; break;
		}
		
		if(color == 1) {
			up *= -1;	down *= -1;
			left *= -1;	right *= -1;
			
			up_left *= -1;	up_right *= -1;
			down_left *= -1; down_right *= -1;

			N_up_left *= -1; N_up_right *= -1;
			N_up_left_side *= -1; N_up_right_side *= -1;
			N_back_left_side *= -1; N_back_right_side *= -1;
			N_back_left *= -1; N_back_right *= -1;

		}
		
	} 
	
	public void displayPI() { System.out.printf("%s, %s, %s, %s%n",type, location, color, imgsrc); }
	
	// Methods
	public void importValues(char n, int l) {

		String url1 = "C:/Users/AMD/Desktop/Surchessake/surchessake/Eclipse Project/images/", url2 = ".png";
		//String url1 = "images/", url2 = ".png";
		
		// Convert Char n to String (ASCII flex)
		if((n + 0) > 97 && (n + 0) < 122)
			color = 1;
		setType(n);
		imgsrc = url1 + Integer.toString(type) + url2;
		location = l;
		originalLocation = l;
    
	}

	public static boolean isPiece(int location, ArrayList<Piece> LAN_BOARD) {
		boolean pieceFound = false;

		for (int i = 0; i < LAN_BOARD.size(); i++) {
			if (location == LAN_BOARD.get(i).getLocation()) 
				pieceFound = true;
		}
		return pieceFound;
	}


	public static int getPieceIndex(int location, ArrayList<Piece> LAN_BOARD) {
		int l = -1;
		if(location > 63 || location < 0)
			return 69;
		else {
			for (int i = 0; i < LAN_BOARD.size(); i++) {
				if (location == LAN_BOARD.get(i).getLocation()) 
					l = i;
			}
			return l;
		}
	}

	public static boolean isInCheck(int color) { // 10 and 11
		boolean check = false;
		int kingIndex = -1;

		if (color == 0) { // Checking if White King is in check.

			for (int i = 0; i < chessboard.LAN_BOARD.size(); i++) {
				if (chessboard.LAN_BOARD.get(i).getType() == 10)
					kingIndex = chessboard.LAN_BOARD.get(i).getLocation();
			}

		} else if (color == 1) { // Checking if Black King is in check.

			for (int i = 0; i < chessboard.LAN_BOARD.size(); i++) {
				if (chessboard.LAN_BOARD.get(i).getType() == 11)
					kingIndex = chessboard.LAN_BOARD.get(i).getLocation();
			}

		}

		for (int i = 0; i < chessboard.LAN_BOARD.size(); i++) { // For each piece.
			chessboard.LAN_BOARD.get(i).updateLegalMoves(chessboard.checkPiece); // Update the legal moves.
			for (int j = 0; j < chessboard.LAN_BOARD.get(i).getLegalMoves().size(); j++) { // For each legal move.
				if (chessboard.LAN_BOARD.get(i).getLegalMoves().get(j) == kingIndex)
					check = true;
			}
		}

		if (check)
			System.out.println("The king is in check!");
		else
			System.out.println("The king is NOT in check!");
			
		return check;
	}

	public void updateLegalMoves(int[] indexedPieceArray) {}
	
	public ArrayList<Integer> getLegalMoves() { return new ArrayList<Integer>(); }
	public void resetLegalMoves() {
		legalMoves.clear();
	}
}

