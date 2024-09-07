import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel info;
    JButton[] numButton;
    JButton[] opButton;
    JTextField textField;

    JButton delButton;
    JButton addButton;
    JButton subButton;
    JButton mulButton;
    JButton divButton;
    JButton dotButton;
    JButton eqButton;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {

        Font myFont = new Font("Arial", Font.BOLD, 33);

        frame = new JFrame("Calculator");
        frame.setBounds(500, 220, 500, 620);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);

        numButton = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(myFont);
            numButton[i].setBackground(Color.black);
            numButton[i].setFocusable(false);
            numButton[i].setForeground(Color.white);
        }

        opButton = new JButton[7];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("del");

        opButton[0] = addButton;
        opButton[1] = subButton;
        opButton[2] = mulButton;
        opButton[3] = divButton;
        opButton[4] = dotButton;
        opButton[5] = eqButton;
        opButton[6] = delButton;

        for (int i = 0; i < opButton.length; i++) {
            opButton[i].addActionListener(this);
            opButton[i].setFont(myFont);
            opButton[i].setBackground(Color.orange);
            opButton[i].setFocusable(false);
            opButton[i].setForeground(Color.white);
        }

        panel = new JPanel();
        panel.setBounds(0, 100, 500, frame.getHeight() - 150);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(0, 0, panel.getWidth(), 80);
        textField.setFont(myFont);
        textField.setFocusable(false);

        frame.add(textField);

        panel.add(numButton[7]);
        panel.add(numButton[8]);
        panel.add(numButton[9]);
        panel.add(opButton[6]);
        panel.add(numButton[4]);
        panel.add(numButton[5]);
        panel.add(numButton[6]);
        panel.add(opButton[0]);
        panel.add(numButton[1]);
        panel.add(numButton[2]);
        panel.add(numButton[3]);
        panel.add(opButton[1]);
        panel.add(opButton[4]);
        panel.add(numButton[0]);
        panel.add(opButton[5]);
        panel.add(opButton[2]);

        info = new JLabel(
                "<html><center>Calculator: Version 22H2 (OS Build: 19045.2386) <br> © Microsoft Corporation, All rights reserved.  This Product is liscensed under the Microsoft Software Liscence Terms to: <br>      Rahim   </center></html>");
        info.setBounds(0, 460, 500, 120);

        frame.add(info);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < numButton.length; i++) {
            if (e.getSource() == numButton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '/':
                    result = num1 / num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                default:
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == delButton) {
            String temp = textField.getText();
            textField.setText("");
            for (int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }
}
