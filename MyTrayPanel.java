package edu.jhu.cs.cseidel5.oose;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;

public class MyTrayPanel extends JPanel {

	private BrickusModel model;
	private MyMouseListener ml;
	private MyPieceTray pieces;
	
	public MyTrayPanel(BrickusModel arg0, MyMouseListener arg1) {
		model = arg0;
		ml = arg1;
		
		this.setLayout( new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        
        pieces = new MyPieceTray(model, ml);
        cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 0;
		cons.gridwidth = 30;
		this.add(pieces, cons);
		
		JButton passButton = new JButton("Pass");
		passButton.addActionListener(new passListener());
		cons.fill = GridBagConstraints.BOTH;
		cons.gridx = 30;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.gridwidth = 1;
		this.add(passButton, cons);
        
	}

	class passListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			model.pass(model.getActivePlayer());
			System.out.println("Active Player: " + model.getActivePlayer());
			repaint();
		}
		
	}
	
}


