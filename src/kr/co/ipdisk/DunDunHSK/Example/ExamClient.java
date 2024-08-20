package kr.co.ipdisk.DunDunHSK.Example;

import java.io.DataInputStream;
import java.net.Socket;

public class ExamClient {
	public static void main(String[] args) {
		Socket socket;
		String defaultIP = "127.0.0.1";
		String clientIP = "10.13.117.58";
		int portNumber = 7000;

		try {
			socket = new Socket(clientIP,portNumber);
			// 서버에서 들어오는 데이터를 받기위한 스트림
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			// 받은 데이터를 담을 변수
			String getData = dataInputStream.readUTF();
			System.out.println(getData);
			// 스트림 세션 종료
			dataInputStream.close();
			// 소켓 연결 세션 종료
			socket.close();

		}catch (Exception exception){
			System.out.println(exception);
		}
	}
}
