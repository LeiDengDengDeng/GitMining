package test.data;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import gitmining.data.repositorydata.RepositoryData;
import gitmining.po.RepositoryPO;

import org.junit.BeforeClass;
import org.junit.Test;

public class RepositoryDataTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		RepositoryData repoData = RepositoryData.getSingleton();
		RepositoryPO po1 = repoData.getRepositoryPO("technoweenie",
				"attachment_fu");
		assertEquals(po1.getForks(), 295);
		assertEquals(po1.getStars(), 1036);
		assertEquals(po1.getCollaborators().length, 2);
		RepositoryPO po2 = repoData.getRepositoryPO("rubinius", "rubinius");
		assertEquals(po2.getForks(), 588);
		assertEquals(po2.getStars(), 2520);

		Iterator<RepositoryPO> repos = repoData.getAllRepositoryPO();
		while(repos.hasNext()){
			RepositoryPO index = repos.next();
			if(index.getAuthorName().equals("technoweenie") && index.getProjectName().equals("attachment_fu"))
				assertEquals(po1.getForks(), 295);
		}
	}

}
