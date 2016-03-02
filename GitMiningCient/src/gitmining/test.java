/**
 * 2016年3月1日
 *author:
 *description:
 */
package gitmining;

import gitmining.data.repositorydata.RepositoryData;
import gitmining.data.userdata.UserData;
import gitmining.dataservice.repositorydataservice.RepositoryDataService;
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
//		ProjectDataService projectDataService = new ProjectData();
//		projectDataService.getProjectPO("rubinius", "rubinius");
//		projectDataService.getProjectPO("timbertson", "mocktest");
//		projectDataService.getAllProjectPO();
		
//		userDataService.getUserPO("gitextensions");
//		UserPO userPO = userDataService.getUserPO("gfxmonk");
//		UserPO userPO = userDataService.getUserPO("aasm");"gfxmonk/mocktest"第533个（从0开始数）
//		UserPO userPO2 = userDataService.getUserPO("gfxmonkssssssssssssssssssssss");
//		if(userPO.getCompany()==null)System.out.println("asdf");
//		System.out.println(userPO.getCompany());
//		System.out.println(userPO.getHireable());
//		System.out.println(userPO.getBio());
//		System.out.println(userPO.getEmail());
		
		UserData.getInstance().getAllProjectPO("gfx");
	}

}
