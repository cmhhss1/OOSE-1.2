package edu.jhu.cs.cseidel5.oose;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusPiece;
import edu.jhu.cs.oose.fall2013.brickus.iface.Player;


public class MyGridPanel extends JPanel {
	
	private MyMouseListener ml;
	private int rows, cols;
	private int width, height;
	private int coveredx, coveredy;
	private BrickusModel model;
	private ArrayList<ArrayList<Rectangle>> cells;
	private BrickusPiece currPiece;
	
	public MyGridPanel(BrickusModel arg0, MyMouseListener arg1){
		model = arg0;
		ml = arg1;
		currPiece = null;
//		this.setSize(600,600);
		this.setBackground(Color.ORANGE);
		cols = model.getWidth();
		rows = model.getHeight();
		width = this.getWidth();
		height = this.getHeight();
		cells = new ArrayList<ArrayList<Rectangle>>();

		
		MouseAdapter mouse = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0){
				int w = getWidth();
				int h = getHeight();
				int sideWidth = w/cols;
				int sideHeight = h/rows;
				
				coveredx = arg0.getX() / sideWidth;
				coveredy = arg0.getY() / sideHeight;
				
				//System.out.println("x: " + coveredx + " y: " + coveredy);
			}
		};
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();
//		System.out.println("Repainting");
		
		cells = new ArrayList<ArrayList<Rectangle>>();
		for (int i = 0; i<rows; i++){
			cells.add(new ArrayList<Rectangle>());
		}
		
		width = this.getWidth();
		height = this.getHeight();
		
		int sideWidth = width/cols;
		int sideHeight = height/rows;
		Rectangle t;
				
		for (int y = 0; y<rows; y++){
			for (int x = 0; x<cols; x++){
				t = new Rectangle(x*sideWidth, y*sideHeight, sideWidth, sideHeight);
				cells.get(y).add(t);
			}
		}
		
//		System.out.println("w: " + width + ", h: " + height);
		repaint();
		
		for (ArrayList<Rectangle> r: cells){
			for (Rectangle c : r){
				if (model.getContents(cells.indexOf(r), r.indexOf(c)) == Player.PLAYER1){
					g2d.setColor(Color.RED);
				}
				else if (model.getContents(cells.indexOf(r), r.indexOf(c)) == Player.PLAYER2){
					g2d.setColor(Color.BLUE);
				}
				else{
					g2d.setColor(Color.WHITE);
				}
				if (coveredx < rows && coveredy < cols && coveredx >= 0 && coveredy >= 0 && currPiece != null){
					if (cells.indexOf(r) == coveredy && r.indexOf(c) == coveredx){
						g2d.setColor(Color.GREEN);
					}
				}
				g2d.fill(c);
			}
		}
		g2d.setColor(Color.BLACK);
		for (ArrayList<Rectangle> r: cells){
			for (Rectangle c : r){
				g2d.draw(c);
			}
		}
		g2d.dispose();
	}
	
	public void setPiece(BrickusPiece arg0){
		currPiece = arg0;
	}
	
	
	
	
}
