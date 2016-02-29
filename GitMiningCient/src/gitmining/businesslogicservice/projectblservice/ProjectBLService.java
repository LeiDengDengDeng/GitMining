package gitmining.businesslogicservice.projectblservice;

import gitming.business.projectbl.ProjectSortingStrategy;

import java.util.Iterator;

import vo.ProjectVO;

public interface ProjectBLService {
	
	public ProjectVO getProjectInfomation(String projectName);
	
    public Iterator<ProjectVO> getProjectList(ProjectSortingStrategy strategy);

}
