package DAO;

import java.util.ArrayList;

import VO.Work;

public interface WorkMapper {

	public void insertWork(Work vo);

	public ArrayList<Work> WorkList();

}
