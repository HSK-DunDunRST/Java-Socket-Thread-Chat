package kr.co.ipdisk.DunDunHSK.JavaChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClient extends JFrame implements Runnable{
    // ------- Chat Layout Elements ------------
    JPanel chatPanel;
    JTextArea viewMessage;
    JTextField writeMessage;
    JButton btnSent;
    // ------- Login Layout Elements ---------
    JPanel loginPanel;
    JPanel idPanel;
    JPanel pwPanel;
    JPanel btnPanel;
    JTextField idField;
    JTextField pwField;
    JButton btnLogin;
    JButton btnCrate;
    // --------- Room Layout Elements -----------
    JButton btnJoinRoom;
    DataInputStream dataInputStream; //메시지 수신용 객체
    DataOutputStream dataOutputStream;
    // --------- Socket Server Elements ---------
    Socket socket; //서버에 접속하기 위한 소켓
    private final String localIP = "127.0.0.1";
    private final String ipAddress = "10.13.228.131";
    private final int portNumber = 9999;

    public ChatClient(String envTitle) {
        super(envTitle);
        Container container = getContentPane();

        // ------------ Chat Layout Elements ----------------
        chatPanel = new JPanel();
        writeMessage = new JTextField(30);
        viewMessage = new JTextArea();
        btnSent = new JButton("전송");

        // ----------- Login Layout Elements ------------
        loginPanel = new JPanel();
        idField = new JTextField(30);
        pwField = new JTextField(30);
        btnLogin = new JButton("로그인");
        btnCrate = new JButton("방 생성");

        idPanel = new JPanel();
        pwPanel = new JPanel();
        btnPanel = new JPanel();

        // Nested layout for loginPanel to center components vertically
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        // Add components to loginPanel
        idPanel.add(idField);
        pwPanel.add(pwField);
        btnPanel.add(btnLogin);
        btnPanel.add(btnCrate);
        loginPanel.add(idPanel);
        loginPanel.add(pwPanel);
        loginPanel.add(btnPanel);

        // Set up the rest of the chat GUI
        chatPanel.add(writeMessage);
        chatPanel.add(btnSent);

        container.add("North", loginPanel);
        container.add("South", chatPanel);
        container.add("Center", new JScrollPane(viewMessage));  // Added JScrollPane for viewMessage

        btnLogin.addActionListener(new loginBtnHandler());
        btnCrate.addActionListener(new createRoomBtnHandler());
        writeMessage.addActionListener(new textFieldHandler());
        btnSent.addActionListener(new sentBtnHandler());

        setSize(720, 480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 채팅입력후 엔터시 전송
    class textFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // 사용자가 입력한 문자열
            String message = writeMessage.getText();
            sendMessage("103:" + message);
            writeMessage.setText("");
        }
    }
    // 전송버튼 이벤트 핸들러
    class sentBtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String getElementID = e.getActionCommand();
            if(getElementID.equals("전송")){
                // 사용자가 입력한 문자열
                String message = writeMessage.getText();
                sendMessage(message);
                writeMessage.setText("");
            }
        }
    }
    // 로그인버튼 이벤트 핸들러
    class loginBtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "101:" + idField.getText() + ":" + pwField.getText();
            sendMessage(message);
            idField.setText("");
            pwField.setText("");
        }
    }
    // 방 생성버튼 이벤트 핸들러
    class createRoomBtnHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ChatRoom chatRoom = new ChatRoom("팝업창에 채팅방 이름 정하는거 만들기.");
            JDialog jDialog = new JDialog(chatRoom, "New", Dialog.ModalityType.MODELESS);
        }
    }

    public void sendMessage(String envMessage){
        try{
            dataOutputStream.writeUTF(envMessage);
        }catch (Exception exception){
//            exception.printStackTrace();
            System.out.println(exception);
        }
    }

    @Override
    public void run() {//Runnable 인터페이스 구현시 반드시 run() 메서드 작성해야 함
        try {
            socket = new Socket(localIP, portNumber);//서버에 접속
            dataInputStream = new DataInputStream(socket.getInputStream()); //수신용 객체 생성
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while(true)
            {
                String data = dataInputStream.readUTF();
                viewMessage.append(data + "\n");
            }
        } catch(ConnectException connectException){
            System.out.println("서버와 연결에 실패하였습니다." + '[' + connectException + ']');
//            exception.printStackTrace();
        } catch (IOException ioException){
            System.out.println(ioException);
        }
    }


    public static void main(String[] args){
        ChatClient client = new ChatClient("Java Chat - Client");
        Thread thread = new Thread(client);
        thread.start();
    }

}
