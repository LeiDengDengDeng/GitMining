package gitmining.po;

import java.util.Iterator;

/**
 * @author dell
 *
 */
public class ProjectPO {
	private String authorName; // ������
	private String projectName; // ��Ŀ��
	private String language; // ��Ŀʹ������
	private int stars; // star����
	private int forks; // fork����
	private int subscribers; // ��ע����
	private Iterator<String> collaborators; // ������
	private Iterator<String> contributors; // ������
	private String lastUpdatedTime; // ������ʱ��
	
	public ProjectPO(String authorName, String projectName, String language,
			int stars, int forks, int subscribers,
			Iterator<String> collaborators, Iterator<String> contributors,
			String lastUpdatedTime) {
		super();
		this.authorName = authorName;
		this.projectName = projectName;
		this.language = language;
		this.stars = stars;
		this.forks = forks;
		this.subscribers = subscribers;
		this.collaborators = collaborators;
		this.contributors = contributors;
		this.lastUpdatedTime = lastUpdatedTime;
	}


}
