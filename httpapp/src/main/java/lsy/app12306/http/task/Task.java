package lsy.app12306.http.task;

import lsy.app12306.http.pack.Pack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 * http任务，发送一个包序列
 */
public abstract class Task {
	private boolean finish = false;

	public Task() {

	}

	List<Pack> packs = new ArrayList<>();//发包序列
	int curPackIndex = 0;

	public boolean isFinish() {
		return finish;
	}


	/**
	 * 在包序列末尾添加发包
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
//			if(curPackIndex == packs.size())//此处不检查当前是否最后一个包，处理过程中可能会增加新的发包
//				finish = true;
		}
		else
			finish = true;
		return pack;
	}
}
