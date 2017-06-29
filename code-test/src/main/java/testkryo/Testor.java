package testkryo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.collect.Maps;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.Data;
import util.TestModel;
import util.UtilFile;
import util.UtilLog;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Testor
{

	public static void test(){
		try{
			if(true) {
				throw new Exception();
			}
			System.out.println("111");
		}catch(Exception e){
			throw  new RuntimeException();
		}
	}

	public static void main(String[] args) {
		String json = "{\"roomNum\":\"asbs\",\"signals\":[{\"cmdCode\":101,\"messageId\":\"xxxxxxxxx\"},{\"cmdCode\":102,\"messageId\":\"xxxxxxxxx\"}]}";
//		TestModel testModel =JSONObject.parseObject(json,TestModel.class);
//		System.out.println(testModel);
		JSONObject jsonObject = JSONObject.parseObject(json);
		System.out.println(jsonObject.get("roomNum"));
		System.out.println(JSONObject.parseObject(jsonObject.getJSONArray("signals").get(0).toString()).get("cmdCode"));
		System.out.println(jsonObject.getJSONArray("signals").get(1));

		Map<String,String> test = Maps.newHashMap();
		jsonObject.getJSONArray("signals").forEach(e -> test.put(JSONObject.parseObject(e+"").get("cmdCode").toString(),JSONObject.parseObject(e+"").get("messageId").toString()));
		Set t = test.entrySet();
	}

	@Data
	public static class RoomNum{
		String roomNum;
	}

	private static void method(Integer a, Integer b) {
		try {
			Class<?> clazz = a.getClass();
			Field field = clazz.getDeclaredField("value");
			field.setAccessible(true);
			field.set(a, 100);
			field.set(b, 200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main1(String[] args) {
//		test();
		StringBuffer sb = new StringBuffer("123123");
		System.out.println(sb.deleteCharAt(sb.length()-1));

//		Testor testor = new Testor();
////		boolean needSerializeClassInfo = false;//是否存储类信息
//		boolean needSerializeClassInfo = true;//是否存储类信息
//		String filePath = "student.kryo."+ (needSerializeClassInfo ? "haveClassInfo" : "noClassInfo");
//		testor.testSerialize(needSerializeClassInfo,filePath);
//		testor.testReverseSerialize(needSerializeClassInfo,filePath);
	}

	private void testSerialize(boolean needSerializeClassInfo, String filePath) {
		Kryo kryo = new Kryo();
		// kryo.setReferences(true);
		// kryo.setRegistrationRequired(true);
		// kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
		// 注册类

		Output output = new Output(1, 4096);
		Student student = new Student("bush", "man", 26);
		if(needSerializeClassInfo)
			kryo.writeClassAndObject(output, student);
		else
			kryo.writeObject(output, student);

		byte[] bb = output.toBytes();
		UtilFile.writeToFile(filePath, bb);
	}

	private void testReverseSerialize(boolean needSerializeClassInfo, String filePath) {
		Kryo kryo = new Kryo();
		Input input = null;
		byte[] data = UtilFile.getFileContent(filePath);
		input = new Input(data);
		Student student = null;
		if(needSerializeClassInfo)
		{
			student = (Student) kryo.readClassAndObject(input);
		}
		else
		{
			student = (Student) kryo.readObject(input, Student.class);
		}
		UtilLog.log(student.getName() + "," + student.getSex()+ "," + student.getAge());
		input.close();
	}
}
