/**
 * 2016��3��1��
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
 * @author ̷����
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
//		ProjectDataService projectDataService = new ProjectData();
//		projectDataService.getProjectPO("rubinius", "rubinius");
//		projectDataService.getProjectPO("timbertson", "mocktest");
//		projectDataService.getAllProjectPO();
		
//		userDataService.getUserPO("gitextensions");
//		UserPO userPO = userDataService.getUserPO("gfxmonk");
//		UserPO userPO = userDataService.getUserPO("aasm");"gfxmonk/mocktest"��533������0��ʼ����
//		UserPO userPO2 = userDataService.getUserPO("gfxmonkssssssssssssssssssssss");
//		if(userPO.getCompany()==null)System.out.println("asdf");
//		System.out.println(userPO.getCompany());
//		System.out.println(userPO.getHireable());
//		System.out.println(userPO.getBio());
//		System.out.println(userPO.getEmail());
		
		UserData.getInstance().getAllProjectPO("gfx");
	}

}
