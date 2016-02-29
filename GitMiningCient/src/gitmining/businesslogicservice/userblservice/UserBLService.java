package gitmining.businesslogicservice.userblservice;

import gitmining.vo.UserVO;

import java.util.Iterator;

public interface UserBLService {

	public UserVO getUserInfomation(String userName);

	public Iterator<UserVO> getUserList(String sortingContent);

}
