package gitmining.vo;

public class RepositoryVO {
	private String name;
	private String language;
	private String HTTPS;
	private UserVO author;
	private int commits;
	private int branches;
	private int releases;
	private int contributors;
	
	private int issues;
	private int pullrequests;
	
	public RepositoryVO(String name, String language, String HTTPS, UserVO author,
			int commits, int branches, int releases, 
			int contributors, int issues, int pullrequests){
		this.name = name;
		this.language = language;
		this.HTTPS = HTTPS;
		this.author = author;
		this.commits = commits;
		this.branches = branches;
		this.releases = releases;
		this.contributors = contributors;
		this.issues = issues;
		this.pullrequests = pullrequests;
	}

  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
  	
  	public String getLanguage() {
  		return language;
  	}
  	public void setLanguage(String language) {
  		this.language = language;
  	}

  	public String getHTTPS() {
  		return HTTPS;
  	}
  	public void setHTTPS(String HTTPS) {
  		this.HTTPS = HTTPS;
  	}

  	public UserVO getAuthor() {
  		return author;
  	}
  	public void setAuthor(UserVO author) {
  		this.author = author;
  	}

  	public int getcommits() {
  		return commits;
  	}
  	public void setcommits(int commits) {
  		this.commits = commits;
  	}

  	public int getbranches() {
  		return branches;
  	}
  	public void setbranches(int branches) {
  		this.branches = branches;
  	}

  	public int getreleases() {
  		return releases;
  	}
  	public void setreleases(int releases) {
  		this.releases = releases;
  	}

  	public int getcontributors() {
  		return contributors;
  	}
  	public void setcontributors(int contributors) {
  		this.contributors = contributors;
  	}

  	public int getissues() {
  		return issues;
  	}
  	public void setissues(int issues) {
  		this.issues = issues;
  	}

  	public int getpullrequests() {
  		return pullrequests;
  	}
  	public void setpullrequests(int pullrequests) {
  		this.pullrequests = pullrequests;
  	}
}
