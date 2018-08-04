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
	
	public static ExecutorService threadPool; //������Ǯ�� �̿��ؼ� �پ��� Ŭ���̾�Ʈ�� ���������� �����带 ȿ�������� ����(ExecutorService���̺귯���� ���)
	public static Vector<Client> clients = new Vector<Client>();//������ Ŭ���̾�Ʈ�� ����, Vector�� ������ �迭
	
	ServerSocket serverSocket;
	
	// ������ �������Ѽ� Ŭ���̾�Ʈ�� ������ ��ٸ��� �޼ҵ��Դϴ�.
	public void startServer(String IP, int port) {
		
		try {
			serverSocket = new ServerSocket(); //���� ���� �����
			serverSocket.bind(new InetSocketAddress(IP, port)); //������ǻ�Ϳ��� Ư���� IP, Port�� ���� Ŭ���̾�Ʈ�� ��ٸ��� �ϴ�  bind
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		//Ŭ���̾�Ʈ�� �����Ҷ����� ��� ��ٸ��� �������Դϴ�.
		Runnable thread = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						Socket socket = serverSocket.accept(); //����ؼ� ���ο� Ŭ���̾�Ʈ�� ������ �� �ִ�.
						clients.add(new Client(socket)); // ���� ������ Ŭ���̾�Ʈ�� �迭�� �����Ѵ�.
						System.out.println("[Ŭ���̾�Ʈ ����]"
								+ socket.getRemoteSocketAddress()
								+ ": " + Thread.currentThread().getName());//�ش罺���� ������ ���
					} catch (IOException e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
						if(!serverSocket.isClosed()) { //�������Ͽ� ������ �ִٸ� 
							stopServer();
						}
						break;
					}
				}
				
			}
		};
		threadPool = Executors.newCachedThreadPool(); //������Ǯ �ʱ�ȭ
		threadPool.submit(thread); //������ Ŭ���̾�Ʈ�� ������ ��ٸ��� �����带 ����
	}
	
	
	// ������ �۵��� ������Ű�� �޼ҵ��Դϴ�.
	public void stopServer() {
		try {
			//���� �۵����� ��� ���� �ݱ�
			Iterator<Client> iterator = clients.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			} 
				
			//���� ���� ��ü �ݱ�
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			//������Ǯ �����ϱ�
			if(threadPool != null && !threadPool.isShutdown()) {
				threadPool.shutdown(); //�ڿ��Ҵ� ����
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	// UI�� �����ϰ�, ���������� ���α׷��� ���۽�Ű�� �޼ҵ��Դϴ�.
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("�������", 15));
		root.setCenter(textArea);
		
		Button toggleButton = new Button("�����ϱ�");
		toggleButton.setMaxWidth(Double.MAX_VALUE);
		BorderPane.setMargin(toggleButton, new Insets(1, 0, 0, 0));
		root.setBottom(toggleButton);
		
		String IP = "127.0.0.1"; //���� IP
		int port = 9876; //���ǰ�
		
		toggleButton.setOnAction(event -> {
			if(toggleButton.getText().equals("�����ϱ�")) {
				startServer(IP, port);
				Platform.runLater(() -> {
					String message = String.format("[���� ����]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			} else {
				stopServer();
				Platform.runLater(() -> {
					String message = String.format("[���� ����]\n", IP, port);
					textArea.appendText(message);
					toggleButton.setText("�����ϱ�");
				});
			}
		});
		
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("[ä�� ����]");
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
	
	
	//���α׷��� �������Դϴ�.
	public static void main(String[] args) {
		launch(args);
	}
}
