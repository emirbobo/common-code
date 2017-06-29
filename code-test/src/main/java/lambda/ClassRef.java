package lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Mtime on 2016/12/12.
 */
public class ClassRef {


    public static void main(String []args){
        ClassRef cr = new ClassRef();
        Person [] persons = new Person[]{cr.new Person("a",11),cr.new Person("b",12),cr.new Person("c",13),cr.new Person("d",14)};
        Comparator<Person> cp = Comparator.comparing(p -> p.getName());
        Arrays.sort(persons,cp);
    }

    class Person{

        public Person(String name,int age){
            this.name = name;
            this.age = age;
        }

        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
