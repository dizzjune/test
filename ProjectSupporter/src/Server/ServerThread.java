package Server;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Server.ServerThread;
import VO.Worker;
import Common.Data;
import DAO.WorkerDAO;
import Server.ServerThread;

public class ServerThread implements Runnable{
	public static ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	BufferedInputStream bis;
	String username;
	String addr;
	WorkerDAO wrdao = new WorkerDAO();

	public ServerThread(Socket socket) {
		try {
			System.out.println("stream okay");
			this.socket = socket;
			// 클라이언트와의 스트림 생성
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
			addr = socket.getInetAddress().getHostAddress();
			System.out.println(addr+"성공");
		} catch (Exception e) {
			System.out.println(addr + "실패");
		}
		list.add(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Data data = null;
		int state = 0;
		String name = null;
		System.out.println("run okay");
		Worker worker = null;
		while (true) {
			try {
				System.out.println("try");
				data = (Data) input.readObject();
				state = data.getState();
				
				switch (state) {
				case Data.Worker_REGIST:
					System.out.println("switch okay");
					System.out.println("status:" + state);
					worker = new Worker();
					worker = data.getUser();
					if(wrdao.insertWorker(worker)) {
						out(true);
					}else {
						out(false);
					
					}
					
					break;
				case Data.Worker_LOGIN:
					System.out.println("switch okay");
					System.out.println("status:" + state);
					
					String id = data.getName();
					String password = data.getPassword();
		
					if(wrdao.WorkerCheck(id, password)) {
						out(true);
					}else {
						out(false);
					}
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	public void out(boolean in) {
		try {
			output.writeObject(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
