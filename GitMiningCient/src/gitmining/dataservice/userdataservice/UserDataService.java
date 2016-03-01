package gitmining.dataservice.userdataservice;

import gitmining.po.UserPO;

import java.util.Iterator;

public interface UserDataService {
	
	public UserPO getUserPO(String name);

	public Iterator<UserPO> getAllProjectPO();

}
