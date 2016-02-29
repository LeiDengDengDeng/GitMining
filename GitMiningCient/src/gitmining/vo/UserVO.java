package gitmining.vo;

import java.util.ArrayList;

public class UserVO {
	private String name;
	private String address;
	private String email;
	private String jointime;
	private ArrayList<UserVO> Followers;//粉丝
	private ArrayList<UserVO> Starred;
	private ArrayList<UserVO> Following;//偶像

	private ArrayList<ProjectVO> contributions;
	private ArrayList<ProjectVO> repositories;
	
	
     public UserVO(String name, String address, String email, String jointime){
    	 this.name = name;
    	 this.address = address;
    	 this.email = email;
    	 this.jointime = jointime;
    	 
    	 Followers = new ArrayList<UserVO>();
    	 Starred = new ArrayList<UserVO>();
    	 Following = new ArrayList<UserVO>();
    	 contributions = new ArrayList<ProjectVO>();
    	 repositories = new ArrayList<ProjectVO>();
     }

     
  	public String getName() {
  		return name;
  	}
  	public void setName(String name) {
  		this.name = name;
  	}
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public String getJointime() {
		return jointime;
	}
	public void setJointime(String jointime) {
		this.jointime = jointime;
	}
    
	public ArrayList<UserVO> getFollowers() {
		return Followers;
	}
	public void setFollowers(ArrayList<UserVO> Followers) {
		this.Followers = Followers;
	}
    
	public ArrayList<UserVO> getStarred() {
		return Starred;
	}
	public void setStarred(ArrayList<UserVO> Starred) {
		this.Starred = Starred;
	}
    
	public ArrayList<UserVO> getFollowing() {
		return Following;
	}
	public void setFollowing(ArrayList<UserVO> Following) {
		this.Following = Following;
	}
    
	public ArrayList<ProjectVO> getContributions() {
		return contributions;
	}
	public void setContributions(ArrayList<ProjectVO> contributions) {
		this.contributions = contributions;
	}
    
	public ArrayList<ProjectVO> getRepositories() {
		return repositories;
	}
	public void setRepositories(ArrayList<ProjectVO> repositories) {
		this.repositories = repositories;
	}
}
