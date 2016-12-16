package knob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseWheelListener;
import javax.swing.JComponent;

public class KnobView extends JComponent  {

	private static final long serialVersionUID = 1L;
	
	int x;
	int y;
	int xL;
	int yL;
	int size;
	
	
	private int value;

	public KnobView() {
		super();
		x=0;
		y=0;
		size=150;
	}
	
	public KnobView(int x, int y, int size){
		this.x=x;
		this.y=y;
		this.size=size;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(x, y, size, size);
		g.setColor(Color.BLACK);
		g.fillArc(x, y, size, size, 90, value);
		g.setColor(Color.WHITE);
		g.fillOval(size/5, size/5, (int)(size/1.666), (int)(size/1.666));	
		g.setColor(Color.BLACK);
		g.drawString(""+ (-1) * value, (int)(size/2.4), (int)(size/1.9));
	}	
	
	public void addKnobMouseWheelListener(MouseWheelListener  knobMouseWheelListener){	
		this.addMouseWheelListener(knobMouseWheelListener);
	}
	
	public void setValue(int value){
		this.value = value;
		repaint();
	}

}
