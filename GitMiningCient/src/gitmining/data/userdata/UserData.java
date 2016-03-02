package gitmining.data.userdata;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.dataservice.userdataservice.UserDataService;
import gitmining.po.UserPO;

public class UserData implements UserDataService{

	private static UserDataService userData = null;

	private UserData() {
	}

	// 单件模式
	public static UserDataService getInstance() {
		if(userData == null)
			userData = new UserData();
		return userData;
	}
	
	@Override
	public UserPO getUserPO(String name) {
		if(name.compareTo("gfxmonk")==0)name="timbertson";//这个账号很特殊，有关联账号timbertson
		String URL = "http://www.gitmining.net/api/user/"+name;
		String userStr = "";
		try {
			userStr = JsonDataAnalysis.getDataString(URL);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(userStr.charAt(0)!='{'){
			System.out.println("查无此用户！"+name);
			return null;
		}
		
        JSONObject jo = null;
		UserPO userPO = null;
        try {
			jo = new JSONObject(userStr);
    		userPO = new UserPO((String)jo.get("login"), 
    				jo.get("id")+"", 
    				(String)jo.get("avatar_url"), 
    				(String)jo.get("gravatar_id"), 
    				(String)jo.get("url"), 
    				(String)jo.get("html_url"), 
    				(String)jo.get("followers_url"), 
    				(String)jo.get("following_url"), 
    				(String)jo.get("gists_url"), 
    				(String)jo.get("starred_url"), 
    				(String)jo.get("subscriptions_url"), 
    				(String)jo.get("organizations_url"), 
    				(String)jo.get("repos_url"), 
    				(String)jo.get("events_url"), 
    				(String)jo.get("received_events_url"), 
    				(String)jo.get("type"), 
    				(boolean)jo.get("site_admin"),
    				jo.has("name")?(String)jo.get("name"):null,
    	    		jo.has("company")?(String)jo.get("company"):null,
    	    		jo.has("blog")?(String)jo.get("blog"):null,
    				jo.has("location")?(String)jo.get("location"):null,
    	    		jo.has("email")?(String)jo.get("email"):null,
    				jo.has("hireable")?true:false,//如果存在hireable值都是true，不知道有没有漏网之鱼
    	    		jo.has("bio")?(String)jo.get("bio"):null,
    				(int)jo.get("public_repos"), 
    				(int)jo.get("public_gists"), 
    				(int)jo.get("followers"), 
    				(int)jo.get("following"), 
    				(String)jo.get("created_at"), 
    				(String)jo.get("updated_at"));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return userPO;
	}

	@Override
	public Iterator<UserPO> getAllProjectPO(String name) {
		ArrayList<UserPO> userPOs = new ArrayList<>();
		try {
			JSONArray ja = new JSONArray(
					JsonDataAnalysis
					.getDataString("http://www.gitmining.net/api/repository/names"));
//			System.out.println(ja.length());
			
			ArrayList<String> arr = new ArrayList<String>();
			String regex = "^"+name+".*";//正则表达式
			for (int i = 0; i < ja.length(); i++) {
				String[] info = ja.getString(i).split("/");
				if(info[0].matches(regex)){
					arr.add(info[0]);
				}
			}
			for (int i = 0; i < arr.size(); i++) {
				userPOs.add(getUserPO(arr.get(i)));
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
		return userPOs.iterator();
	}

}
