package gitmining.po;

import java.io.Serializable;


/**
 * @author dell
 * 
 */
public class RepositoryPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3764719387412775293L;
	
	private String authorName; // 作者名
	private String projectName; // 项目名
	private String language; // 项目使用语言
	private int stars; // star人数
	private int forks; // fork人数
	private int subscribers; // 关注人数
	private String[] collaborators; // 合作者
	private String[] contributors; // 贡献者
	private String lastUpdatedTime; // 最后更新时间

	public RepositoryPO(String authorName, String projectName, String language,
			int stars, int forks, int subscribers, String[] collaborators,
			String[] contributors, String lastUpdatedTime) {
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getForks() {
		return forks;
	}

	public void setForks(int forks) {
		this.forks = forks;
	}

	public int getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(int subscribers) {
		this.subscribers = subscribers;
	}

	public String[] getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(String[] collaborators) {
		this.collaborators = collaborators;
	}

	public String[] getContributors() {
		return contributors;
	}

	public void setContributors(String[] contributors) {
		this.contributors = contributors;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}
