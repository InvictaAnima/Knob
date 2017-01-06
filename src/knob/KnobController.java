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
	        	kv.update(knobModel.getValue(),knobModel.getAngle());
	    }
	}	

	//

	class KnobMouseWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int rotation = e.getWheelRotation();
			
			for (KnobView kv : observers) {				
				if(e.getComponent().equals(kv)){
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
			
			for (KnobView kv : observers) {										
					if(e.getComponent().equals(kv)){
						int yV = kv.getCenterY();
						int xV = kv.getCenterX();
					
						knobModel.calculateFromMouseClick(xV,yV, e.getX(), e.getY());
					}				
			}			
			
			notifyObservers();			
		}

		@Override
		public void mouseReleased(MouseEvent e){
		}
	}

}
