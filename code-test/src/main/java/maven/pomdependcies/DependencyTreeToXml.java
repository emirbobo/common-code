package maven.pomdependcies;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/2.
 */
public class DependencyTreeToXml
{
	public static void main(String[] args) {
		DependencyTreeToXml o = new DependencyTreeToXml();
		o.execute();
	}

	private void execute() {
		JFileChooser chooser = new JFileChooser();
		chooser.setApproveButtonText("确定");
		//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  //设置只选择目录
		chooser.setCurrentDirectory(new File("."));
		int returnVal = chooser.showOpenDialog(null);//SwingWorkerUI.this);
		System.out.println("returnVal="+returnVal);
		if (returnVal != JFileChooser.APPROVE_OPTION)
			return;
		File file = chooser.getSelectedFile();
		File dir = file.getParentFile();
		if(file.getName().toLowerCase().equals("pom.xml"))
		{//选择pom，则执行 "mvn dependency:tree " 获得输出
			Runtime runtime = Runtime.getRuntime();
			try {
				String[] commands = new String[]{"mvn.cmd","dependency:tree"};
				Process process = runtime.exec(commands,null,dir);
//				Process process = runtime.exec("mvn.cmd dependency:tree",null,dir);
//				Process process = runtime.exec("dir",null,dir);
				InputStream is = process.getInputStream();
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int read;
				while ( (read = is.read()) >= 0)
				{
					if(read > 0)
					{
						os.write(buf,0,read);
					}
				}
				os.close();
				log("output : "+new String(os.toByteArray()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());
		}
	}

	private void log(String s) {
		System.out.println(s);
	}
}
