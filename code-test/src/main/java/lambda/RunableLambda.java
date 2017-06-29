package lambda;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.sf.cglib.core.CollectionUtils;

import java.util.List;

/**
 * Created by Mtime on 2016/12/8.
 */
public class RunableLambda {

    public static void main(String [] args){
        List<String> s1 = Lists.newArrayList();
        s1.add("1");
        s1.add("2");
        s1.add("3");

        List<String> strings = Lists.newArrayList(Collections2.filter(s1,new Predicate<String>() {

            @Override
            public boolean apply(String s) {
                return s.equals("1");
            }
        }));

        List<String> s2 = Lists.newArrayList();
        s2.add("a");
        s2.add("b");
        s2.add("c");
        strings.forEach(System.out::println);
        strings = s2;
        strings.forEach(System.out::println);


        Supplier<Runnable> c = () -> () ->  System.out.println("hi");
        c.get().run();
//        Runnable r = () -> System.out.println("runnable lambda");String a = "";
//        r.run();
        LambdaInterface l = (a,b) ->  a+b;
//        System.out.println(l.sum(1,2));
        LambdaSum.sum(1,2,l);
        List <Integer>a = Lists.newArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.forEach(System.out::println);

        System.out.println(a.stream().mapToInt( e -> e).sum());

         Lists.transform(a,(e) -> String.valueOf(e)).forEach(System.out::println);

//        newList.forEach(System.out::println);
    }

}
