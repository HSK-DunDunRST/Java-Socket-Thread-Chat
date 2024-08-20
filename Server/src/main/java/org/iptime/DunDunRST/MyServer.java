package org.iptime.DunDunRST;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class MyServer extends Thread {

    // 소켓 서버를 열 때, 포트 번호
    private int port;
    private boolean started;
    private List<ClientInfo> clients; // null

    private ServerSocket serverSocket;
    public MyServer(int port) {
        this.port = port;
        clients = new ArrayList<>();
    }

    // Thread -> start() 실행 -> 자동으로 run() 이라는 메서드를 찾아 실행
    //  Thread 의 main()
    @Override
    public void run() {
        runServer();
    }

    public boolean isStarted() {
        return started;
    }

    public void disconnect(ClientInfo client) {

    }

    // 클라이언트한테 보내는 Data ( int (1), UTF (2) )
    public void sendMessage(ClientInfo client, String message) {
        new Thread(()->
                clients.forEach((i)-> i.sendMessage(client, message)))
                .start();
    }

    private void runServer() {
        // ServerSocket 을 열 때, IOException 이 발생할 수 있다.
        try {
            serverSocket = new ServerSocket(port);
            started = true;
            System.out.println("서버가 시작되었습니다.");
            while(started) {
                ClientInfo client = new ClientInfo(serverSocket.accept(), this);
                clients.add(client);
                client.start();
                System.out.println(client.getClientId() + " 번 클라이언트가 접속하였습니다.");
            }
            serverSocket.close();
        } catch (IOException e) {
            started = false;
        }
        System.out.println("서버가 종료되었습니다.");
    }

    public void stopServer() {
        started = false;
        if(serverSocket != null && !serverSocket.isClosed())
            try { serverSocket.close(); } catch (IOException ignored) {}
    }

}
