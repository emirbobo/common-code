package lsy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.ConsoleUtil;

/**
 * Created by Administrator on 2014/9/2.
 */
public class LocalTest
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
        ConsoleUtil.info("manager : " + manager);
        applicationContext.destroy();
    }
}
