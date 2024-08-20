package org.iptime.DunDunRST;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientInfo extends Thread {

    private static int lastId = 1; // 21478...

    // id - 클라이언트의 고유 번호
    private final int id;
    private final Socket socket;
    private final MyServer server;
    private DataOutputStream output;
    public ClientInfo(Socket socket, MyServer server) {
        id = lastId++;
        this.socket = socket;
        this.server = server;
    }

    public int getClientId() { return id; }
    public Socket getSocket() { return socket; }

    @Override
    public void run() {
        // client 와 연결이 종료되면 Exception
        try(DataInputStream input = new DataInputStream(socket.getInputStream())) {
            while(!socket.isClosed()) {
                server.sendMessage(this, input.readUTF());
            }
        } catch (IOException ignored) {}
        // client 가 끝났을 때, (접속이 종료됐을 때)
        server.disconnect(this);
        try { output.close(); } catch (Exception ignored) {}
    }

    public void sendMessage(ClientInfo sender, String message) {
        if(output == null) try {
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ignored) {}

        try {
            // 내 메세지인 경우 -1 전송
            output.writeInt(sender == this ? -1 : sender.getClientId());
            output.writeUTF(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
