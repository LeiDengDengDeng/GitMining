package gitmining.dataservice.repositorydataservice;

import gitmining.po.RepositoryPO;

import java.util.Iterator;

public interface RepositoryDataService {
	
	/**
	 * @param owner ������
	 * @param repo �ֿ���
	 * @return �ֿ���Ϣ
	 */
	public RepositoryPO getRepositoryPO(String owner,String repo);

	/**
	 * @return ���вֿ���Ϣ
	 */
	public Iterator<RepositoryPO> getAllRepositoryPO();

}
