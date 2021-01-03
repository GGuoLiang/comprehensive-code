package test;

import com.gguoliang.entity.Man;
import com.gguoliang.entity.Pair;
import com.gguoliang.entity.Person;
import org.junit.Test;

import java.util.*;

/**
 * @Author GGuoLiang
 * @Date 2021/1/2 8:43 下午
 * @Version 1.0
 */
public class WildcardTest {

    public static void main(String[] args) {

        List<String> list
                 = new ArrayList<>();
        addAll(list);

        Set<String> set = new HashSet<>(16);
        addAll(set);

        /// 上界通配符

        List<Man> manList = new ArrayList<>();
        count(manList);
        List<Person> personList = new ArrayList<>();
        count(personList);

        count3(manList);
        count3(personList);
        List<Object> list1 = new ArrayList<>();
        count3(list1);
        //count3(list);


    }

    public static void addAll(Collection<?> collection){


    }


    public static void count(Collection< ? extends Person> collection){

    }

    public static void count2(Collection< Person> collection){

    }

    public static void count3(Collection<? super Man> collection){

    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }



    @Test
    public void test1(){

        com.gguoliang.generic.Pair<String> pair = new com.gguoliang.generic.Pair<>("AA","bb");
        System.out.println(pair.toString());

    }
}
