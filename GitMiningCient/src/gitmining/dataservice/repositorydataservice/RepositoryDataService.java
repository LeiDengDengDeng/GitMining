package gitmining.dataservice.repositorydataservice;

import gitmining.po.RepositoryPO;

import java.util.Iterator;

public interface RepositoryDataService {
	
	/**
	 * @param owner 作者名
	 * @param repo 仓库名
	 * @return 仓库信息
	 */
	public RepositoryPO getRepositoryPO(String owner,String repo);

	/**
	 * @return 所有仓库信息
	 */
	public Iterator<RepositoryPO> getAllRepositoryPO();

}
