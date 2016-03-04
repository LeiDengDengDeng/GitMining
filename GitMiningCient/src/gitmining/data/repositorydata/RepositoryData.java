package gitmining.data.repositorydata;

import gitmining.dataservice.repositorydataservice.RepositoryDataService;
import gitmining.po.RepositoryPO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class RepositoryData implements RepositoryDataService {

	private static RepositoryData repositoryData;

	private RepositoryData() {
	}

	public static void main(String[] args) {
		RepositoryData rp = new RepositoryData();
		rp.getAllRepositoryPO();
	}

	// 单件模式
	public static RepositoryData getSingleton() {
		return (repositoryData == null) ? repositoryData = new RepositoryData()
				: repositoryData;
	}

	@Override
	public RepositoryPO getRepositoryPO(String owner, String repo) {
		FileInputStream fi = null;
		ObjectInputStream ois = null;

		try {
			fi = new FileInputStream(new File("repository.ser"));
			ois = new ObjectInputStream(fi);
			while (true) {
				RepositoryPO po = (RepositoryPO) ois.readObject();
				// 判断是否为所需要的仓库
				if (po.getAuthorName().equals(owner) && po.getProjectName().equals(repo)) {
					ois.close();
					return po;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// 读取到文件末尾，不需要处理
			System.out.println("End of file");
			try {
				ois.close();
			} catch (IOException e1) {
				System.out.println("Close error");
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<RepositoryPO> getAllRepositoryPO() {
		ArrayList<RepositoryPO> pos = new ArrayList<RepositoryPO>();

		FileInputStream fi = null;
		ObjectInputStream ois = null;
		try {
			fi = new FileInputStream(new File("repository.ser"));
			ois = new ObjectInputStream(fi);

			while (true) {
				RepositoryPO po = (RepositoryPO) ois.readObject();
				pos.add(po);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			// 读取到文件末尾，不需要处理
			System.out.println("End of file");
			try {
				ois.close();
			} catch (IOException e1) {
				System.out.println("Close error");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pos.iterator();
	}
}
