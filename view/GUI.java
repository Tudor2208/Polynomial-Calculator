package ro.utcn.tudor.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final Font TITLE_FONT = new Font("Comic Sans MS", Font.BOLD, 25);
    private static final Color TITLE_COLOR = new Color(42, 40, 39);

    private static final Font TEXT_FONT = new Font("Times New Roman", Font.PLAIN, 19);
    private static final Color TEXT_COLOR = new Color(28, 27, 26);

    JPanel mainPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel textPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    JLabel lblTitle = new JLabel("Polynomial Calculator");
    JLabel lblFirst = new JLabel("First Polynomial = ");
    JLabel lblSecond = new JLabel("Second Polynomial = ");
    JLabel lblResult = new JLabel("Result = ");

    JTextField txtFirst = new JTextField(15);
    JTextField txtSecond = new JTextField(15);
    JTextField txtResult = new JTextField(30);

    JButton[] buttons = new JButton[8];

    public GUI(){
        super("Polynomial Calculator");
        this.setVisible(true);
        this.setSize(800, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        this.setContentPane(mainPanel);

        mainPanel.setBackground(new Color(203, 241, 228));
        titlePanel.setBackground(new Color(203, 241, 228));
        textPanel.setBackground(new Color(203, 241, 228));

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(titlePanel);
        titlePanel.add(lblTitle);
        lblTitle.setFont(TITLE_FONT);
        lblTitle.setForeground(TITLE_COLOR);

        mainPanel.add(textPanel);
        textPanel.add(lblFirst);
        textPanel.add(txtFirst);
        textPanel.add(lblSecond);
        textPanel.add(txtSecond);
        textPanel.add(Box.createVerticalStrut(80));
        textPanel.add(lblResult);
        textPanel.add(txtResult);

        txtFirst.setFont(TEXT_FONT);
        txtFirst.setForeground(TEXT_COLOR);

        txtSecond.setFont(TEXT_FONT);
        txtSecond.setForeground(TEXT_COLOR);

        txtResult.setFont(TEXT_FONT);
        txtResult.setForeground(TEXT_COLOR);
        txtResult.setEditable(false);

        lblFirst.setFont(TEXT_FONT);
        lblFirst.setForeground(TEXT_COLOR);

        lblSecond.setFont(TEXT_FONT);
        lblSecond.setForeground(TEXT_COLOR);

        lblResult.setFont(TEXT_FONT);
        lblResult.setForeground(TEXT_COLOR);

        buttonsPanel.setLayout(new GridLayout(4, 2));
        mainPanel.add(buttonsPanel);

        for(int i = 0; i < 8; i ++){
            buttons[i] = new JButton();
            buttonsPanel.add(buttons[i]);
            buttons[i].setBackground(new Color(203, 194, 116));
            buttons[i].setText("Operation Z");
            buttons[i].setFont(TEXT_FONT);
            buttons[i].setFocusable(false);
        }

        buttons[0].setText("Clear");
        buttons[0].setBackground(new Color(99, 236, 89));
        buttons[1].setText("-");
        buttons[1].setBackground(new Color(99, 236, 89));
        buttons[2].setText("Addition");
        buttons[3].setText("Subtraction");
        buttons[4].setText("Multiplication");
        buttons[5].setText("Division");
        buttons[6].setText("Derivation");
        buttons[7].setText("Integration");
    }

    public void addBtnClearAL(ActionListener al){
        buttons[0].addActionListener(al);
    }

    public void addBtnAddAL(ActionListener al){
        buttons[2].addActionListener(al);
    }

    public void addBtnSubAL(ActionListener al){
        buttons[3].addActionListener(al);
    }

    public void addBtnMulAL(ActionListener al){
        buttons[4].addActionListener(al);
    }

    public void addBtnDivAL(ActionListener al){
        buttons[5].addActionListener(al);
    }

    public void addBtnDerivAL(ActionListener al){
        buttons[6].addActionListener(al);
    }

    public void addBtnIntegrAL(ActionListener al){
        buttons[7].addActionListener(al);
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String getPolynomial1(){
        return txtFirst.getText();
    }

    public String getPolynomial2(){
        return txtSecond.getText();
    }

    public void setResult(String result) {
        txtResult.setText(result);
    }

    public void setPol1(String txt){
        txtFirst.setText(txt);
    }

    public void setPol2(String txt){
        txtSecond.setText(txt);
    }
}
