package test.data;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import gitmining.data.userdata.UserData;
import gitmining.po.UserPO;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserDataTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		UserData data = UserData.getInstance();
		UserPO userPO = data.getUserPO("aasm");
		System.out.println(userPO.getUrl());
		UserPO userPO2 = data.getUserPO("sebastianbergmann");
		System.out.println(userPO2.getUrl());

		assertEquals(userPO.getPublic_repos(), 5);
		assertEquals(userPO.getPublic_gists(), 0);
		assertEquals(userPO.getFollowers(), 0);
		assertEquals(userPO.getFollowing(), 0);
		assertEquals(userPO2.getPublic_repos(), 43);
		assertEquals(userPO2.getPublic_gists(), 9);
		assertEquals(userPO2.getFollowers(), 2864);
		assertEquals(userPO2.getFollowing(), 0);
		
		Iterator<UserPO> it = data.getAllUserPO("a");
		int i=0;
		while(it.hasNext()){
			UserPO index = it.next();
			System.out.println(index.getLogin()+(i++));
		}
	}

}
