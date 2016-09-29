package testkryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import util.UtilFile;
import util.UtilLog;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Testor
{
	public static void main(String[] args) {
		Testor testor = new Testor();
//		boolean needSerializeClassInfo = false;//是否存储类信息
		boolean needSerializeClassInfo = true;//是否存储类信息
		String filePath = "student.kryo."+ (needSerializeClassInfo ? "haveClassInfo" : "noClassInfo");
		testor.testSerialize(needSerializeClassInfo,filePath);
		testor.testReverseSerialize(needSerializeClassInfo,filePath);
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
