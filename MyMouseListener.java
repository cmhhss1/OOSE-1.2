package edu.jhu.cs.cseidel5.oose;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;

public class MyMouseListener extends MouseAdapter implements MouseWheelListener {

	private MyBrickusFrame frame;
	
	public MyMouseListener(MyBrickusFrame arg0){
		frame = arg0;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0){
		if (arg0.getButton() == MouseEvent.BUTTON1){
			if (arg0.getSource() instanceof MyPiecePanel){
				frame.pieceClicked((MyPiecePanel) arg0.getSource());
			}
		}
		else if (arg0.isShiftDown() && arg0.getButton() == MouseEvent.BUTTON3){
			frame.flip(true);
			System.out.println("flip horiz");
		}
		else if (arg0.getButton() == MouseEvent.BUTTON3){
			frame.flip(false);
		}
	}
	
}
