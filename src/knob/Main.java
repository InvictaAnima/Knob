package knob;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
	
public class Main{	
	
	JFrame frame = new JFrame("Knob");
	Container pane = frame.getContentPane();
    
	Knob knob;
	
	public Main(){
		knob = new Knob(200,150);
		
		KnobView kolejneKnobView = new KnobView(100);		
		knob.registerView(kolejneKnobView);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane.setLayout(new BorderLayout()); 
		
	    pane.add(knob.getMainView(), BorderLayout.WEST);
	    pane.add(kolejneKnobView, BorderLayout.EAST);    
	    
	    frame.pack();
	    frame.setVisible(true);	    
	}
	
	public static void main(String[] args) {		
		new Main();
	}
}
