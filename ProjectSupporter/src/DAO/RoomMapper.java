package DAO;

import java.util.ArrayList;

import VO.Room;

public interface RoomMapper {

	public void insertRoom(Room vo);

	public ArrayList<Room> RoomList();

	public Room RoomCheck(String room_seq);

}
