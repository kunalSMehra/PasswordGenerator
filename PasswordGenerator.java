import javax.swing.*;  		//JFrame,JButton,JTextField,JLabel,imageicon
import javax.swing.border.Border;
import java.awt.Color;		//specify the color of the border	
import java.awt.Font;		//font styling of JLAbel and JTextFieldimport java.awt.Insets;
//import java.awt.Insets;
import java.awt.Toolkit;	//provide some of the windows inbuilt functionality
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;	//provides user interface classes
import java.util.*;			//random


public class PasswordGenerator implements ActionListener{
    JButton button1,button2;
    JTextField textfield;
	JLabel heading;
	
    void passwordGenerator(){
	    JFrame f = new JFrame("Password_Generator");
	    
	    heading = new JLabel("PASSWORD GENERATOR");
	    heading.setBounds(125, 2, 500, 40);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setForeground(new Color(30, 144, 255));

	    //image 
	    
	    button1 = new JButton("Start");
	    button1.setBounds(65,245,115,50);
	    button1.setBackground(new Color(30, 144, 255));
        button1.setForeground(Color.white);
        button1.setFont(new Font("Arial", Font.BOLD, 30));
        button1.setBorderPainted(false);
	
		textfield= new JTextField();
		textfield.setBounds(150,380,300,50);
	    Font tf=new Font("Arial",Font.ITALIC,16);
		Border border = BorderFactory.createLineBorder(Color.CYAN, 1);
		textfield.setBorder(border);
		textfield.setFont(tf);
//		textfield.setMargin(new Insets(0,20,0,0));
		textfield.setEditable(false);
	    
	    
	    button2 = new JButton("Copy");
	    button2.setBounds(405,245,115,50);
	    button2.setBackground(new Color(30, 144, 255));
        button2.setForeground(Color.white);
        button2.setFont(new Font("Arial", Font.BOLD, 30));
        button2.setBorderPainted(false);
	    
        button1.addActionListener(this);  
        button2.addActionListener(this);
	    f.add(button1);
	    f.add(textfield);
	    f.add(button2);
	    f.add(heading);
	    f.setSize(630,560);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
//    this is generating ours password
    StringBuilder generatePassword() {
	    String lowercase_letters = "abcdefghijklmnopqrstuvwxyz";
	    String uppercase_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String digits = "0123456789";
	    String special_characters = "!@#$%^&*()_-+=<>?";

	    StringBuilder password = new StringBuilder();
	    Random rand = new Random();
	    // Generate the required characters i.e. 2 uppercase, 2 lowercase, 1 digits, 1 special_charachters
	    //abs return the absolute value means if the number is negative it returns the negation of that number
        //valueOf() isto convert any data type to string
	    
	    password.append(lowercase_letters.charAt(Math.abs(rand.nextInt()) % lowercase_letters.length()));
	    password.append(uppercase_letters.charAt(Math.abs(rand.nextInt()) % uppercase_letters.length()));
	    password.append(uppercase_letters.charAt(Math.abs(rand.nextInt()) % uppercase_letters.length()));
	    password.append(lowercase_letters.charAt(Math.abs(rand.nextInt()) % lowercase_letters.length()));
	    password.append(lowercase_letters.charAt(Math.abs(rand.nextInt()) % lowercase_letters.length()));
	    password.append(digits.charAt(Math.abs(rand.nextInt()) % digits.length()));
	    password.append(special_characters.charAt(Math.abs(rand.nextInt()) % special_characters.length()));

	    // Generate the remaining characters
	    // bcoz 7 character has already been generated and now we have to generated remaining character
	    int remaining_length = Math.abs(rand.nextInt())% 20 + 6;
	    
	    
	    while (password.length() < 12) {
	        password.append(lowercase_letters.charAt(Math.abs(rand.nextInt()) % lowercase_letters.length()));
	        remaining_length--;       //we are decreasing remaining length as we have generated 12 digit password succesfully and on the next loop we are adding more random character in the password      
	    }
	    
	    
	    while (remaining_length > 0 && password.length() < 32) {
	        String all_characters = lowercase_letters + uppercase_letters + digits + special_characters;
	        password.append(all_characters.charAt(Math.abs(rand.nextInt()) % all_characters.length()));
	        remaining_length--;
	    }

	    // Shuffle the password to randomize the character positions
//	    Collections.shuffle(password);

	    String s = String.valueOf(lowercase_letters.charAt(Math.abs(rand.nextInt()) % lowercase_letters.length()));
	    password.replace(0,1,s);
	    String e = String.valueOf(uppercase_letters.charAt(Math.abs(rand.nextInt()) % uppercase_letters.length()));
	    password.replace(password.length()-1,password.length(),e);
	    
	    return password;
	}
    
    
//  when we click into start button it comes to this function  
    public void actionPerformed(ActionEvent e) {  
		StringBuilder str = new StringBuilder();
    	if(e.getSource()==button1){  
//        	while(str.length()<12 || str.length()>32)
//        	{
        		str = generatePassword();
//        	}
        	textfield.setText(str.toString());
        }
    	else if(e.getSource()==button2)
    	{
    		StringSelection stringSelection = new StringSelection (textfield.getText());
    		Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
    		clpbrd.setContents (stringSelection, null);
    	}
    }   
    
    
    public static void main(String []args) {
		// TODO Auto-generated method stub
    	PasswordGenerator p =new PasswordGenerator();
    	p.passwordGenerator();    	    	
    }
}

//aNCoy8+upxfkP8G_?*SY%X8S=U
