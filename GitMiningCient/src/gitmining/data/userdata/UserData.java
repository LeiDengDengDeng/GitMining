package gitmining.data.userdata;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import gitmining.dataservice.userdataservice.UserDataService;
import gitmining.po.UserPO;

public class UserData implements UserDataService{

	private static UserData userData = null;

	private UserData() {
	}

	// 单件模式
	public static UserData getInstance() {
		if(userData == null)
			userData = new UserData();
		return userData;
	}
	
	@Override
	public UserPO getUserPO(String login) {
		FileInputStream fi = null;
		ObjectInputStream ois = null;

		try {
			fi = new FileInputStream(new File("user.ser"));
			ois = new ObjectInputStream(fi);
			while (true) {
				UserPO po = (UserPO) ois.readObject();
				// 判断是否为所需要的仓库
				if (po.getLogin().equals(login)) {//登录名一致
					ois.close();
					return po;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// 读取到文件末尾，不需要处理
			System.out.println("End of file");
			try {
				ois.close();
			} catch (IOException e1) {
				System.out.println("Close error");
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<UserPO> getAllUserPO(String login) {
		ArrayList<UserPO> pos = new ArrayList<UserPO>();

		FileInputStream fi = null;
		ObjectInputStream ois = null;
		try {
			fi = new FileInputStream(new File("user.ser"));
			ois = new ObjectInputStream(fi);

			String regex = "^"+login+".*";//搜索筛选
			while (true) {
				UserPO po = (UserPO) ois.readObject();
				if(po.getLogin().matches(regex)){//登陆名匹配
					pos.add(po);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// 读取到文件末尾，不需要处理
			System.out.println("End of file");
			try {
				ois.close();
			} catch (IOException e1) {
				System.out.println("Close error");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(pos.size());
		return pos.iterator();
	}
}
