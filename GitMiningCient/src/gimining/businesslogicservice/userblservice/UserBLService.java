package gimining.businesslogicservice.userblservice;

import java.util.Iterator;

import vo.UserVO;

public interface UserBLService {

	public UserVO getUserInfomation(String userName);

	public Iterator<UserVO> getUserList(String sortingContent);

}
