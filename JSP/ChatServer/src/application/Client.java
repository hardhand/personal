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
	
	//Ŭ���̾�Ʈ�κ��� �޽����� ���޹޴� �޼ҵ��Դϴ�.
	public void receive() {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				while(true) { // �ݺ������� Ŭ���̾�Ʈ���� ä���� �޴´�.
					InputStream in = socket.getInputStream();
					byte[] buffer = new byte[512];
					
						int length = in.read(buffer);
						while(length == -1) throw new IOException();
						System.out.println("[�޽��� ���� ����]" 
						+ socket.getRemoteSocketAddress() 
						+ ": " + Thread.currentThread().getName());
						String message = new String(buffer, 0, length, "UTF-8");
						for(Client client : Main.clients) { //���� ä���� �ٸ� Ŭ���̾�Ʈ�鿡�� �����ش�.
							client.send(message);
						}
					} 
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					try {
						System.out.println("[�޽��� ���� ����]"
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
		Main.threadPool.submit(thread); //������� �����带 �����Լ��� �ִ� ������Ǯ�� submit.
	}
	
	//Ŭ���̾�Ʈ���� �޽����� �����ϴ� �޼ҵ��Դϴ�.
	public void send(String message) {
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					OutputStream out = socket.getOutputStream(); // �޽����� �����ְ��� �Ҷ� 
					byte[] buffer = message.getBytes("UTF-8");
					out.write(buffer); //���ۿ� ��� ������ ������ �������ش�.
					out.flush(); //�ݵ�� flush�� ����� ������� ���������� �����ߴٴ� ���� �˷��� �� �ִ�.
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					try {
						System.out.println("[�޽��� �۽� ����]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());
						Main.clients.remove(Client.this);//������ �߻��ϸ� ��� Ŭ���̾�Ʈ ������ ��� �迭���� ���� �����ϴ� Ŭ���̾�Ʈ�� ������.
						socket.close(); //������ ���� Ŭ���̾�Ʈ�� �ݱ�.
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} 
			}
		};
		Main.threadPool.submit(thread);
	}

}
