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
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400,300);
		g.setColor(Color.BLACK);
		g.fillArc(10, 0, 150, 150, 90, value);
		g.setColor(Color.WHITE);
		g.fillOval(40, 30, 90, 90);	
		g.setColor(Color.BLACK);
		g.drawString(""+ (-1) * value, 70, 80);
	}	
	
	public void addKnobMouseWheelListener(MouseWheelListener  knobMouseWheelListener){	
		this.addMouseWheelListener(knobMouseWheelListener);
	}
	
	public void setValue(int value){
		this.value = value;
		repaint();
	}

}
