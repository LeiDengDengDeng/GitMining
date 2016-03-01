package gitmining.po;

import java.util.Iterator;

/**
 * @author dell
 *
 */
public class ProjectPO {
	private String authorName; // 作者名
	private String projectName; // 项目名
	private String language; // 项目使用语言
	private int stars; // star人数
	private int forks; // fork人数
	private int subscribers; // 关注人数
	private Iterator<String> collaborators; // 合作者
	private Iterator<String> contributors; // 贡献者
	private String lastUpdatedTime; // 最后更新时间
	
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
