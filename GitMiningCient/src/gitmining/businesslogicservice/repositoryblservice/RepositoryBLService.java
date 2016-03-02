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
	 * @return �ֿ�����
	 */
	public int getTotalRepositoryNum();

	/**
	 * @param owner
	 * @param repo
	 * @return ��Ӧ�ֿ���Ϣ
	 */
	public RepositoryVO getRepositoryInfomation(String owner,String repo);

	/**
	 * @param start ���
	 * @param end �յ�
	 * @param strategy ���з���
	 * @return ��start��end�����вֿ���Ϣ
	 */
	public Iterator<RepositoryVO> getRepositoryList(int start, int end,
			RepositorySortingStrategy strategy);

}
