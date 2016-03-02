package gitmining.po;

import gitmining.data.util.JsonDataAnalysis;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	private String[] collaborators; // ������
	private String[] contributors; // ������
	private String lastUpdatedTime; // ������ʱ��

	public ProjectPO(String owner, String repo) {
		String projectURL = "http://www.gitmining.net/api/repository/" + owner
				+ "/" + repo;

		try {
			JSONObject jo = new JSONObject(
					JsonDataAnalysis.getDataString(projectURL));
			JSONArray conJa = new JSONArray(
					JsonDataAnalysis.getDataString(projectURL + "/contributors/login"));
			JSONArray colJa = new JSONArray(
					JsonDataAnalysis.getDataString(projectURL
							+ "/collaborators/login"));
			String[] conArray = new String[conJa.length()]; // �����������б�
			String[] colArray = new String[colJa.length()]; // �����������б�
			for (int i = 0; i < conJa.length(); i++)
				conArray[i] = conJa.getString(i);
			for (int i = 0; i < colJa.length(); i++)
				colArray[i] = colJa.getString(i);

			this.authorName = owner;
			this.projectName = repo;
			this.language = jo.getString("language");
			this.stars = jo.getInt("watchers_count");
			this.forks = jo.getInt("forks");
			this.subscribers = jo.getInt("subscribers_count");
			this.collaborators = colArray;
			this.contributors = conArray;
			this.lastUpdatedTime = jo.getString("updated_at");

		} catch (ClientProtocolException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
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
