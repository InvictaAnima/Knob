package knob;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedList;
import java.util.List;


public class KnobController {

	private KnobModel knobModel;
	private List<KnobView> observers;
	
	public KnobController(KnobModel knobModel, KnobView knobView) {
		this.knobModel = knobModel;
		
		observers = new LinkedList<>();
		register(knobView);		
	}
	
	//Observer pattern
	public void register(KnobView kv){
		kv.addKnobMouseWheelListener(new KnobMouseWheelListener());
		kv.addKnobMouseListener(new KnobMouseListener());
		observers.add(kv);
	}
	
	public void unregister(KnobView kv){
		observers.remove(kv);
	}
	
	public void notifyObservers(){
		for (KnobView kv : observers) {
	        	kv.update(knobModel.getValue());
	    }
	}
	
	//
	
	public boolean isMouseOnKnob(KnobView kv,int mouseX, int mouseY){
				
			int kX = kv.getX(); // knob X
			int kY = kv.getY(); // knob Y
			int kSize = kv.getKnobSize(); //knob Size
			
			
			if(mouseX >= kX && mouseX <= kX+kSize &&
			   mouseY >= kY && mouseY <= kY+kSize){
				
				return true;
			} else {
				return false;
			}				
	}

	class KnobMouseWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int rotation = e.getWheelRotation();
			
			for (KnobView kv : observers) {				
				if(isMouseOnKnob(kv,e.getX(),e.getY())){
					knobModel.calculateByRotation(rotation);				
					notifyObservers();
				}
			}			
		}		
	}

	class KnobMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e){
		}

		@Override
		public void mouseEntered(MouseEvent e){
		}

		@Override
		public void mouseExited(MouseEvent e){
		}

		@Override
		public void mousePressed(MouseEvent e){
			int value = 0;
			
			for (KnobView kv : observers) {
				kv.updateXY(e.getX(), e.getY());
				int yV = kv.getCenterY();
				int xV = kv.getCenterX();
				double a = (double)(-1)*(e.getY()-yV)/(e.getX()-xV); //aX ratio
				double angle = (Math.atan(a) + Math.PI/2)/Math.PI;
				
				value = (int)((-1)*angle*360);				
			}
			
			
			knobModel.setValue(value);
			notifyObservers();		
			
		}

		@Override
		public void mouseReleased(MouseEvent e){
		}
	}

}
