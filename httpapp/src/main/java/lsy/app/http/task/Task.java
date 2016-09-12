package lsy.app.http.task;

<<<<<<< HEAD:httpapp/src/main/java/lsy/app12306/http/task/Task.java
import lsy.app12306.http.pack.Pack;
import lsy.app12306.http.pack.PackCommon;
=======
import lsy.app.http.pack.Pack;
>>>>>>> ef0dc8290826d8fc932ddb71b112d8b710c25e32:httpapp/src/main/java/lsy/app/http/task/Task.java

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

	public static Task createCommonTask(PackCommon ... packArr)
	{
		TaskCommon task = new TaskCommon();
		task.appendPack(packArr);
		return task;
	}
}
