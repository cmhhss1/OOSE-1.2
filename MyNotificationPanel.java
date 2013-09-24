package edu.jhu.cs.cseidel5.oose;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;
import edu.jhu.cs.oose.fall2013.brickus.iface.Player;

public class MyNotificationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6163244123350551300L;
	private MyMouseListener ml;
	private BrickusModel model;
	private JLabel text;
	private JLabel score1;
	private JLabel score2;
	
	public MyNotificationPanel(BrickusModel arg0, MyMouseListener arg1) {
		model = arg0;
		ml = arg1;
	
		this.setLayout( new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
    
        JPanel notesBar = new JPanel();
        notesBar.setLayout(new GridBagLayout());
        GridBagConstraints notesCons = new GridBagConstraints();
        notesCons.fill = GridBagConstraints.BOTH;
        text = new JLabel("Error! Does not compute!");
        notesCons.gridx = 0;
		notesCons.gridy = 0;
		notesCons.weightx = 1;
		notesCons.weighty = 1;
		notesCons.gridwidth = 1;
		notesBar.add(text, notesCons);
        
		
        cons.gridx = 0;
		cons.gridy = 0;
		cons.weightx = 1;
		cons.weighty = 0;
		cons.gridwidth = 5;
		this.add(notesBar, cons);
		
		
		JPanel scoreBar = new JPanel();
        scoreBar.setLayout(new FlowLayout());

        int score = model.calculateScore(Player.PLAYER1);
        score1 = new JLabel("Score 1: " + score);
		scoreBar.add(score1);

		score = model.calculateScore(Player.PLAYER2);
		score2 = new JLabel("Score 2: " + score);
		scoreBar.add(score2);
		
		
		cons.gridx = 5;
		cons.gridy = 0;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.gridwidth = 2;
		this.add(scoreBar, cons);
		
		
	}
	
	public void updateText(String arg0){
		text.setText(arg0);
	}
	
	public void updateScores(){
		int score = model.calculateScore(Player.PLAYER1);
		score1.setText("Score 1: " + score);
		score = model.calculateScore(Player.PLAYER2);
		score2.setText("Score 2: " + score);
	}
	
	

}
