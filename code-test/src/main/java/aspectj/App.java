package aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by emirbobo on 2016/11/26.
 */
public class App {

    public static void main( String[] args ) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/spring.xml");
        PersonService personService = appContext.getBean(PersonService.class);
        String personName = "Jim";
        System.out.println(personService.addPerson(personName));
//        personService.deletePerson(personName);
//        personService.editPerson(personName);
        ((ClassPathXmlApplicationContext)appContext).close();
    }
}
