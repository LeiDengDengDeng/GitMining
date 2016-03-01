/**
 * 2016年3月1日
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
 * @author 谭期友
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
