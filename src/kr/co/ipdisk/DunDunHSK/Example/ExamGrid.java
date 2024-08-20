package kr.co.ipdisk.DunDunHSK.Example;

import javax.swing.*;
import java.awt.*;

public class ExamGrid extends JFrame {
    public ExamGrid(){  // 생성자
        super("Grid Example"); // 부모클래스(JFrame)에 생성자 호출
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2,4)); // 2행 4열 그리드
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");

        cp.add(btn1);
        cp.add(btn2);
        cp.add(btn3);
        cp.add(btn4);
        cp.add(btn5);
        cp.add(btn6);
        cp.add(btn7);
        cp.add(btn8);

        setSize(720,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ExamGrid obj = new ExamGrid();
    }
}
