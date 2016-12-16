package knob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseWheelListener;
import javax.swing.JComponent;

public class KnobView extends JComponent  {

	private static final long serialVersionUID = 1L;
	private int value;

	public KnobView() {
		super();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);		
		g.drawArc(25, 25, 120, 120, 0, value);
		g.drawString(""+value, 72, 90);
		
	}	
	
	public void addKnobMouseWheelListener(MouseWheelListener  knobMouseWheelListener){	
		this.addMouseWheelListener(knobMouseWheelListener);
	}
	
	public void setValue(int value){
		this.value = value;
		repaint();
	}

}
