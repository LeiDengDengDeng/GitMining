package test.data;

import static org.junit.Assert.*;
import gitmining.data.projectdata.ProjectData;
import gitmining.po.ProjectPO;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectDataTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ProjectData projectData = ProjectData.getSingleton();
		ProjectPO po1 = projectData.getProjectPO("technoweenie",
				"attachment_fu");
		assertEquals(po1.getForks(), 295);
		assertEquals(po1.getStars(), 1036);
		assertEquals(po1.getCollaborators().length, 2);
		ProjectPO po2 = projectData.getProjectPO("rubinius", "rubinius");
		assertEquals(po2.getForks(), 588);
		assertEquals(po2.getStars(), 2520);
	}

}
