package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class surchessake {
	
	static JFrame applicationWindow = new JFrame("Surchessake");
	static JButton newGame = new JButton("New Game");
	
	static Thread chessboardThread = new Thread(new chessboard());
	
	public static void main(String[] args) {
try {
		JPanel chessboard = workers.displayChessboard();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/legalmove.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(applicationWindow.getX(), applicationWindow.getY()), "img");
		applicationWindow.setCursor(c);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
//		 The JFrame applicationWindow to display the game
		applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applicationWindow.setPreferredSize(new Dimension(896, 640));
		applicationWindow.setLayout(new GridBagLayout());
		applicationWindow.setResizable(false);
		applicationWindow.setVisible(true);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 8;
		gbc.gridwidth = 8;
		
		gbc.insets = new Insets(0, 0, 0, 64);
		applicationWindow.add(chessboard, gbc);

		newGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		newGame.setVisible(true);
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("New Game button pressed!");

				PGN.Tags.clear();
				PGN.Moves.clear();
				PGN.turnOrder = 0; 
				PGN.moveNumber = 1;
				PGN.capture = false;

				main.chessboard.LAN_BOARD.removeAll(main.chessboard.LAN_BOARD);
				main.chessboard.pieceIconArray.removeAll(main.chessboard.pieceIconArray);
				reader.readLAN(reader.SETUP_BOARD);
				main.chessboard.updateCheckPiece(main.chessboard.LAN_BOARD);
				algorithm.updateAllPossibleLegalMoves();
				
				applicationWindow.repaint();
				if(!chessboardThread.isAlive())
					chessboardThread.start();	
			}
		});
		
		gbc.gridx = 10;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		
		applicationWindow.add(newGame, gbc);
		surchessake.applicationWindow.revalidate();
		applicationWindow.pack();
	}catch(Exception e) {e.printStackTrace();}
	}
	
}
