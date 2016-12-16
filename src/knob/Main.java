package knob;


import javax.swing.JFrame;

public class Main extends JFrame{		
	
	private static final long serialVersionUID = 1L;
	KnobView knobView = new KnobView();
	KnobModel knobModel = new KnobModel();
	KnobController knobController =new KnobController(knobModel,knobView);
	
	public Main(){	
		super("Knob");
		setSize(400,300); //width,height
		setLocationRelativeTo(null); //centers the window		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
				
		add(knobView);	
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
