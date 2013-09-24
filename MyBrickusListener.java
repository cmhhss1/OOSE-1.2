package edu.jhu.cs.cseidel5.oose;

import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusIllegalMoveEvent;
import edu.jhu.cs.oose.fall2013.brickus.iface.BrickusListener;

public class MyBrickusListener implements BrickusListener {

	private MyBrickusFrame frame;
	
	public MyBrickusListener(MyBrickusFrame arg0){
		frame = arg0;
	}
	
	@Override
	public void illegalMove(BrickusIllegalMoveEvent arg0) {
		frame.illegalMove(arg0);
		
	}

	@Override
	public void modelChanged(BrickusEvent arg0) {
		frame.validate();

	}

}
