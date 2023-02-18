/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 *
 * @author wajah
 */
public class Calculator implements ActionListener {
    // Defining variables
    JFrame frame;
    JPanel panel;
    JTextField textfield;
    JLabel message;
    
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[10];
    
    JButton addButton, subButton, mulButton, divButton, percButton;
    JButton delButton, equButton, clrButton, decButton, negButton;
    
    Font myFont = new Font("", Font.PLAIN, 40);
    Font myFontBtns = new Font("", Font.PLAIN, 30);
    
    double num1 = 0, num2 = 0, result = 0;
    char op;
    
    // Constructor
    Calculator() {
        // Setting frame values
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,600);
        frame.setLayout(null);
        frame.setResizable(false);
        
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
        
        // Adding message
        message = new JLabel("");
        message.setForeground(Color.RED);
        message.setBounds(50, 7, 400, 20);
        frame.getContentPane().add(message);
        
        // Adding to frame
        frame.add(panel);
        frame.add(textfield);
        frame.add(message);
        frame.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        
        Calculator calc = new Calculator();
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Rounding to 8 decimals MAX
        DecimalFormat df = new DecimalFormat("#.########");
        
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
            num1 = 0;
            num2 = 0;
        }
        // Add button
        if(e.getSource() == addButton && !textfield.getText().isEmpty())
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '+';
            textfield.setText("");
        }
        // Subtract button
        if(e.getSource() == subButton && !textfield.getText().isEmpty())
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '-';
            textfield.setText("");
        }
        // Multiply button
        if(e.getSource() == mulButton && !textfield.getText().isEmpty())
        {
            num1 = Double.parseDouble(textfield.getText());
            op = 'x';
            textfield.setText("");
        }
        // Divide button
        if(e.getSource() == divButton && !textfield.getText().isEmpty())
        {
            num1 = Double.parseDouble(textfield.getText());
            op = '/';
            textfield.setText("");
        }
        // Equals button
        if(e.getSource() == equButton)
        {
            if (textfield.getText().isEmpty() || textfield.getText().contains(".")){
                
            }
            else {
                num2 = Double.parseDouble(textfield.getText());

                switch(op) {
                    case '+':
                        result = Double.parseDouble(df.format(num1 + num2));
                        break;
                    case '-':
                        result = Double.parseDouble(df.format(num1 - num2));
                        break;
                    case 'x':
                        result = Double.parseDouble(df.format(num1 * num2));
                        break;
                    case '/':
                        // If divided by Zero
                        if(num2 == 0) {
                            //JOptionPane.showMessageDialog(null, "Error: Cannot divide by Zero");
                            setMessageWithDelay("Cannot divide by Zero",message);
                            setMessageWithDelay("ERROR",textfield);
                            return;
                        } else {
                            result = Double.parseDouble(df.format(num1 / num2));
                            break;
                        }
                    default:
                        setMessageWithDelay("Please enter a second value",message);
                        return;
                }
                
                textfield.setText(String.valueOf(result));
                num1 = result;
            }
        }      
        
        // Delete Button
        if(e.getSource() == delButton && !textfield.getText().isEmpty())
        {
            StringBuilder sb = new StringBuilder(textfield.getText());
            sb.deleteCharAt(sb.length()-1);
            textfield.setText(sb.toString());
        }
        // Negative Button
        if(e.getSource() == negButton && !textfield.getText().isEmpty())
        {
            double num = Double.parseDouble(textfield.getText())*-1;
            textfield.setText(String.valueOf(num));
        }
        // Percentage Button
        if(e.getSource() == percButton && !textfield.getText().isEmpty())
        {
            double num = Double.parseDouble(textfield.getText())/100;
            textfield.setText(String.valueOf(num));
        }
    }
    
    public void setMessageWithDelay(String text, JLabel label){
        label.setText(text);

        int delay = 2000; // 2 seconds

        ActionListener clear = new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
              SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   label.setText("");
                }
            });
          }
        };

        Timer timer = new Timer(delay, clear);
        timer.setRepeats(false);
        timer.start();
    }
    
    public void setMessageWithDelay(String text, JTextField field){
        field.setText(text);

        int delay = 2000; // 2 seconds

        ActionListener clear = new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
              SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   field.setText("");
                }
            });
          }
        };

        Timer timer = new Timer(delay, clear);
        timer.setRepeats(false);
        timer.start();
    }
}
