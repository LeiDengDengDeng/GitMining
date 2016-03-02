package test.data;

import static org.junit.Assert.assertEquals;
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
		RepositoryData projectData = RepositoryData.getSingleton();
		RepositoryPO po1 = projectData.getRepositoryPO("technoweenie",
				"attachment_fu");
		assertEquals(po1.getForks(), 295);
		assertEquals(po1.getStars(), 1036);
		assertEquals(po1.getCollaborators().length, 2);
		RepositoryPO po2 = projectData.getRepositoryPO("rubinius", "rubinius");
		assertEquals(po2.getForks(), 588);
		assertEquals(po2.getStars(), 2520);

		// 时间问题待考虑
		projectData.getAllRepositoryPO();
	}

}
