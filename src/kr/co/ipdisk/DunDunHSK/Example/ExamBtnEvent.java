package kr.co.ipdisk.DunDunHSK.Example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// ActionListener는 구현하는 Interface이다.
public class ExamBtnEvent extends JFrame implements ActionListener {

    JButton jButton;    // 속성 (=전역변수)
    // Interface 구현시 필요한 메서드를 반드시 포함.

    public ExamBtnEvent(){  // 생성자, JFrame
        super("Button Event Example");

        jButton = new JButton("버튼");
        add(jButton);  // JFrame에 버튼이 추가됨.
        jButton.addActionListener(this);    // 이벤트 핸들러 버튼에 추가하기.

        setSize(720,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String elementName = e.getActionCommand();  // 어떤 컴포넌트가 호출되었는가?에 대해 알수있음
        if(elementName.equals("버튼")){
            System.out.println("Button is Clicked!");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-Generated Method stub
        ExamBtnEvent obj = new ExamBtnEvent();
    }
}
