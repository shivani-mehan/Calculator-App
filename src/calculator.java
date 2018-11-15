package calculator;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 
 * Class Calculator - A small calculator app   
 * 
 * 
 * @author shivanimehan
 * @version 1.0 
 * @since 04/11/2018
 * 
 * 
 */

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	
	// --------------------------------------------------------------------
	/** 
     * @param args
     */
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
	
	// --------------------------------------------------------------------
	
	/**
     * The Calculator constructor
     *
     */
	public Calculator() {
		this.setTitle("Calculator");
		
		this.layoutView();
        this.registerListeners();
		
	}
	
	// --------------------------------------------------------------------
	// Number buttons
	private final JButton button7 = new JButton("7");
	private final JButton button8 = new JButton("8");
	private final JButton button9 = new JButton("9");
	private final JButton button4 = new JButton("4");
	private final JButton button5 = new JButton("5");
	private final JButton button6 = new JButton("6");
	private final JButton button1 = new JButton("1");
	private final JButton button2 = new JButton("2");
	private final JButton button3 = new JButton("3");
	private final JButton button0 = new JButton("0");

	
	
	//Operator buttons
	private final JButton divide = new JButton("/");
	private final JButton multiply = new JButton("*");
	private final JButton subtract = new JButton("-");
	private final JButton add = new JButton("+");
	private final JButton equals = new JButton("=");
	private final JButton clear = new JButton("C");

	
	//Dummy buttons
	private final JButton dummy1 = new JButton(" ");
	private final JButton dummy2 = new JButton(" ");
	private final JButton dummy3 = new JButton(" ");
	private final JButton dummy4 = new JButton(" ");
	
	// Text fields
	private final JTextField input = new JTextField();
	private final JTextField output = new JTextField();


	// Calculation variables
	double firstnum;
	double secondnum;
	double result;
	String operation;
    String answer;

	
	// --------------------------------------------------------------------

	
	/**
     * Lays out the contents of the frame.
     */
    public void layoutView() {
    	//set size of window
    	this.setBounds(550,200,255,320);
    	
    	//set other details
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.getContentPane().setLayout(null);
    	
    	//Text fields
    	input.setBounds(3,10,246,32);
    	input.setEditable(false);
    	this.getContentPane().add(input);    	
    	input.setColumns(10);
    	
    	output.setBounds(3, 40, 246,32);
    	output.setEditable(false);
    	this.getContentPane().add(output);    	
    	output.setColumns(10);
    	
    	
    	//-----------Button formatting------------
    	
    	// 1st row
    	button7.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button7.setBounds(3,80,47,47);
    	this.getContentPane().add(button7);
    	
    	button8.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button8.setBounds(53,80,47,47);
    	this.getContentPane().add(button8);
    	
    	button9.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button9.setBounds(103,80,47,47);
    	this.getContentPane().add(button9);
    	
    	divide.setFont(new Font("Tahoma", Font.BOLD, 20));
    	divide.setBounds(153,80,47,47);
    	this.getContentPane().add(divide);
    	
    	clear.setFont(new Font("Tahoma", Font.BOLD, 20));
    	clear.setBounds(203,80,47,47);
    	this.getContentPane().add(clear);
    	
    	
    	//Second Row
    	button4.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button4.setBounds(3,130,47,47);
    	this.getContentPane().add(button4);
    	
    	button5.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button5.setBounds(53,130,47,47);
    	this.getContentPane().add(button5);
    	
    	button6.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button6.setBounds(103,130,47,47);
    	this.getContentPane().add(button6);
    	
    	multiply.setFont(new Font("Tahoma", Font.BOLD, 20));
    	multiply.setBounds(153,130,47,47);
    	this.getContentPane().add(multiply);
    	
    	dummy1.setBounds(203,130,47,47);
    	this.getContentPane().add(dummy1);
    	
    	// Third Row 
    	button1.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button1.setBounds(3,180,47,47);
    	this.getContentPane().add(button1);
    	
    	button2.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button2.setBounds(53,180,47,47);
    	this.getContentPane().add(button2);
    	
    	button3.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button3.setBounds(103,180,47,47);
    	this.getContentPane().add(button3);
    	
    	subtract.setFont(new Font("Tahoma", Font.BOLD, 20));
    	subtract.setBounds(153,180,47,47);
    	this.getContentPane().add(subtract);
    	
    	dummy2.setBounds(203,180,47,47);
    	this.getContentPane().add(dummy2);
    	
    	// Fourth Row 
    	dummy3.setBounds(3,230,47,47);
    	this.getContentPane().add(dummy3);
    	
    	button0.setFont(new Font("Tahoma", Font.BOLD, 20));
    	button0.setBounds(53,230,47,47);
    	this.getContentPane().add(button0);
    	
    	dummy4.setBounds(103,230,47,47);
    	this.getContentPane().add(dummy4);
    	
    	add.setFont(new Font("Tahoma", Font.BOLD, 20));
    	add.setBounds(153,230,47,47);
    	this.getContentPane().add(add);
    	
     	equals.setFont(new Font("Tahoma", Font.BOLD, 20));
    	equals.setBounds(203,230,47,47);
    	this.getContentPane().add(equals);
    	
    	
    }
    
	// --------------------------------------------------------------------

    /**
     * Attaches listeners to the frames buttons.
     */ 
    private void registerListeners() {
    	// Number Buttons 
    	this.button7.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button7.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button8.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button8.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button9.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button9.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button4.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button5.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button5.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button6.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button6.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});

    	
    	
    	this.button1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button1.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	
    	this.button2.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button2.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.button3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button3.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	
    	this.button0.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			String EnterNumber = input.getText() + button0.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	
    	// Clear
    	
    	this.clear.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			input.setText(null);
    			output.setText(null);
    			
    		}
    		
    		
    		
    	});
    	
    	// Operators 
    	
    	this.add.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			
    			try {
    				firstnum = Double.parseDouble(input.getText());
        			operation = "+";
    			} catch (NumberFormatException nfe) {
    				firstnum = -1;
    			}
    			    			
    			String EnterNumber = input.getText() + add.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.subtract.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			try {
    				firstnum = Double.parseDouble(input.getText());
        			operation = "-";
    			} catch (NumberFormatException nfe) {
    				firstnum = -1;

    			}
    			String EnterNumber = input.getText() + subtract.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	this.multiply.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			try {
    				firstnum = Double.parseDouble(input.getText());
        			operation = "*";
    			} catch (NumberFormatException nfe) {
    				firstnum = -1;

    			}
    			
    			String EnterNumber = input.getText() + multiply.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	
    	this.divide.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {

    			try {
    				firstnum = Double.parseDouble(input.getText());
        			operation = "/";
    			} catch (NumberFormatException nfe) {
    				firstnum = -1;
    			}
    			String EnterNumber = input.getText() + divide.getText();
    			input.setText(EnterNumber);
    			
    		}
    		
    		
    		
    	});
    	
    	
    	
    	//Equals
    	
    	this.equals.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			int i; 
    			int index = 0;
    			
    			String text = input.getText();
    			int textLength = text.length();
    			String second = "";
    					
    			
    			for (i = 0; i < textLength; i++) {
    				if (text.charAt(i) == '+' || text.charAt(i) == '-' || text.charAt(i) == '*' || text.charAt(i) == '/') {
    					index = i;	
    					break;			
    				}		
    							
    			}
    			
    			
    			
    			for (i = index + 1; i < textLength; i++) {
    				second += text.charAt(i);
    				
    			}
    			
    			try {
    				
    				if (firstnum != -1) {
    					
    					secondnum = Double.parseDouble(second);	
            			if (operation == "+") {
            				result = firstnum + secondnum;
            				answer = String.format("%.2f", result);
            				output.setText(answer);
            				
            				
            			}
            			
            			else if (operation == "-") {
            				result = firstnum - secondnum;
            				answer = String.format("%.2f", result);
            				output.setText(answer);
            				
            				
            			}
            			
            			else if (operation == "*") {
            				result = firstnum * secondnum;
            				answer = String.format("%.2f", result);
            				output.setText(answer);
            				
            				
            			}
            			
            			else if (operation == "/") {	
            				result = firstnum / secondnum;
            				answer = String.format("%f", result);
            				output.setText(answer);
            				
            			}
          
    					
    					
    					
    					
    				}
    				
        				
    			} catch (NumberFormatException nfe) {
    				output.setText(null);
    			}
    					
    			
    					
    		}
    		
    		   		
    	});
    	
    	 	
    	
    	
    }



}
