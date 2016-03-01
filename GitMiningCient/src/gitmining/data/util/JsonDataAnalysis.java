package gitmining.data.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonDataAnalysis {
	
    /**
     * ����Json����
     * 
     * @param jsonString
     *            Json�����ַ���
     * @throws JSONException
     * @throws ParseException
     */
    public static void parseJson(String jsonString) throws JSONException,
            ParseException {
        JSONObject jo = new JSONObject(jsonString);
//        JSONArray ja = jo.getJSONArray("name");
        System.out.println(jo.getString("name"));
//        System.out.println("\n��Json���ݽ���ΪMap��");
    } 
      
    public static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }
    
    public static String getJsonString(String URL) throws ClientProtocolException, IOException, JSONException, ParseException{  
        // ����HttpClientʵ��     
        HttpClient httpclient = new DefaultHttpClient();  
        // ����Get����ʵ��     
        HttpGet httpgets = new HttpGet(URL);    
        HttpResponse response = httpclient.execute(httpgets);    
        HttpEntity entity = response.getEntity();    
        if (entity != null) {    
            InputStream instreams = entity.getContent();  
            String str = convertStreamToString(instreams);  
            System.out.println(str);  
            httpgets.abort();    
            return str;
        }
        // error
        return null;
    } 

}
