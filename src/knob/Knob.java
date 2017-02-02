package knob;

public class Knob {
	KnobController kc;
	KnobModel km;
	KnobView kv;
	
	
	public Knob(int size, int maxValue){
		km = new KnobModel();
		kv = new KnobView(size,maxValue);
		kc = new KnobController(km, kv);
	}
	
	public Knob(int maxValue){
		km = new KnobModel();
		kv = new KnobView(maxValue);
		kc = new KnobController(km, kv);
	}	
	
	public void registerView(KnobView view){
		kc.register(view);
	}
	
	public KnobView getMainView(){
		return kv;		
	}
	
}
