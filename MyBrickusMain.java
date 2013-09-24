package edu.jhu.cs.cseidel5.oose;


import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusModel;

public class MyBrickusMain {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BrickusModel model = new edu.jhu.cs.oose.fall2013.brickus.model.StandardBrickusModel();
        MyBrickusFrame gui = new MyBrickusFrame(model);
        model.addBrickusListener(new MyBrickusListener(gui));
        
        gui.go();
        
        
        
	}
	
	

}
