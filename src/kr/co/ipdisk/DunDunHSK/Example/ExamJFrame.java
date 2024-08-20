package kr.co.ipdisk.DunDunHSK.Example;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ExamJFrame extends JFrame {
    public ExamJFrame() {
        super("JFrame 테스트");
        
        ImageIcon icon = new ImageIcon("./image.gif");
        JButton btn1 = new JButton("버튼1");
        JButton btn2 = new JButton(icon);

        Container cp = getContentPane(); // Frame 위에 추가 생성해야된다.
        cp.add("North",btn1);
        cp.add("Center",btn2);

        setSize(500,500);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ExamJFrame obj = new ExamJFrame();
    }

}
