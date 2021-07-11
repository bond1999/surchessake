package main;

public class surchessake {

	public static void main(String[] args) {

		PGN.readPGN(reader.readPGNFromFile("C:/Users/AMD/Desktop/Surchessake/surchessake/Eclipse Project/games/blake-win.pgn"));
		System.out.println(PGN.writePGN());

		reader.readLAN(reader.SETUP_BOARD); // Sets up board with default LAN string.
		chessboard.displayBoard(); // Creates the JFrames, JPanels, etc. and ArrayList for board info.

		// Mouse and Piece Movement Thread
		Thread chessboardThread = new Thread(new chessboard());
		chessboardThread.start();
	}
	
}
