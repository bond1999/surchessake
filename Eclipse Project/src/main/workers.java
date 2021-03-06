package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class workers {

	static class GameClock extends JPanel {
		
		SimpleDateFormat timeFormat;
		JLabel timeLabel = new JLabel();
		String time;
		int increment;
		
		int milliseconds = 300000;

		public GameClock(JPanel panel, int color) {

			timeLabel.setFont(new Font("Serif", Font.PLAIN, 12));

			timeFormat = new SimpleDateFormat("mm:ss");
			time = timeFormat.format(milliseconds);
			timeLabel.setVisible(true);
			timeLabel.setBounds(0, 0, 128, 64);
			timeLabel.setAlignmentY(BOTTOM_ALIGNMENT);
			timeLabel.setText(time);
			panel.add(timeLabel, BorderLayout.NORTH);
			
			
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					if (color == 1 || PGN.moveNumber > 1)
						if (color == PGN.turnOrder) {
							milliseconds -= 1000;
							time = timeFormat.format(milliseconds);
							timeLabel.setText(time);
						}
				}
			};				
			timer.scheduleAtFixedRate(task, 0, 1000);
			
		}
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
	
	public static JPanel displayStatsBoard() {
		
		JPanel statsBoard = new JPanel();
		JPanel whiteClockPanel = new JPanel();
		JPanel blackClockPanel = new JPanel();
		JPanel movesPanel = new JPanel();

		workers.GameClock whiteTimer = new workers.GameClock(whiteClockPanel, 0);
		workers.GameClock blackTimer = new workers.GameClock(blackClockPanel, 1);
		
		blackClockPanel.setPreferredSize(new Dimension(128, 64));
		blackClockPanel.setLocation(0, 0);
		blackClockPanel.setVisible(true);
		blackClockPanel.setLayout(null);
				
		movesPanel.setPreferredSize(new Dimension(208, 256));
		movesPanel.setLocation(64, 0);
		movesPanel.setBackground(Color.green);
		movesPanel.setVisible(true);
		
		whiteClockPanel.setPreferredSize(new Dimension(128, 64));
		whiteClockPanel.setLocation(320, 0);
		whiteClockPanel.setVisible(true);
		whiteClockPanel.setLayout(null);
		
		statsBoard.setSize(208, 384);
		statsBoard.setLocation(600, 108);
		statsBoard.setBackground(Color.white);
		statsBoard.setLayout(new BorderLayout());

		statsBoard.add(blackClockPanel, BorderLayout.PAGE_START);
		statsBoard.add(movesPanel, BorderLayout.CENTER);
		statsBoard.add(whiteClockPanel, BorderLayout.PAGE_END);
		
		statsBoard.repaint();
		statsBoard.setVisible(true);

		return statsBoard;
	}
	
	public static JPanel displayChessboard() {

		JPanel chessboard = new JPanel();
		// The JPanel that displays the chess chessboard and sits in the playArea
		chessboard.setPreferredSize(new Dimension(512, 512));
//		chessboard.setLocation(44, 44);
		chessboard.setBackground(null);
		chessboard.setLayout(new GridLayout(8, 8, 0, 0));
		
		
		int squareIndex = 0;
		int flag = 0;

		// For loop to add Mouse Listeners to each Square, 64 of which are added to the Chesschessboard
		for(int i = 0; i < 8; i++) { 
			for(int j = 0; j < 8; j++) {
				
				JPanel square = new JPanel();
				// Beautiful ASCII fleing.
				char letter = (char) (j + 97);
				char number = (char) (8 - i + 48);
				//square.setSize(64, 64);
				square.setPreferredSize(new Dimension(64, 64));
				
				// Initializing MouseListeners for each square.
				Mouse mouseListener = new Mouse();
				mouseListener.setName(Character.toString(letter) + Character.toString(number));
				mouseListener.setLocation(squareIndex);
				square.addMouseListener(mouseListener);

				if (flag == 0){
					square.setBackground(Color.WHITE);
					 flag = 1;
				}else {
					square.setBackground(Color.DARK_GRAY);
					 flag = 0;
				}
				


				// add square to the arraylist
				main.chessboard.squareArray.add(square);

				square.setVisible(true);
				square.setLayout(null);
				chessboard.add(square);

				squareIndex++;

			} // For each column of the chessboard.
		
			// Flags for alternating square color.
			if (flag == 0)
				flag = 1;
			else 
				flag = 0;
				
		} // For each row of the chessboard.	



		// Set visibility.
		chessboard.setVisible(true);
//		chessboard.pack();
		return chessboard;
		
	} // displaychessboard()
	

}
