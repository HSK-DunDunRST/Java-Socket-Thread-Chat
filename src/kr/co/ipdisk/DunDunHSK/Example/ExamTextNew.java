package kr.co.ipdisk.DunDunHSK.Example;

/*
   텍스트 상자에 입력 후 엔터키 누르면 다중입력상자에 출력
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class ExamTextNew extends JFrame implements ActionListener, EventListener {

    JTextField textField;
    JTextArea textArea;

    public ExamTextNew(){
        super("TextNew Example");
        setLayout(new GridLayout(1,2));
        textField = new JTextField(30);
        textArea = new JTextArea(30,30);

        JPanel leftPanel = new JPanel();
        leftPanel.add(textField);
        add("Left",leftPanel);
        textField.addActionListener(this);

        JPanel rightPanel = new JPanel();
        rightPanel.add(textArea);
        add("Right",rightPanel);

        setSize(720,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        ExamTextNew obj = new ExamTextNew();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            textArea.append(textField.getText().toString() + "\n");
            textField.setText("");

    }


}
