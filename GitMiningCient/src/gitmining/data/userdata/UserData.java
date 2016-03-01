package gitmining.data.userdata;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.dataservice.userdataservice.UserDataService;
import gitmining.po.UserPO;

public class UserData implements UserDataService{

	@Override
	public UserPO getUserPO(String name) {
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
		if(userStr.charAt(0)=='<'){
			System.out.println("查无此用户！");
			return null;
		}
		
        JSONObject jo = null;
		try {
			jo = new JSONObject(userStr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		UserPO userPO = null;
		String company = null;
		String hireable = null;
		String bio = null;
        try {
            try {
            	company = (String)jo.get("company");
            } catch (JSONException e) {
    			company = null;
    			e.printStackTrace();
            }
            try {
            	hireable = (String)jo.get("hireable");
            } catch (JSONException e) {
            	hireable = null;
    			e.printStackTrace();
            }
            try {
            	bio = (String)jo.get("bio");
            } catch (JSONException e) {
            	bio = null;
    			e.printStackTrace();
            }
        	
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
    				(String)jo.get("name"), 
    				company, 
    				(String)jo.get("blog"), 
    				(String)jo.get("location"), 
    				(String)jo.get("email"), 
    				hireable, 
    				bio, 
    				(int)jo.get("public_repos"), 
    				(int)jo.get("public_gists"), 
    				(int)jo.get("followers"), 
    				(int)jo.get("following"), 
    				(String)jo.get("created_at"), 
    				(String)jo.get("updated_at"));
			System.out.println("全部资料的网站:"+jo.get("url"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return userPO;
	}

	@Override
	public Iterator<UserPO> getAllProjectPO() {
		ArrayList<UserPO> userPOs = new ArrayList<>();
		return null;
	}

}
