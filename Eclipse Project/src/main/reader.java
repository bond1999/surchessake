package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import piece.bishop;
import piece.king;
import piece.knight;
import piece.pawn;
import piece.queen;
import piece.rook;

// Read FEN and PGN
public class reader {

	public static String readPGNFromFile (String filename) {
		String fileContents = "";
		try {
			fileContents = new String (Files.readAllBytes(Paths.get(filename)));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return fileContents;
	}
	
    public static String SETUP_BOARD = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
	
	// Function to read a FEN String and create Pieces in the back-end
	public static void readLAN(String LAN) {
		
		char pString[] = LAN.toCharArray();
		int pIndex = 0;
		
		// Looping through each character in a FEN String until just the position is reconstructed
		for (int i = 0; i < LAN.length() && pString[i] != ' '; i++) {

			// Reading piece type
			if(!Character.isDigit(pString[i]) && pString[i]!= '/') {
				
				Piece newPiece = new Piece();
				switch(pString[i]) {
					case 'P':
					case 'p':
						newPiece = new pawn();
						break;
					case 'R':
					case 'r':
						newPiece = new rook();
						break;
					case 'N':
					case 'n':
						newPiece = new knight();
						break;
					case 'B':
					case 'b':
						newPiece = new bishop();
						break;
					case 'Q':
					case 'q':
						newPiece = new queen();
						break;
					case 'K':
					case 'k':
						newPiece = new king();
						break;
				}
				
				// Sets piece type and imgsrc.
				newPiece.importValues(pString[i], pIndex);				
				
				// Adding the Piece to the Piece Array
				chessboard.LAN_BOARD.add(newPiece);
				pIndex++;
			}
			// Reading piece location
			else if(Character.isDigit(pString[i]) && pString[i]!= '/')
				pIndex += (pString[i] - 48);

		}
		
		for(int k=0; k<64; k++) {
			JLabel piece = new JLabel();
			piece.setHorizontalAlignment(SwingConstants.CENTER);
	        piece.setVerticalAlignment(SwingConstants.CENTER);
	        piece.setVisible(true);
			piece.setSize(64,64);
			piece.setIcon(null);
			main.chessboard.pieceIconArray.add(piece);
			main.chessboard.squareArray.get(k).removeAll();
			main.chessboard.squareArray.get(k).add(main.chessboard.pieceIconArray.get(k));
		}
		for(int k=0; k<main.chessboard.LAN_BOARD.size(); k++)	
			main.chessboard.pieceIconArray.get(main.chessboard.LAN_BOARD.get(k).getLocation()).setIcon(new ImageIcon(main.chessboard.LAN_BOARD.get(k).getImgsrc()));
	}
	
	
//		[Event "Live Chess"]
//		[Site "Chess.com"]
//		[Date "2021.07.04"]
//		[Round "?"]
//		[White "bond1999"]
//		[Black "Elphyn"]
//		[Result "1-0"]
//		[ECO "C44"]
//		[WhiteElo "752"]
//		[BlackElo "1097"]
//		[TimeControl "300+5"]
//		[EndTime "21:36:09 PDT"]
//		[Termination "bond1999 won by checkmate"]
//
//		1. e4 e5 2. Nf3 Nc6 3. d3 Nf6 4. Bg5 d6 5. h3 h6 6. Bxf6 Qxf6 7. g3 Be6 8. b3
//		O-O-O 9. c4 Nd4 10. Nxd4 exd4 11. f3 c6 12. Nd2 d5 13. Bg2 dxc4 14. Nxc4 Bxc4
//		15. bxc4 Bb4+ 16. Kf2 g5 17. h4 gxh4 18. gxh4 Rdg8 19. h5 Qg5 20. Rh2 Qe3+ 21.
//		Kf1 Rg5 22. Qe2 Qf4 23. a3 Qxh2 24. axb4 Rhg8 25. Ra2 Qxh5 26. f4 Rxg2 27. Qxh5
//		Rg1+ 28. Kf2 R8g2+ 29. Kf3 Rxa2 30. Qf5+ Kc7 31. Qe5+ Kc8 32. Qxd4 Rf1+ 33. Kg4
//		Rg2+ 34. Kf5 h5 35. e5 Rgf2 36. Qxa7 Rxf4+ 37. Kg5 h4 38. Kh6 h3 39. Kg7 h2 40.
//		Kf8 h1=Q 41. Ke7 Qh6 42. Qa8+ Kc7 43. Qd8# 1-0

	// Example String ^
	// Function to read PGN String and create a game as per the string
	public static void readPGN(String PGN) {
		
		char pString[] = PGN.toCharArray();
		int pIndex = 0;
		
		// Looping through each character in a FEN String until just the position is reconstructed
		for (int i = 0; i < PGN.length() && pString[i] != ' '; i++) {

			// Reading piece type
			if(!Character.isDigit(pString[i]) && pString[i]!= '/') {
				
				Piece newPiece = new Piece();
				switch(pString[i]) {
					case 'P':
					case 'p':
						newPiece = new pawn();
						break;
					case 'R':
					case 'r':
						newPiece = new rook();
						break;
					case 'N':
					case 'n':
						newPiece = new knight();
						break;
					case 'B':
					case 'b':
						newPiece = new bishop();
						break;
					case 'Q':
					case 'q':
						newPiece = new queen();
						break;
					case 'K':
					case 'k':
						newPiece = new king();
						break;
				}
				
				
				// type.Piece p = new type.Piece();
				newPiece.importValues(pString[i], pIndex);				
				
				// Adding the Piece to the Piece Array
				chessboard.LAN_BOARD.add(newPiece);
				pIndex++;
			}
			// Reading piece location
			else if(Character.isDigit(pString[i]) && pString[i]!= '/')
				pIndex += (pString[i] - 48);

		}
	}
}
