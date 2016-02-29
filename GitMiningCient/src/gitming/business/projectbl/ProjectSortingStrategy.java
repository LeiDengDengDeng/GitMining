package gitming.business.projectbl;

import java.util.Iterator;

import vo.ProjectVO;

public interface ProjectSortingStrategy {

	public Iterator<ProjectVO> sort();

}
