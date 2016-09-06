package util;

import java.io.*;

/**
 * Created by Administrator on 2016/9/6.
 */
public class UtilFile {
	public static byte[] getFileContent(String filePath) {
		File file = new File(filePath);
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			byte [] buffer = new byte[4096];
			int read = 0;
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			while ( ( read = is.read(buffer)) >= 0 )
			{
				if(read > 0)
					os.write(buffer,0,read);
			}
			is.close();
			os.close();
			return os.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean writeToFile(String filePath, byte[] data)
	{
		File file = new File(filePath);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(filePath);
			os.write(data);
			os.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
