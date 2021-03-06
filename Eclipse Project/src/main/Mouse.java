package main;

import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.*;

public class Mouse implements MouseListener {
	
	static String name;
	int location;
	
	static boolean clicked = false;
	static int onChessboard;
	static int currentSquare;
	static int newSquare;
	static int originalSquare;
	
	
	static Point currentPointerLocation = MouseInfo.getPointerInfo().getLocation();

	
	public String getName() { return name; }
	public void setName(String n) {	name = n; }

	public int getLocation() { return location; }
	public void setLocation(int i) { location = i; }
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// Mouse is still on the chessboard!
		if (onChessboard == 1) {
			clicked = true;		
			originalSquare = location;		
		}
		
		// Sets the current cursor to a hand cursor.
		chessboard.currentCursorType = Cursor.getPredefinedCursor(12);
		surchessake.applicationWindow.setCursor(chessboard.currentCursorType);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		// Mouse is still on the chessboard!
		if (onChessboard == 1) { 
			clicked = false;
			newSquare = location;
		}
		
		// Sets the current cursor back to the default cursor.
		chessboard.currentCursorType = Cursor.getDefaultCursor();
		surchessake.applicationWindow.setCursor(chessboard.currentCursorType);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		onChessboard++;
		currentSquare = location;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		onChessboard--;
	}
}
