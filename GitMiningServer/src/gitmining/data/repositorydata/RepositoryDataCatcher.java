package gitmining.data.repositorydata;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.po.RepositoryPO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * �������ֿ��������
 * ÿ��һ��ʱ��Ӧ��������ser�ļ�����
 * @author dell
 * 
 */
public class RepositoryDataCatcher {

	private final static String URL = "http://www.gitmining.net/api/repository/";

	public static void main(String[] args) {
		RepositoryDataCatcher r = new RepositoryDataCatcher();
		r.run();
	}

	private void run() {
		JSONArray ja = null;
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		try {
			ja = new JSONArray(JsonDataAnalysis.getDataString(URL + "names"));
			fs = new FileOutputStream("repository.ser");
			os = new ObjectOutputStream(fs);
		} catch (ClientProtocolException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (JSONException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}

		for (int i = 0; i < ja.length(); i++) {
			try {
				String[] info = ja.getString(i).split("/"); // ��ȡrepo����owner��
				String jsonStr = JsonDataAnalysis.getDataString(URL + info[0]
						+ "/" + info[1]);

				// ��JSON����
				if (jsonStr.charAt(0) != '{')
					continue;

				// ��JSONObjectת��ΪPO�����洢���ļ�
				JSONObject jo = new JSONObject(jsonStr);

				JSONArray conJa = new JSONArray(
						JsonDataAnalysis.getDataString(URL + info[0] + "/"
								+ info[1] + "/contributors/login"));
				JSONArray colJa = new JSONArray(
						JsonDataAnalysis.getDataString(URL + info[0] + "/"
								+ info[1] + "/collaborators/login"));
				String[] conArray = new String[conJa.length()]; // �����������б�
				String[] colArray = new String[colJa.length()]; // �����������б�
				for (int n = 0; n < conJa.length(); n++)
					conArray[n] = conJa.getString(n);
				for (int n = 0; n < colJa.length(); n++)
					colArray[n] = colJa.getString(n);

				System.out.println(i);

				RepositoryPO po = new RepositoryPO(info[0], info[1],
						jo.getString("language"), jo.getInt("watchers_count"),
						jo.getInt("forks"), jo.getInt("subscribers_count"),
						colArray, conArray, jo.getString("updated_at"));
				os.writeObject(po);
			} catch (ClientProtocolException e) {
				System.out.println("Catcher ClientProtocolException");
				e.printStackTrace();
			} catch (JSONException e) {
				System.out.println("JSONException");
				continue;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
