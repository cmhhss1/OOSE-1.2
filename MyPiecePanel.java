package edu.jhu.cs.cseidel5.oose;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;
import edu.jhu.cs.oose.fall2013.brickus.iface.Player;

public class MyPiecePanel extends JPanel {

	private BrickusModel model;
	private MyMouseListener ml;
	private BrickusPiece piece;

	
	public MyPiecePanel(BrickusModel arg0, BrickusPiece p, MyMouseListener arg2) {
		model = arg0;
		ml = arg2;
		piece = p;
		this.addMouseListener(ml);
		this.addMouseWheelListener(ml);
		this.setLayout(new GridLayout(5,5));
		
		int h = p.getHeight();
		int w = p.getWidth();
		int hOff; //height offset
		int wOff; // width offset
		JPanel temp;
		Color c;
		if (model.getActivePlayer() == Player.PLAYER1){
			c = Color.RED;
		}
		else{
			c = Color.BLUE;
		}
		
		//  0 1 2 3 4
		//0 x x x x x 
		//1 x x x x x
		//2 + + + + x
		//3 x x x x x
		//4 x x x x x

		if (w >= 4){
			wOff = 0;
		}
		else if(w == 2 || w == 3){
			wOff = 1;
		}
		else{
			wOff = 2;
		}
		if (h >= 4){
			hOff = 0;
		}
		else if(h == 2 || h == 3){
			hOff = 1;
		}
		else{
			hOff = 2;
		}
		
		for (int y = 0; y < 5; y++){
			for (int x = 0; x<5; x++){
				if (x < wOff || y < hOff){
					temp = new JPanel();
					temp.setBackground(Color.WHITE);
				}
				else{
					if (x-wOff < w && y-hOff < h){
						if (p.isOccupied(x-wOff, y-hOff)){
							temp = new JPanel();
							temp.setBackground(c);
							temp.setBorder(BorderFactory.createLineBorder(Color.black));

						}
						else{
							temp = new JPanel();
							temp.setBackground(Color.WHITE);

						}
					}
					else{
						temp = new JPanel();
						temp.setBackground(Color.WHITE);

					}
				}
				this.add(temp);
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public BrickusPiece highlight(){
		this.removeAll();
		int h = piece.getHeight();
		int w = piece.getWidth();
		int hOff; //height offset
		int wOff; // width offset
		JPanel temp;
		Color c;
		if (model.getActivePlayer() == Player.PLAYER1){
			c = Color.RED;
		}
		else{
			c = Color.BLUE;
		}
		
		//  0 1 2 3 4
		//0 x x x x x 
		//1 x x x x x
		//2 + + + + x
		//3 x x x x x
		//4 x x x x x

		if (w >= 4){
			wOff = 0;
		}
		else if(w == 2 || w == 3){
			wOff = 1;
		}
		else{
			wOff = 2;
		}
		if (h >= 4){
			hOff = 0;
		}
		else if(h == 2 || h == 3){
			hOff = 1;
		}
		else{
			hOff = 2;
		}
		
		for (int y = 0; y < 5; y++){
			for (int x = 0; x<5; x++){
				if (x < wOff || y < hOff){
					temp = new JPanel();
					temp.setBackground(Color.GREEN);
				}
				else{
					if (x-wOff < w && y-hOff < h){
						if (piece.isOccupied(x-wOff, y-hOff)){
							temp = new JPanel();
							temp.setBackground(c);
							temp.setBorder(BorderFactory.createLineBorder(Color.black));

						}
						else{
							temp = new JPanel();
							temp.setBackground(Color.GREEN);

						}
					}
					else{
						temp = new JPanel();
						temp.setBackground(Color.GREEN);

					}
				}
				this.add(temp);
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		return piece;
	}
	
	
	public void unHighlight(){
		this.removeAll();
		int h = piece.getHeight();
		int w = piece.getWidth();
		int hOff; //height offset
		int wOff; // width offset
		JPanel temp;
		Color c;
		if (model.getActivePlayer() == Player.PLAYER1){
			c = Color.RED;
		}
		else{
			c = Color.BLUE;
		}
		
		//  0 1 2 3 4
		//0 x x x x x 
		//1 x x x x x
		//2 + + + + x
		//3 x x x x x
		//4 x x x x x

		if (w >= 4){
			wOff = 0;
		}
		else if(w == 2 || w == 3){
			wOff = 1;
		}
		else{
			wOff = 2;
		}
		if (h >= 4){
			hOff = 0;
		}
		else if(h == 2 || h == 3){
			hOff = 1;
		}
		else{
			hOff = 2;
		}
		
		for (int y = 0; y < 5; y++){
			for (int x = 0; x<5; x++){
				if (x < wOff || y < hOff){
					temp = new JPanel();
					temp.setBackground(Color.WHITE);
				}
				else{
					if (x-wOff < w && y-hOff < h){
						if (piece.isOccupied(x-wOff, y-hOff)){
							temp = new JPanel();
							temp.setBackground(c);
							temp.setBorder(BorderFactory.createLineBorder(Color.black));

						}
						else{
							temp = new JPanel();
							temp.setBackground(Color.WHITE);

						}
					}
					else{
						temp = new JPanel();
						temp.setBackground(Color.WHITE);

					}
				}
				this.add(temp);
			}
		}
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
}
