package edu.jhu.cs.cseidel5.oose;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

public class MyPieceTray extends JPanel {

	private MyMouseListener ml;
	private BrickusModel model;
	private ArrayList<MyPiecePanel> pieces;
	
	public MyPieceTray(BrickusModel arg0, MyMouseListener arg1) {
		model = arg0;
		ml = arg1;
		MyPiecePanel temp;
		pieces = new ArrayList<MyPiecePanel>();
		this.setLayout(new GridLayout(3,7));
		for (BrickusPiece p : model.getPieces(model.getActivePlayer())){
			temp = new MyPiecePanel(model, p, ml);
			this.add(temp);
			pieces.add(temp);
			
		}
	}
	
}
