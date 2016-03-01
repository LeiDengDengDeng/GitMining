package gitmining.businesslogic.projectbl;

import gitmining.vo.ProjectVO;

import java.util.Iterator;

public interface ProjectSortingStrategy {

	public Iterator<ProjectVO> sort();

}
