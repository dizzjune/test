package Common;

import java.io.Serializable;
import java.util.ArrayList;

import VO.Worker;

public class Data implements Serializable {
	public static final int FIRST_CONNECTION = 1; // 새로운 접속자
	public static final int DISCONNECTION = 2; // 연결 종료
	public static final int Worker_LOGIN = 10;
	public static final int Worker_REGIST = 11;
	public static final int CHAT_MESSAGE = 100; // 채팅 내용 전송
	public static final int WORK_INSERT = 60;

	int state; // 전송되는 데이터 종류
	
	ArrayList<String> usernames; // 접속자 이름 목록
	String con;
	Worker worker;
	String name;
	String password;
	
	
	
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public Data(int state, String con) {
		this.state = state;
		this.con = con;
	}

	public Data(int state, String name, String password) {
		this.state = state;
		this.name = name;
		this.password = password;
	}

	public Data(int state, Worker worker) {
		super();
		this.state = state;
		this.worker = worker;
	}
	public Worker getUser() {
		return worker;
	}

	public void setUser(Worker worker) {
		this.worker = worker;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public void setUsernames(ArrayList<String> usernames) {
		this.usernames = usernames;
	}

}
