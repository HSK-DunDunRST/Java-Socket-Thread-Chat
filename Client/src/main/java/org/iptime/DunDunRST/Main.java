package org.iptime.DunDunRST;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 25252); // Server IP와 PortNumber는 직접 설정하셔야됩니다.
        System.out.println("서버와 연결되었습니다.");
        ReadThread th1 = new ReadThread(socket);
        WriteThread th2 = new WriteThread(socket);
        th1.start();
        th2.start();
    }

}
