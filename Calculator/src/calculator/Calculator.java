/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author wajah
 */
public class Calculator implements ActionListener {
    // Defining variables
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, percButton;
    JButton delButton, equButton, clrButton, decButton, negButton;
    JPanel panel;
    Font myFont = new Font("", Font.PLAIN, 40);
    Font myFontBtns = new Font("", Font.PLAIN, 30);
    
    double num1 = 0, num2 = 0, result = 0;
    char op;
    
    Calculator() {
        // Setting frame values
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);
        
        // Setting textfield values
        textfield = new JTextField();
        textfield.setBounds(42,30, 350, 80);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.GREEN);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        // Function buttons
        addButton = new JButton("+"); 
        subButton = new JButton("-"); 
        mulButton = new JButton("x"); 
        divButton = new JButton("/"); 
        delButton = new JButton("<<"); 
        equButton = new JButton("=");
        clrButton = new JButton("AC"); 
        decButton = new JButton("."); 
        negButton = new JButton("(-)"); 
        percButton = new JButton("%");
        
        // Adding all function btns to array
        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = delButton;
        funcButtons[5] = equButton;
        funcButtons[6] = clrButton;
        funcButtons[7] = decButton;
        funcButtons[8] = negButton;
        funcButtons[9] = percButton;
        
        for(int i=0; i<funcButtons.length; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFontBtns);
            funcButtons[i].setFocusable(false);
        }
        
        for(int i=0; i<10; i++) {
            numButtons[i] = new JButton(Integer.toString(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFontBtns);
            numButtons[i].setFocusable(false);
        }
        
        panel = new JPanel();
        panel.setBounds(43,130,350,400);
        panel.setLayout(new GridLayout(5,4,8,8));
        //panel.setBackground(Color.BLACK);
        
        // Adding to Panel
        // Row 1
        panel.add(funcButtons[6]);
        panel.add(funcButtons[8]);
        panel.add(funcButtons[9]);
        panel.add(funcButtons[3]);
        // Row 2
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(funcButtons[2]);
        // Row 3
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(funcButtons[1]);
        // Row 4
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(funcButtons[0]);
        // Row 5
        panel.add(funcButtons[7]);
        panel.add(numButtons[0]);
        panel.add(funcButtons[4]);
        panel.add(funcButtons[5]);
        
        
        // Adding to frame
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0; i<10; i++)
        {
            // Getting number buttons
            if(e.getSource() == numButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        // Decimal button
        if(e.getSource() == decButton)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        // Clear button
        if(e.getSource() == clrButton)
        {
            textfield.setText("");
        }
        // Add button
        if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '+';
            textfield.setText("");
        }
        // Subtract button
        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '-';
            textfield.setText("");
        }
        // Multiply button
        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            op = 'x';
            textfield.setText("");
        }
        // Divide button
        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '/';
            textfield.setText("");
        }
        // Equals button
        if(e.getSource() == equButton)
        {
            num2 = Double.parseDouble(textfield.getText());
            
            switch(op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case 'x':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        // Delete Button
        if(e.getSource() == delButton)
        {
            StringBuffer sb = new StringBuffer(textfield.getText());
            sb.deleteCharAt(sb.length()-1);
            textfield.setText(sb.toString());
        }
        // Negative Button
        if(e.getSource() == negButton)
        {
            double num = Double.parseDouble(textfield.getText())*-1;
            textfield.setText(String.valueOf(num));
        }
        // Percentage Button
        if(e.getSource() == percButton)
        {
            double num = Double.parseDouble(textfield.getText())/100;
            textfield.setText(String.valueOf(num));
        }
    }
    
}
