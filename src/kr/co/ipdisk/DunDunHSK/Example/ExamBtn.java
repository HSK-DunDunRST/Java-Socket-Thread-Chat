package kr.co.ipdisk.DunDunHSK.Example;

import java.awt.*;
// Frame 상속 필수
public class ExamBtn extends Frame {
    public ExamBtn(){
        super("Exam FrameButton");

        Panel panel = new Panel();
        Label label = new Label("Example 레이블");
        label.setBackground(Color.yellow);
        Button btn1 = new Button("Left Button"); // button 객체 생성
        Button btn2 = new Button("Right Button");  // 버튼의 라벨 표시

        add(panel);
        panel.add(label);
        panel.add(btn1);
        panel.add(btn2);

        setSize(720,480);
        setVisible(true);
    }

    public static void main(String[] args) {
        ExamBtn obj = new ExamBtn();
    }
}
