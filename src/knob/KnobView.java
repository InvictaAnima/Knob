package knob;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;



public class KnobView extends JComponent { //////////

	private static final long serialVersionUID = 1L;
	
	int knobSize;	
	
	private int value;
	private int angle;
	
	private int newValue;
	private int newAngle;

	private int maxValue;
	public KnobView(int maxValue) {
		super();
	
		knobSize=150;
		this.maxValue=maxValue;
		Dimension d = new Dimension(knobSize, knobSize);
		setMinimumSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    
	    requestFocus();	    
	}
	
	public KnobView(int size,int maxValue){
		super();	

		this.knobSize=size;
		this.maxValue=maxValue;
		Dimension d = new Dimension(knobSize, knobSize);
		setMinimumSize(d);
	    setPreferredSize(d);
	    setMaximumSize(d);
	    
	    requestFocus();	    
	}
	
	//Observer pattern
	public void update(int value, int angle) {
//		setValue(value);
//		setAngle(angle);
		setNewValue(value);
		setNewAngle(angle);
		
		
		int ratio = 360/maxValue;
		new Timer().schedule(new TimerTask(){
		      @Override
		      public void run(){
		        if(updateValue()){
		        	this.cancel();
		        }
		      }
		    }, 0, 20 * ratio);
		
		new Timer().schedule(new TimerTask(){
		      @Override
		      public void run(){
		        if(updateAngle()){
		        	this.cancel();
		        }
		        
		      }
		    }, 0, 20);
	}
	
	public boolean updateValue(){
		
		if(value<newValue){
			value++;	
			repaint();
			return false;
		} else if(value>newValue){
			value--;	
			repaint();
			return false;
		}
		
		return true;
				
	}
	
	public boolean updateAngle(){
		
		if(angle<newAngle){
			angle++;
			repaint();
			return false;
		} else if(angle>newAngle){
			angle--;
			repaint();
			return false;
		}		
			
		return true;
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

	public void setNewValue(int newValue) {
		this.newValue = newValue;
	}

	public void setNewAngle(int newAngle) {
		this.newAngle = newAngle;
	}
	
}
