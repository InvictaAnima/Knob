package knob;

public class KnobModel {
	
	private double angle;	
	private int value;
	private int maxValue;
	
	public KnobModel(){
		maxValue = 100;
	}
	
	public KnobModel(int maxValue){
		this.maxValue = maxValue;
	}
	
	public void calculateByRotation(int rotation) {
		
		if (rotation > 0) {
			angle += 10;
			value = (int)angle * maxValue / 360;
		} else {
			angle -= 10;
			value = (int)angle * maxValue / 360;
		}
		
	}

	public void calculateFromMouseClick(int xV, int yV, int mouseX, int mouseY) {

		double a = (double)(-1)*(mouseY-yV)/(mouseX-xV); //aX ratio		
		
		if(mouseX>=xV){
			angle =  90 - (Math.atan(a) * 180 / Math.PI);
		} else {
			angle =  90 - (Math.atan(a) * 180 / Math.PI) + 180;
		}
		
		angle =(-1) * Math.ceil(angle);
		value = (int)(angle/360 * maxValue);
		
	}	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getAngle() {
		return (int)angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}
	
}
