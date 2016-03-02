package gitmining.businesslogicservice.repositoryblservice;

import gitmining.businesslogic.repositorybl.RepositorySortingStrategy;
import gitmining.vo.RepositoryVO;

import java.util.Iterator;

/**
 * @author dell
 * 
 */
public interface RepositoryBLService {

	/**
	 * @return 仓库总数
	 */
	public int getTotalRepositoryNum();

	/**
	 * @param owner
	 * @param repo
	 * @return 对应仓库信息
	 */
	public RepositoryVO getRepositoryInfomation(String owner,String repo);

	/**
	 * @param start 起点
	 * @param end 终点
	 * @param strategy 排列方法
	 * @return 从start到end的所有仓库信息
	 */
	public Iterator<RepositoryVO> getRepositoryList(int start, int end,
			RepositorySortingStrategy strategy);

}
