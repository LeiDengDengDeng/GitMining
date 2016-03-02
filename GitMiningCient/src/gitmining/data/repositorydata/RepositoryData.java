package gitmining.data.repositorydata;

import gitmining.data.util.JsonDataAnalysis;
import gitmining.dataservice.repositorydataservice.RepositoryDataService;
import gitmining.po.RepositoryPO;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;

public class RepositoryData implements RepositoryDataService {

	private static RepositoryData repositoryData;

	private RepositoryData() {
	}

	// ����ģʽ
	public static RepositoryData getSingleton() {
		return (repositoryData == null) ? repositoryData = new RepositoryData()
				: repositoryData;
	}

	// ���� ��Ҫ�ж��Ƿ����ҵ�
	// ��JsonDataAnalysis ���getDataString����Null ������������� ������
	@Override
	public RepositoryPO getRepositoryPO(String owner, String repo) {
		RepositoryPO po = new RepositoryPO(owner, repo);
		return po;
	}

	// ���� ��Ҫ�ж��Ƿ����ҵ�
	// ��JsonDataAnalysis ���getDataString����Null ������������� ������
	@Override
	public Iterator<RepositoryPO> getAllRepositoryPO() {
		ArrayList<RepositoryPO> repositoryPOs = new ArrayList<>();
		try {
			// ��ȡ�����б�
			JSONArray ja = new JSONArray(
					JsonDataAnalysis
							.getDataString("http://www.gitmining.net/api/repository/names"));
			System.out.println(ja.length());
			for (int i = 0; i < ja.length(); i++) {
				String[] info = ja.getString(i).split("/");
				repositoryPOs.add(getRepositoryPO(info[0], info[1]));
			}
			return repositoryPOs.iterator();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Excuse me,this is RepositoryData");
		return null;
	}
}
