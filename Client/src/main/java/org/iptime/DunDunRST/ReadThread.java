package org.iptime.DunDunRST;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread {

    // 연결 된 소켓
    private final Socket socket;
    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream input = new DataInputStream(socket.getInputStream())) {
            while(!socket.isClosed()) {
                int id = input.readInt();
                String msg = input.readUTF();
                if(id == -1) continue;
                else System.out.print("\r"+id + "님의 메세지 : " + msg +"\n메세지 입력 : ");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
