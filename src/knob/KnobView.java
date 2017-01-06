package knob;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;

import javax.swing.JComponent;



public class KnobView extends JComponent { //////////

	private static final long serialVersionUID = 1L;
	
	int knobSize;	
	
	private int value;
	private int angle;

	public KnobView() {
		super();
	
		knobSize=150;
		
		Dimension d = new Dimension(knobSize, knobSize);
		setMinimumSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    
	    requestFocus();	    
	}
	
	public KnobView(int size){
		super();	

		this.knobSize=size;
		
		Dimension d = new Dimension(knobSize, knobSize);
		setMinimumSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    
	    requestFocus();	    
	}
	
	//Observer pattern
	public void update(int value, int angle) {
		setValue(value);
		setAngle(angle);
	}
	
	//

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);				
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, knobSize, knobSize);
		g.setColor(Color.BLACK);
		g.fillArc(0, 0, knobSize, knobSize, 90, angle);
		g.setColor(Color.WHITE);
		g.fillOval(knobSize/5, knobSize/5, (int)(knobSize/1.666), (int)(knobSize/1.666));	
		g.setColor(Color.BLACK);
		g.drawString(""+ (-1) * value, (int)(knobSize/2.4), (int)(knobSize/1.9));		
	}
	
	public void addKnobMouseWheelListener(MouseWheelListener  knobMouseWheelListener){	
		this.addMouseWheelListener(knobMouseWheelListener);		
	}
	
	public void addKnobMouseListener(MouseListener knobMouseListener){
		this.addMouseListener(knobMouseListener);
	}
	
	public void setValue(int value){
		this.value = value;
		repaint();
	}
	
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public int getCenterY(){
		return knobSize/2;
	}
	
	public int getCenterX(){
		return knobSize/2;
	}
	
	public int getKnobSize(){
		return this.knobSize;
	}
	
}
