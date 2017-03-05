
public class Calculator {
	
	private static final int F_WIDTH = 350;
	private static final int F_HEIGHT = 350;
	
	private Display window;
	private static StringBuffer cBuffer;
	
	//add
	//subtract
	//mult
	//div
	
	
	public static void main(String[] args){
		
		Calculator c = new Calculator(F_WIDTH, F_HEIGHT);
		cBuffer = new StringBuffer();
		c.clear();
	}
	
	public Calculator(int width, int height){
		this.window = new Display(this, width, height);
	}
	
	public void clear(){
		if (cBuffer.length() > 0){
			cBuffer.delete(0, cBuffer.length());			
		}

		window.setOutput((double) 0.0);
	}
	
}
