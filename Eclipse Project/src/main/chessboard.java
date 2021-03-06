package main;

import java.awt.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

public class chessboard implements Runnable {

		
	static Cursor currentCursorType = Cursor.getDefaultCursor();
	static PGN pgnMoves;
	
	public static ArrayList<Piece> LAN_BOARD = new ArrayList<Piece>();
	static ArrayList<JPanel> squareArray = new ArrayList<JPanel>();
	static ArrayList<JLabel> pieceIconArray = new ArrayList<JLabel>();
	static int checkPiece[] = new int[64];
	
	public static void updateCheckPiece(ArrayList<Piece> pieceArray) {
		
		for (int i = 0; i < 64; i++) {
			checkPiece[i] = -1;
		}
			
		for (int i = 0; i < pieceArray.size(); i++) {
			checkPiece[pieceArray.get(i).getLocation()] = pieceArray.get(i).getType();
		}
		
	}
	
	// Function to display the Java JFrame applicationWindow with the chesschessboard layers
	
	
	// Live Piece Drag
	public void run() {
		try{
			
			// Update check piece array and all piece legal moves.
			updateCheckPiece(LAN_BOARD);
			algorithm.updateAllPossibleLegalMoves();

			// New panel for picking up a piece.
			JPanel panelInHand = new JPanel();
			panelInHand.setOpaque(false);
			panelInHand.setSize(64,64);
			panelInHand.setLayout(null);
	        
			// New label to put on new paenl.
			JLabel labelInHand = new JLabel();
			labelInHand.setSize(64,64);
			labelInHand.setVisible(true);
	        
			// Add the label to the panel.
			panelInHand.add(labelInHand);

			// Make applicationWindow glass pane.
			surchessake.applicationWindow.setGlassPane(panelInHand);
			surchessake.applicationWindow.getGlassPane().setSize(64,64);
			
			// Start off not holding a piece, and able to mess with the chessboard.
			boolean holdPiece = false;
			boolean messWithThechessboard = true;
			
			while(true) {
				Mouse.currentPointerLocation = MouseInfo.getPointerInfo().getLocation();
				
				// If the mouse is on a square with a piece.
				if(Piece.isPiece(Mouse.currentSquare, LAN_BOARD) && holdPiece == false && messWithThechessboard == true) {
					if(Mouse.clicked == true && LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getColor() == PGN.turnOrder) {
						labelInHand.setIcon(new ImageIcon(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getImgsrc()));
						holdPiece = true;
						messWithThechessboard = false;
						StringBuilder transparent = new StringBuilder(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getImgsrc());
        				transparent.insert(7, 't');
        				pieceIconArray.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).setIcon(new ImageIcon(transparent.toString()));
					}
				}
				
				// While holding a piece (you can't mess with the chessboard while holding the piece)
				if(currentCursorType == Cursor.getPredefinedCursor(12) && holdPiece == true && messWithThechessboard == false) {
					surchessake.applicationWindow.setCursor(currentCursorType);
					panelInHand.setLocation(Mouse.currentPointerLocation.x, Mouse.currentPointerLocation.y);
					panelInHand.setVisible(true);

					//System.out.println(Mouse.currentPointerLocation.x);
					//System.out.println(Mouse.currentPointerLocation.y);

					// Legal Moves for the current piece are displayed with a yellow/red dot on top
					for(int i = 0; i < LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().size(); i++)
							if (!Piece.isPiece(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i), LAN_BOARD)) {
								pieceIconArray.get(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i))
//									.setIcon(new ImageIcon("C:/Users/AMD/Desktop//Surchessake/surchessake/Eclipse Project/images/legalmove.png"));
									.setIcon(new ImageIcon("images/legalmove.png"));
							}
							else {
								pieceIconArray.get(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i))
//									.setIcon(new ImageIcon("C:/Users/AMD/Desktop/Surchessake/surchessake/Eclipse Project/images/ct" + Integer.toString(LAN_BOARD.get(Piece.getPieceIndex(LAN_BOARD.get(Piece.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i), LAN_BOARD)).getType()) + ".png"));
									.setIcon(new ImageIcon("images/ct" + Integer.toString(LAN_BOARD.get(workers.getPieceIndex(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i), LAN_BOARD)).getType()) + ".png"));
							}
							
					
					messWithThechessboard = false;
				}
				
				// Dropping a piece.
				if(currentCursorType == Cursor.getDefaultCursor() && messWithThechessboard == false && holdPiece == true) {
					
					// Legal Moves for the current piece are reset back to original
					for(int i = 0; i < LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().size(); i++)
						if(checkPiece[LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i)] == -1)
							pieceIconArray.get(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i)).setIcon(null);
						else {
							pieceIconArray.get(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i))
//								.setIcon(new ImageIcon("C:/Users/AMD/Desktop/Surchessake/surchessake/Eclipse Project/images/" + Integer.toString(LAN_BOARD.get(Piece.getPieceIndex(LAN_BOARD.get(Piece.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i), LAN_BOARD)).getType()) + ".png"));
								.setIcon(new ImageIcon("images/" + Integer.toString(LAN_BOARD.get(workers.getPieceIndex(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().get(i), LAN_BOARD)).getType()) + ".png"));
								
							}
					// If the square to drop on is a legal move.
					if (LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getLegalMoves().contains(Mouse.currentSquare)) {
						System.out.println("That was a legal move!");
						
						
						// Sets the icon for the square moved to and removes the icon from the original square.
						pieceIconArray.get(Mouse.currentSquare).setIcon(new ImageIcon(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getImgsrc()));
						panelInHand.setVisible(false);
												
						// Update Piece ArrayList
						if(Mouse.currentSquare != Mouse.originalSquare) {
							
							PGN.updatePGN(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)), Mouse.currentSquare);
							updateCheckPiece(LAN_BOARD);

							if (Piece.isPiece(Mouse.currentSquare, LAN_BOARD) && Mouse.clicked == false) {
								LAN_BOARD.remove(workers.getPieceIndex(Mouse.currentSquare, LAN_BOARD));
							}
							pieceIconArray.get(Mouse.originalSquare).setIcon(null);	
							LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).setLocation(Mouse.currentSquare);
						}
						
						// Display update chessboard with current pieces
						updateCheckPiece(LAN_BOARD);
						algorithm.updateAllPossibleLegalMoves();

					} else { // If the square to drop on is NOT a legal move
						System.out.println("That was an illegal move!");
						pieceIconArray.get(Mouse.originalSquare).setIcon(new ImageIcon(LAN_BOARD.get(workers.getPieceIndex(Mouse.originalSquare, LAN_BOARD)).getImgsrc()));
						panelInHand.setVisible(false);
					}
						
					// After dropping a pice, we are no longer holding one and can mess with the chessboard again.
					holdPiece = false;					
					messWithThechessboard = true;

				}
				//surchessake.playArea.revalidate();
				surchessake.applicationWindow.revalidate();
			}
		} catch (Exception e) {
			System.out.print("while(true) threw an exception!!!!!!!");
			e.printStackTrace();
		}
	}
}