package edu.jhu.cs.cseidel5.oose;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;

public class MyBrickusFrame extends JFrame {
	
	private BrickusModel model;
	private MyGridPanel board;
	private MyTrayPanel tray;
	private MyNotificationPanel notes;
	private BrickusPiece currPiece;
	private MyPiecePanel currPiecePanel;
	
	public MyBrickusFrame( BrickusModel arg0 ){
		model = arg0;
		
		
	}
	
	public void go(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,750);
        this.setLocationRelativeTo(null);
        
		MyMouseListener ml = new MyMouseListener(this);
		this.addMouseListener(ml);
		this.addMouseWheelListener(ml);
		
		model.addBrickusListener(new MyBrickusListener(this));
        
        this.setLayout( new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        
        board = new MyGridPanel(model, ml);
//        board.setVisible(true);
//        System.out.println("Board size: " + board.getSize());
        board.setBorder(BorderFactory.createLineBorder(Color.black));
		cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.gridheight = 14;
		this.add(board, cons);
		
		tray = new MyTrayPanel(model, ml);
		tray.setBorder(BorderFactory.createLineBorder(Color.black));
		cons.gridx = 0;
		cons.gridy = 14;
		cons.weightx = 1;
		cons.weighty = 0;
		cons.gridheight = 1;
		cons.ipady = 1;
		this.add(tray, cons);
        
		notes = new MyNotificationPanel(model, ml);
		notes.setBorder(BorderFactory.createLineBorder(Color.black));
		cons.gridx = 0;
		cons.gridy = 15;
		cons.weightx = 1;
		cons.weighty = 0;
		cons.gridheight = 1;
		this.add(notes, cons);

		
		
        this.setVisible(true);
        
		
	}
	
	public void pieceClicked(MyPiecePanel p){
		if (currPiecePanel != null){
			currPiecePanel.unHighlight();
		}
		currPiece = p.highlight();
		currPiecePanel = p;
		board.setPiece(currPiece);
		tray.revalidate();
		repaint();
	}
	
	public void illegalMove(BrickusIllegalMoveEvent arg0){
		notes.updateText(arg0.getMessage());
	}
	
	public void flip(boolean arg0){
		if (currPiece != null){
			if (arg0){
				currPiece.flipHorizontally();
			}
			else{
				currPiece.flipVertically();
			}
			board.setPiece(currPiece);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7870969213878261035L;

	
}
