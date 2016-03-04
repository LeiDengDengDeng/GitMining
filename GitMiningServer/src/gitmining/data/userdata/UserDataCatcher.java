package gitmining.data.userdata;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.po.UserPO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 用于爬仓库相关数据
 * 每隔一段时间应用它更新ser文件数据
 * 
 */
public class UserDataCatcher {

	private final static String URL = "http://www.gitmining.net/api/repository/names";

	public static void main(String[] args) {
		UserDataCatcher r = new UserDataCatcher();
		r.run();
	}

	private void run() {
		JSONArray ja = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			ja = new JSONArray(JsonDataAnalysis.getDataString(URL));
			fos = new FileOutputStream("user.ser");
			oos = new ObjectOutputStream(fos);
		} catch (ClientProtocolException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		for (int i = 0; i < ja.length(); i++) {
			try {
				String[] info = ja.getString(i).split("/");
				String userStr = JsonDataAnalysis.getDataString("http://www.gitmining.net/api/user/"+info[0]);
				// 非JSON数据
				if (userStr.charAt(0) != '{')
					continue;

				
				// 将JSONObject转换为PO，并存储进文件
				JSONObject jo = new JSONObject(userStr);

//				System.out.println(i);
				System.out.println((String)jo.get("login")+i);

				UserPO userPO = new UserPO((String)jo.get("login"), 
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
				oos.writeObject(userPO);
			} catch (ClientProtocolException e) {
				System.out.println("Catcher ClientProtocolException");
				e.printStackTrace();
			} catch (JSONException e) {
				System.out.println("JSONException");
				continue;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
