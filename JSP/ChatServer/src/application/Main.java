package application;
	
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static ExecutorService threadPool; //스레드풀을 이용해서 다양한 클라이언트가 접속했을때 스레드를 효과적으로 관리(ExecutorService라이브러리의 기능)
	public static Vector<Client> clients = new Vector<Client>();//접속한 클라이언트를 관리, Vector는 일종의 배열
	
	ServerSocket serverSocket;
	
	// 서버를 구동시켜서 클라이언트의 연결을 기다리는 메소드입니다.
	public void startServer(String IP, int port) {
		
		try {
			serverSocket = new ServerSocket(); //서버 소켓 만들기
			serverSocket.bind(new InetSocketAddress(IP, port)); //서버컴퓨터에게 특정한 IP, Port를 가진 클라이언트를 기다리게 하는  bind
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		//클라이언트가 접속할때까지 계속 기다리는 쓰레드입니다.
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Socket socket = serverSocket.accept(); //계속해서 새로운 클라이언트가 접속할 수 있다.
						clients.add(new Client(socket)); // 새로 접속한 클라이언트를 배열에 저장한다.
						System.out.println("[클라이언트 접속]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());//해당스레드 정보를 출력
					} catch (IOException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						if(!serverSocket.isClosed()) { //서버소켓에 문제가 있다면 
							stopServer();
						}
						break;
					}
				}
				
			}
		};
		threadPool = Executors.newCachedThreadPool(); //스레드풀 초기화
		threadPool.submit(thread); //스레드 클라이언트의 접속을 기다리는 스레드를 전송
	}
	
	
	// 서버의 작동을 중지시키는 메소드입니다.
	public void stopServer() {
		try {
			//현재 작동중인 모든 소켓 닫기
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			} 
				
			//서버 소켓 객체 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//스레드풀 종료하기
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown(); //자원할당 해제
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	// UI를 생성하고, 실질적으로 프로그램을 동작시키는 메소드입니다.
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("나눔고딕", 15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("시작하기");
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		root.setBottom(toggleButton);
		
		String IP = "127.0.0.1"; //로컬 IP
		int port = 9876; //임의값
		
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("시작하기")) {
				startServer(IP, port);
				Platform.runLater(() -> {
					String message = String.format("[서버 시작]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("종료하기");
				});
			} else {
				stopServer();
				Platform.runLater(() -> {
					String message = String.format("[서버 종료]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("시작하기");
				});
			}
		});
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[채팅 서버]");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
		/*try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	
	
	//프로그램의 진입점입니다.
	public static void main(String[] args) {
		launch(args);
	}
}
