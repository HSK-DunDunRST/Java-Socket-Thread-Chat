package kr.co.ipdisk.DunDunHSK.Example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ExamTextEvent extends JFrame implements ActionListener, TextListener {

    // 전역변수 (속성 생성)
    Button button; // 버튼 생성
    TextField textField; // 텍스트 입력 상자
    TextArea textArea;  // 다중라인 입력가능한 입력상자

    // 생성자 (클래스명과 동일하게 선언)
    public ExamTextEvent(){
        super("TextEvent Example");
        setLayout(new BorderLayout());

        button = new Button("전송하기");
        textField = new TextField(30);
        textArea = new TextArea(50,100);

        button.setEnabled(false);
        button.addActionListener(this);
        textField.addTextListener(this);

        Panel topPannel = new Panel();
        topPannel.add(textField);
        topPannel.add(button);
        add("North",topPannel);

        Panel bottomPannel = new Panel();
        bottomPannel.add(textArea);
        add("Center",bottomPannel);

        setSize(720,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Button 이벤트 관련 메서드 (오버라이드)
    @Override
    public void actionPerformed(ActionEvent e) {
        String getEventID = e.getActionCommand();
        if(getEventID.equals("전송하기")){  // 전송하기 버튼이 클릭되었다면 (TextField에서 엔터도 동일)
            textArea.append(textField.getText() + "\n"); // TextField내용 가져와 출력후 엔터
            textField.setText("");  // TextField 내용 초기화
            textField.requestFocus();
        }

    }
    // Text 이벤트 관련 메서드 (오버라이드)
    @Override
    public void textValueChanged(TextEvent e) {
        // 입력할 내용이 없을 경우 버튼 비활성화
        if(textField.getText().equals(""))
            button.setEnabled(false);
        else
            button.setEnabled(true);

    }

    public static void main(String[] args) {
        ExamTextEvent obj = new ExamTextEvent();
    }
}
