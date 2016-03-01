package gitmining.data.projectdata;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.dataservice.projectdataservice.ProjectDataService;
import gitmining.po.ProjectPO;

public class ProjectData implements ProjectDataService {

	@Override
	public ProjectPO getProjectPO(String owner, String repo) {
		String URL = "http://www.gitmining.net/api/repository/" + owner + "/"
				+ repo;
		
		// 待改 需要判断是否能找到
//		ProjectPO po = new ProjectPO(owner, repo, JsonDataAnalysis.getDataString(URL), stars, forks, subscribers, collaborators, contributors, lastUpdatedTime)
		
		return null;
	}

	@Override
	public Iterator<ProjectPO> getAllProjectPO() {
		ArrayList<ProjectPO> projectPOs = new ArrayList<>();
		try {
			JSONArray ja = new JSONArray(
					JsonDataAnalysis
							.getDataString("http://www.gitmining.net/api/repository/names"));
			for (int i = 0; i < ja.length(); i++) {
				String[] info = ja.getString(i).split("/");
				projectPOs.add(getProjectPO(info[0], info[1]));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
