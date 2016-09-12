package lsy.app.http.task;

import lsy.app.http.pack.Pack;
import lsy.app.http.pack.PackCommon;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 * http���񣬷���һ��������
 */
public abstract class Task {
	private boolean finish = false;

	public Task() {

	}

	List<Pack> packs = new ArrayList<>();//��������
	int curPackIndex = 0;

	public boolean isFinish() {
		return finish;
	}


	/**
	 * �ڰ�����ĩβ��ӷ���
	 * @param packArr
	 */
	public void appendPack(Pack... packArr) {
		if(packArr != null && packArr.length > 0)
		{
			for(Pack pack : packArr)
				packs.add(pack);
		}
	}

	public Pack nextPack() {
		if(finish)
			return null;
		Pack pack = null;
		if(curPackIndex >= 0 && curPackIndex < packs.size())
		{
			pack = packs.get(curPackIndex);
			curPackIndex++;
//			if(curPackIndex == packs.size())//�˴�����鵱ǰ�Ƿ����һ��������������п��ܻ������µķ���
//				finish = true;
		}
		else
			finish = true;
		return pack;
	}

	public static Task createCommonTask(PackCommon... packArr)
	{
		TaskCommon task = new TaskCommon();
		task.appendPack(packArr);
		return task;
	}
}
