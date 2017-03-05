
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Display extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calculator calc;
	
	private static JButton[] digits;
	private static JTextField output;
	private static JButton clear, add, sub, mult, div, dec;
	
	private StringBuffer label = new StringBuffer();
	
	private double memory = 0;
	private double lblmem = 0;
	
	private boolean memEmpty = true;
	private byte operation = 0; //256 operation limit
	/*
	 * 0 - none
	 * 1 - addition
	 * 2 - subtraction
	 * 3 - multiplication
	 * 4 - division 
	 */
	
	
	/*
	 * Display Constructor
	 */
	public Display(Calculator calc, int width, int height){
		
		this.calc = calc;
		this.setSize(width, height);
		this.setVisible(true);
		this.setLayout(null);
		
		drawButtons(this);
		drawControl(this);
		
	}
	
	public static void drawButtons(Display d){

		digits = new JButton[10];
		
		for(int i=0; i< digits.length;i++){
			digits[i] = new JButton();
			digits[i].setSize(50, 50);
			digits[i].setVisible(true);
			digits[i].setText(Integer.toString(i));
			digits[i].addActionListener(d);
			
			if (i == 0){
				digits[i].setLocation(100, 250);
			}else if(i == 1 || i == 2 || i == 3){
				digits[i].setLocation(i*50, 100);
			}else if(i == 4 || i == 5 || i == 6){
				digits[i].setLocation((i-3)*50, 150);
			}else{
				digits[i].setLocation((i-6)*50, 200);
			}
			d.add(digits[i]);
		}
	}

	public void setOutput(String s){
		output.setText(s);
	} 
	
	public void setOutput(double d){
		output.setText(Double.toString(d));
	}
	
	public void setOutput(int i){
		output.setText(Integer.toString(i));
	}
	
	
	public static void drawControl(Display d){
		
		output = new JTextField();
		d.add(output);
		
		output.setBounds(20, 20, 300, 40);
		output.setVisible(true);
		output.setEditable(true);
		
		add = new JButton("+");
		add.addActionListener(d);
		
		clear = new JButton("C");
		clear.addActionListener(d);
		
		sub = new JButton("-");
		sub.addActionListener(d);
		
		mult = new JButton("*");
		mult.addActionListener(d);
		
		div = new JButton("/");
		div.addActionListener(d);
		
		dec = new JButton(".");
		dec.addActionListener(d);
		
		d.add(add);
		d.add(sub);
		d.add(mult);
		d.add(div);
		
		d.add(clear);
		d.add(dec);

		add.setBounds(250, 100, 50, 50);
		sub.setBounds(250, 150, 50, 50);
		mult.setBounds(250, 200, 50, 50);
		div.setBounds(250, 250, 50, 50);
		
		clear.setBounds(150, 250, 50, 50);
		dec.setBounds(50, 250, 50, 50);
	}
	
	private double calculate(double num1, double num2, byte operation){
		
		double result;
		
		if (operation == 0){
			result = 0;;
		}else if(operation == 1){
			result = (num1 + num2);
		}else if(operation == 2){
			result = (num1 - num2);
		}else if (operation == 3){
			result = (num1 * num2);
		}else if (operation == 4){
			if (num2 == 0){
				result = 0;
			}else{
				result = (num1 / num2);
			}
		}else{
			result = 0;
		}
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == clear){
			
			this.label.delete(0, label.length());
			memory = 0; lblmem = 0;
			memEmpty = true;
			operation = 0;
			
			this.setOutput(0.0);
			
		}else if(((JButton) e.getSource()).getText().equals("0")){
			
			if (label.length() > 0){
				label.append("0");
				this.setOutput(label.toString());
			}else{
				this.setOutput(0);				
			}
			
		}else if(((JButton) e.getSource()).getText().equals("1")){
			
			label.append("1");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("2")){
			label.append("2");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("3")){
			label.append("3");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("4")){
			label.append("4");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("5")){
			label.append("5");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("6")){
			label.append("6");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("7")){
			label.append("7");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("8")){
			label.append("8");
			this.setOutput(label.toString());
			
		}else if(((JButton) e.getSource()).getText().equals("9")){
			label.append("9");
			this.setOutput(label.toString());
			
		}else if(e.getSource().equals(dec)){
			
			if (label.length() > 0 && !label.toString().contains(".")){
				label.append('.');
				this.setOutput(label.toString());
			}else if (label.length() == 0){
				label.append("0.");
				this.setOutput(label.toString());
			}
			
		}else if(e.getSource().equals(add)){
			
			String operand = label.toString();
			
			if (memEmpty){ //might need to use memflag
				
				if(operand.length() > 0){
					memory = Double.parseDouble(operand);				
				}else{
					memory = 0;
				}
				
				operation = 1;
				memEmpty = false;
				label.delete(0, label.length());
				this.setOutput("");
				
			}else{
				
				if(operand.length() > 0){
					lblmem = Double.parseDouble(operand);					
				}else{
					lblmem = 0;
				}
				
				if (operation != 0){
					double result = calculate(memory, lblmem, operation);
					memory = result;
					operation = 1;
					
					label.delete(0, label.length());
					this.setOutput(result);
				}
			}

		}else if(e.getSource().equals(sub)){
			
			String operand = label.toString();
			
			if (memEmpty){ //might need to use memflag
				
				if(operand.length() > 0){
					memory = Double.parseDouble(operand);				
				}else{
					memory = 0;
				}
				
				operation = 2;
				memEmpty = false;
				label.delete(0, label.length());
				this.setOutput("");
				
			}else{
				
				if(operand.length() > 0){
					lblmem = Double.parseDouble(operand);					
				}else{
					lblmem = 0;
				}
				
				if (operation != 0){
					double result = calculate(memory, lblmem, operation);
					memory = result;
					operation = 2;
					
					label.delete(0, label.length());
					this.setOutput(result);
				}
				
			}
			
		}else if(e.getSource().equals(mult)){
				String operand = label.toString();
			
			if (memEmpty){ //might need to use memflag
				
				if(operand.length() > 0){
					memory = Double.parseDouble(operand);				
				}else{
					memory = 0;
				}
				
				operation = 3;
				memEmpty = false;
				label.delete(0, label.length());
				this.setOutput("");
				
			}else{
				
				if(operand.length() > 0){
					lblmem = Double.parseDouble(operand);					
				}else{
					lblmem = 0;
				}
				
				if (operation != 0){
					double result = calculate(memory, lblmem, operation);
					memory = result;
					operation = 3;
					
					label.delete(0, label.length());
					this.setOutput(result);
				}
			}
			
		}else if (e.getSource().equals(div)){
			
	String operand = label.toString();
			
			if (memEmpty){ //might need to use memflag
				
				if(operand.length() > 0){
					memory = Double.parseDouble(operand);				
				}else{
					memory = 0;
				}
				
				operation = 4;
				memEmpty = false;
				label.delete(0, label.length());
				this.setOutput("");
				
			}else{
				
				if(operand.length() > 0){
					lblmem = Double.parseDouble(operand);					
				}else{
					lblmem = 0;
				}
				
				if (operation != 0){
					double result = calculate(memory, lblmem, operation);
					memory = result;
					operation = 4;
					
					label.delete(0, label.length());
					this.setOutput(result);
				}
			}
		}
	}
}
