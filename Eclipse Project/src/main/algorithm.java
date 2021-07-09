package main;
import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;

public class algorithm {
	
	static ArrayList<Color> legalMoveColors = new ArrayList<Color>();
	static Color tempColor;
	

//	public static void displayCurrentPossibleMoves(int location, boolean doDisplay) {
//		
//		try {
//			
//			// Storing the squareColor of the current square piece is on
//			if (chessboard.squareArray.get(location).getBackground() == Color.DARK_GRAY)
//				tempColor = Color.DARK_GRAY;
//			else
//				tempColor = Color.WHITE;
//		
//			// Storing legalMoveSquares' colors
//			for (int j = 0; j < chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().size(); j++) {
//				
//				if(chessboard.squareArray.get(chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().get(j)).getBackground() == Color.DARK_GRAY)
//					legalMoveColors.add(Color.DARK_GRAY);
//				else
//					legalMoveColors.add(Color.WHITE);
//				chessboard.squareArray.get(chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().get(j)).setBackground(Color.YELLOW);
//			
//			}
//			
//			if(doDisplay) { 
//				chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).updateLegalMoves(chessboard.checkPiece);
//	//			System.out.printf("%d had %d moves: ", location, chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().size());
//				// Display current piece's legal moves (locationIndex)
//				for (int j = 0; j < chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().size(); j++) {
////					System.out.printf("%d ", chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().get(j));				
//				}
//	//			System.out.printf("!%n");
//			}
//		
//		
//		
//		
//	
//		
//		if(doDisplay)
//			// originalSquare's color set to Red
//			main.chessboard.squareArray.get(location).setBackground(Color.RED);
//		
//		
//		if(!doDisplay) {
//			chessboard.updateCheckPiece(chessboard.LAN_BOARD);
//			// Restore originalSquare's color
//			if (tempColor == Color.DARK_GRAY)
//				chessboard.squareArray.get(location).setBackground(Color.DARK_GRAY);
//			else
//				chessboard.squareArray.get(location).setBackground(Color.WHITE);
//
//			// Restore legalMoveSquares' colors
//			for (int j = 0; j < legalMoveColors.size(); j++) {
//				if (legalMoveColors.get(j) == Color.DARK_GRAY)
//					chessboard.squareArray.get(chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().get(j)).setBackground(Color.DARK_GRAY);
//				else
//					chessboard.squareArray.get(chessboard.LAN_BOARD.get(chessboard.getPieceIndex(location)).getLegalMoves().get(j)).setBackground(Color.WHITE);
//			}	
//			System.out.println(legalMoveColors.size());
//		}
//		legalMoveColors.clear();
//
//		} catch(Exception E) {
//			System.out.println(E.getMessage());
//		}
//	}
//	
	public static void displayAllPossibleMoves() {
		
		int sum = 0;
		for (int i = 0; i < chessboard.LAN_BOARD.size(); i++){
			chessboard.LAN_BOARD.get(i).updateLegalMoves(chessboard.checkPiece);
			sum += chessboard.LAN_BOARD.get(i).getLegalMoves().size();
			System.out.printf("%d had %d moves:! ", chessboard.LAN_BOARD.get(i).getLocation(), chessboard.LAN_BOARD.get(i).getLegalMoves().size());
			
			Color tempColor;
			ArrayList<Color> legalMoveColors = new ArrayList<Color>();

			for (int j = 0; j < chessboard.LAN_BOARD.get(i).getLegalMoves().size(); j++) {
				System.out.printf("%d ", chessboard.LAN_BOARD.get(i).getLegalMoves().get(j));				
			}
			System.out.printf("%n");
			
			if (chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLocation()).getBackground() == Color.DARK_GRAY)
				tempColor = Color.DARK_GRAY;
			else
				tempColor = Color.WHITE;
			
			main.chessboard.squareArray.get(main.chessboard.LAN_BOARD.get(i).getLocation()).setBackground(Color.RED);
			
			for (int j = 0; j < chessboard.LAN_BOARD.get(i).getLegalMoves().size(); j++) {
				
				if(chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLegalMoves().get(j)).getBackground() == Color.DARK_GRAY)
					legalMoveColors.add(Color.DARK_GRAY);
				else
					legalMoveColors.add(Color.WHITE);
				chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLegalMoves().get(j)).setBackground(Color.YELLOW);
				
			}

			Scanner input = new Scanner(System.in);  // Create a Scanner object
    		System.out.println("Enter anything to continue..");
    	//	String userName = input.nextLine();  // Read user input
    
    		if (tempColor == Color.DARK_GRAY)
				chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLocation()).setBackground(Color.DARK_GRAY);
			else
				chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLocation()).setBackground(Color.WHITE);

	 		for (int j = 0; j < legalMoveColors.size(); j++) {
				System.out.println(legalMoveColors.size());
				if (legalMoveColors.get(j) == Color.DARK_GRAY) {
					System.out.println("Reseting black square!");
					main.chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLegalMoves().get(j)).setBackground(Color.DARK_GRAY);
				} else {
					System.out.println("Reseting white square!");
					main.chessboard.squareArray.get(chessboard.LAN_BOARD.get(i).getLegalMoves().get(j)).setBackground(Color.WHITE);
				}
				
			}
			legalMoveColors.clear();

		}
		System.out.println(sum);
		
	}


}
