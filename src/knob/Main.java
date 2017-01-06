package knob;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
	
public class Main{	
	
	KnobView knobView = new KnobView(200);	
	KnobModel knobModel = new KnobModel();
	KnobController knobController =new KnobController(knobModel,knobView);
		
	
	JFrame frame = new JFrame("Knob");
	Container pane = frame.getContentPane();
    
	
	public Main(){
		KnobView knobView2 = new KnobView();		
		knobController.register(knobView2);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane.setLayout(new BorderLayout()); 
		pane.add(knobView2, BorderLayout.EAST);
	    pane.add(knobView, BorderLayout.WEST);
	    	    
	    frame.pack();
	    frame.setVisible(true);	    
	}
	
	public static void main(String[] args) {		
		new Main();
	}
}
