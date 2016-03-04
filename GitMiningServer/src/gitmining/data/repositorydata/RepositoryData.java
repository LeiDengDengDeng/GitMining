package gitmining.data.repositorydata;

import gitmining.dataservice.repositorydataservice.RepositoryDataService;
import gitmining.po.RepositoryPO;

import java.util.Iterator;

public class RepositoryData implements RepositoryDataService {

	private static RepositoryData repositoryData;

	private RepositoryData() {
	}

	// 单件模式
	public static RepositoryData getSingleton() {
		return (repositoryData == null) ? repositoryData = new RepositoryData()
				: repositoryData;
	}

	@Override
	public RepositoryPO getRepositoryPO(String owner, String repo) {
		return null;
	}

	@Override
	public Iterator<RepositoryPO> getAllRepositoryPO() {
		return null;
	}
}
