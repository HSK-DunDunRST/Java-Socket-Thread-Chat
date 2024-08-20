package org.iptime.DunDunRST;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {

    private final Socket socket;
    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            while(!socket.isClosed()) {
                System.out.print("메세지 입력 : ");
                output.writeUTF(scanner.nextLine());
                output.flush();
            }
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

}
