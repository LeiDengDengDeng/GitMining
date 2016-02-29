package gitmining.businesslogicservice.projectblservice;

import gitmining.business.projectbl.ProjectSortingStrategy;
import gitmining.vo.ProjectVO;

import java.util.Iterator;

public interface ProjectBLService {
	
	public ProjectVO getProjectInfomation(String projectName);
	
    public Iterator<ProjectVO> getProjectList(ProjectSortingStrategy strategy);

}
