package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	Socket socket;
	
	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	//클라이언트로부터 메시지를 전달받는 메소드입니다.
	public void receive() {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				while(true) { // 반복적으로 클라이언트들의 채팅을 받는다.
					InputStream in = socket.getInputStream();
					byte[] buffer = new byte[512];
					
						int length = in.read(buffer);
						while(length == -1) throw new IOException();
						System.out.println("[메시지 수신 성공]" 
						+ socket.getRemoteSocketAddress() 
						+ ": " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for(Client client : Main.clients) { //받은 채팅을 다른 클라이언트들에게 보내준다.
							client.send(message);
						}
					} 
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					try {
						System.out.println("[메시지 수신 오류]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						Main.clients.remove(Client.this);
						socket.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		};
		Main.threadPool.submit(thread); //만들어진 스레드를 메인함수에 있는 스레드풀에 submit.
	}
	
	//클라이언트에게 메시지를 전송하는 메소드입니다.
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					OutputStream out = socket.getOutputStream(); // 메시지를 보내주고자 할때 
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer); //버퍼에 담긴 내용을 서버로 전송해준다.
					out.flush(); //반드시 flush를 해줘야 여기까지 성공적으로 전송했다는 것을 알려줄 수 있다.
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					try {
						System.out.println("[메시지 송신 오류]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						Main.clients.remove(Client.this);//오류가 발생하면 모든 클라이언트 정보를 담는 배열에서 현재 존재하는 클라이언트를 지워줌.
						socket.close(); //오류가 생긴 클라이언트를 닫기.
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} 
			}
		};
		Main.threadPool.submit(thread);
	}

}
