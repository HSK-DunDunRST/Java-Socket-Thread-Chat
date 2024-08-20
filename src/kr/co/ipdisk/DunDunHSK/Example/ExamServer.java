package kr.co.ipdisk.DunDunHSK.Example;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExamServer {
	public static void main(String args[]) {
		ServerSocket server;
		// TCP 포트번호 지정
		int portNumber = 7000;
		
		try { 
			// 예외처리가 필요하거나 에러가 발생할 가능성이 있는 코드
			server = new ServerSocket(portNumber);
			System.out.println("Connect wait...");
			// 연결 대기를 위해 무한루프
			while(true) {
				// 서버 대기중 클라이언트 연결시 소켓 생성
				Socket socket = server.accept();
				System.out.println("Client IP : " + socket.getInetAddress());
				// 서버에서 데이터를 클라이언트에게 전송하는 스트림
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				// 데이터스트림을 통해 UTF(문자열) 데이터 전송
				dataOutputStream.writeUTF("Connected! Send UTF");
				// 강제 전송
				dataOutputStream.flush();
				// 데이터스트림 세션 종료
				dataOutputStream.close();
				// 소켓 세션 종료
				socket.close();
			}
			
		} catch (Exception exception) {
			// TODO: handle exception
			System.out.println(exception);
		}
	}
}
