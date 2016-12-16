package knob;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class KnobController {

	private KnobModel knobModel;
	private KnobView knobView;
	
	public KnobController(KnobModel knobModel,KnobView knobView){
		this.knobModel=knobModel;
		this.knobView=knobView;
		
		knobView.addKnobMouseWheelListener(new KnobMouseWheelListener());
	}
	
	class KnobMouseWheelListener implements MouseWheelListener {

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			int ratation = e.getWheelRotation();
			
			if(ratation>0){
				knobModel.setValue(knobModel.getValue()+10);
			} else {
				knobModel.setValue(knobModel.getValue()-10);
			}
			
			knobView.setValue(knobModel.getValue());			
		}
		
	}
	
}
