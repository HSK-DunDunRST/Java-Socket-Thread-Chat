package kr.co.ipdisk.DunDunHSK.JavaChat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.*;
import java.util.Vector;

public class ChatServer extends JFrame {
    // 서버 소캣 객체
    ServerSocket serverSocket;
    // JSwing(JFrame) ELement 객체
    Container container;
    Vector vector;
    JTextArea viewLog;
    JTextField inputCommand;

    //--------------------------- DataBase Elements ----------------------------
    // 사용자 정보
    UserData userData;
    // Database 접근 객체
    Connection connection;
    // 쿼리 실행 객체
    PreparedStatement preparedStatement;
    // 쿼리 실행후 결과 번환 데이터 저장용 객체
    ResultSet resultSet;
    // 서버 포트번호
    private final int serverPort = 9999;
    // mariaDB 서버 주소
    private final String databaseUrl ="jdbc:mariadb://10.12.9.4:3307";
    // 접근할 데이터베이스명
    private final String databaseName = "java_chat";
    // 접근할 로그인 id
    private final String databaseUser = "StudyHSK";
    // 접근할 로그인 password
    private final String databasePassword = "HSK6265!";

    // 생성자 (클래스명과 동일, 반환값이 없다.)
    public ChatServer(String envTitle){
        // 부모클래스의 생성자 호출, 반드시 첫 라인에 작성
        super(envTitle);
        // 화면 출력을 위한 영역 객체 선언
        container = this.getContentPane();
        // 화면 레이아웃 지정
        container.setLayout(new BorderLayout());
        viewLog = new JTextArea();
        inputCommand = new JTextField(30);
        viewLog.setBackground(Color.white);
        container.add("Center", viewLog);
        container.add("South",inputCommand);

        // 창크기
        setSize(720,480);
        // 창 표시 활성화 여부
        setVisible(true);
        // 창 닫기 버튼 활성화
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Vector 생성 -> 스레드를 저장할 수 있는 컬렉션
        vector = new Vector();

        // 네트워크 예외 처리
        try {
            // MariaDB 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");
            // 커넥션 객체 생성
            connection = DriverManager.getConnection(databaseUrl + "/" + databaseName, databaseUser, databasePassword);
            // 포트 번호와 스레드를 사용하여 서버 구축
            serverSocket = new ServerSocket(serverPort);
            while (true){
                // 외부로부터 접속할 경우 소켓 생성 (무한대기)
                Socket socket = serverSocket.accept();
                String clientIP = socket.getInetAddress().toString();
                viewLog.append("Connected Client IP : " + clientIP + "\n");
                System.out.println("Connected Client IP : " + clientIP);
                // 에이전트 생성
                ChatThread chatClient = new ChatThread(this, socket);
                // 스레드의 시작을 운영체제나 하드웨어에게 알림.
                chatClient.start();
                // 백터에 스레드를 저장.
                vector.addElement(chatClient);
            }
        } catch (SocketException socketException) {
            System.out.println(socketException);
        } catch (IOException ioException){
            System.out.println(ioException);
        } catch (SQLException sqlException){
            System.out.println(sqlException);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException runtimeException){
            System.out.println("비정상적으로 연결 종료되었습니다.");
        }
    }

    // 특정 스레드로부터 일괄전송 위한 문자열 수신
    public void sendAll(Socket envSocket , String envMessage){
        String clientIP = String.valueOf(envSocket.getInetAddress());
        // 접속 스레드의 수 만큼 반복하면서 메시지를 전송
        viewLog.append("Client [ " + clientIP + " ] >> " + envMessage + "\n");

        try {
            // 메시지를 데이터베이스에 삽입하는 SQL 쿼리문
            String sendQuery = "INSERT INTO data_chat (usr_ip, chat_content) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sendQuery);
            // insertQuery문에 들어갈 매개변수 ?에 들어갈 값 지정 (? 순서번호, 매겨변수 내용)
            preparedStatement.setString(1,clientIP);
            preparedStatement.setString(2,envMessage);
            // Statement 쿼리 실행
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException sqlException){
//            System.out.println(sqlException);
            sqlException.printStackTrace();
        }

        for(int index = 0; index < vector.size(); index++){
            // ChatThread 타입으로 캐스팅됨.
            ChatThread chatClient = (ChatThread) vector.get(index);
            // 각 클라이언트에게 메시지 전송
            chatClient.sendMessage(clientIP,envMessage);
        }
    }
    // 로그인 처리 매서드
    public boolean loginService(String envUserId, String envUserPw){
        boolean isLogin = false;
        try{
            String loginQuery = "SELECT * FROM data_user WHERE usr_id = ? and usr_pwd = ?";
            preparedStatement = connection.prepareStatement(loginQuery);
            // loginQuery에 있는 ?(매개변수)에 할당합니다.
            preparedStatement.setString(1,envUserId);
            preparedStatement.setString(2,envUserPw);
            // 반환된 데이터 레코드 형식으로 반환합니다.
            resultSet = preparedStatement.executeQuery();
            // 로그인 성공시 userData 저장
            if(resultSet.next()){
                viewLog.append("[Login Successful!] >> " + envUserId + " 님 환영합니다!\n");
                userData = new UserData();
                userData.setUserId(resultSet.getString("usr_id"));
                userData.setUserPwd(resultSet.getString("usr_pwd"));
                userData.setUserName(resultSet.getString("usr_name"));
                userData.setUserNickname(resultSet.getString("usr_nickname"));
                userData.setUserEmail(resultSet.getString("usr_email"));
                isLogin = true;
            }else{
                viewLog.append("[Login Fault..] >> 로그인 실패\n");
            }
            resultSet.close();
            preparedStatement.close();
        }catch(Exception exception){
//            System.out.println(exception);
            exception.printStackTrace();
        }
        return isLogin;
    }

    public static void main(String[] args) {
         ChatServer chatServer = new ChatServer("Chat Server Testing...");

    }
}
