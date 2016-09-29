package lsy;

import lsy.util.UtilConsole;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2014/9/10.
 */
public class Launcher
{
    public static void main(String[] args) {
        String [] xmlConfigs = new String[]
                {
                        "applicationContext-entity.xml"
                        ,"applicationContext-jpa.xml"
                        ,"applicationContext-misc.xml"
                        ,"applicationContext-schedule.xml"
                        ,"applicationContext-struts.xml"
                };
        String [] absXmlConfigs = new String[xmlConfigs.length];
        int i = 0;
        for(String xmlFile : xmlConfigs)
        {
            absXmlConfigs[i] = "E:\\work\\quiz\\webroot\\WEB-INF\\conf\\"+xmlFile;
            i++;
        }
        String [] xmls = new String[]{
                "applicationContext.xml"
        };
//        FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(absXmlConfigs);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmls);
        Manager manager = (Manager) applicationContext.getBean("manager");
        UtilConsole.info("manager : " + manager);
        applicationContext.destroy();
    }
}
