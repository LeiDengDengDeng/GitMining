/**
 * 2016��3��1��
 *author:
 *description:
 */
package gitmining;

import gitmining.data.projectdata.ProjectData;
import gitmining.data.userdata.UserData;
import gitmining.dataservice.projectdataservice.ProjectDataService;
import gitmining.dataservice.userdataservice.UserDataService;
import gitmining.po.UserPO;

/**
 * @author ̷����
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//ProjectDataService projectDataService = new ProjectData();
		//projectDataService.getProjectPO("rubiniu", "rubinius");
		
		UserDataService userDataService = new UserData();
		userDataService.getUserPO("sdadsadwawds");
		UserPO userPO = userDataService.getUserPO("rubinius");
		System.out.println(userPO.getCompany());
		System.out.println(userPO.getHireable());
		System.out.println(userPO.getBio());
		System.out.println(userPO.getEmail());
	}

}
