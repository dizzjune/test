package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import UI.LoginUI;
import Common.Data;

public class MainTest implements Runnable{
	private String ip;
	private int port;
	private String con;
	
	private	Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainTest main = new MainTest("127.0.0.1", 3333);
		
		new LoginUI();
	}
	
	public MainTest(String ip, int port) {
		this.ip = ip;
		this.port = port;
		
		connect();
	}
	
	public void connect() {
		try {
			socket = new Socket(ip, port);
			System.out.println("*** 서버에 접속되었습니다.");
			con = socket.getInetAddress().getHostAddress();
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			
			new Thread(this).start();
			Data data = new Data(Data.FIRST_CONNECTION,con);
			output.writeObject(data);
		} catch (IOException e) {
			System.out.println("*** 서버 접속 실패");
		} 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Data data = null;
		int state = 0;
		
		
		while (true) {
			try {
				data = (Data) input.readObject();
				state = data.getState();
				
				switch (state) {
				case Data.FIRST_CONNECTION : 
				}
				
			}
			catch (Exception e) {
				return;
			}
		}
	}
}
