package kr.co.ipdisk.DunDunHSK.JavaChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

// Client와 직접 통신하기 위한 Thread 프로그램
public class ChatThread extends Thread{
    // 속성
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    ChatServer server;
    Socket socket;
    UserData userData;
    // 로그인 성공여부
    boolean flag;
    // 생성자 -> 최초 한번 실행되는 코드
    public ChatThread(ChatServer envServer, Socket envSocket){
        try{
            userData = new UserData();
            // this.전역변수 = 지역변수;
            this.server = envServer;
            this.socket = envSocket;
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

        }catch (Exception exception){
            System.out.println(exception);
            exception.printStackTrace();
        }
    }

    // 메소드
    public void run(){
        // 클라이언트로부터 메시지를 수신할 경우 처리
        flag = true;
        while(true){
            try {
                // Client으로부터 문자열 수신될때까지 대기 및 실행
                String data = dataInputStream.readUTF();
                // 3자리 코드 추출
                String code = data.substring(0,3);
                // Index 4이후로부터 모두 추출
                String message = data.substring(4);
                // 로그인 요청
                if(code.equals("101")){
                    // 클론을 찾아 아이디와 비밀번호 분리
                    int pos = message.indexOf(":");
                    // 클론 직전까지 위치 반환
                    String tempID = message.substring(0,pos);
                    // 클론 이후부터 위치 반환
                    String tempPwd = message.substring(pos + 1);
                    // 로그인이 되었다면? 유저 정보 저장
                    boolean isLogin = server.loginService(tempID,tempPwd);
                    // 로그인이 성공되었다면 Userdata 저장
                    if (isLogin){
                        this.userData = server.userData;
                        flag = true;
                    }
                    server.sendAll(socket, this.userData.getUserId() + "님이 참가되었습니다!");
                }else if(flag == true && code.equals("103")){
                    server.sendAll(socket, message);
                }
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        }
    }
    //메시지 전송을 위한 메서드
    public void sendMessage(String envClientIP,String envMessage){
        try {
            dataOutputStream.writeUTF("[ " + envClientIP +" ] >> "+ envMessage);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }




}
