package gitmining.businesslogic.repositorybl;

import gitmining.vo.RepositoryVO;

import java.util.Iterator;

public interface RepositorySortingStrategy {

	public Iterator<RepositoryVO> sort();

}
