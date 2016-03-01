package gitmining.dataservice.projectdataservice;

import gitmining.po.ProjectPO;

import java.util.Iterator;

public interface ProjectDataService {
	
	public ProjectPO getProjectPO(String owner,String repo);

	public Iterator<ProjectPO> getAllProjectPO();

}
