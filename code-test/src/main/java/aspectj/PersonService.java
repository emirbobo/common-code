package aspectj;

import org.springframework.stereotype.Service;

/**
 * Created by emirbobo on 2016/11/26.
 */
@Service
public class PersonService {
    public String addPerson(Object personName) {
        System.out.println("add person " + personName.toString());
        return "addPerson success";
    }

    public boolean deletePerson(String personName) {
        System.out.println("delete person " + personName) ;
        return true;
    }

    public void editPerson(String personName) {
        System.out.println("edit person " + personName);
//        throw new RuntimeException("edit person throw exception");
    }
}
