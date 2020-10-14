package test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 11:04 上午
 * @Version 1.0
 */
public class MapTest {

    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>(16);
        for (int i = 0; i < 10; i++) {
            Map<String,Object> map = new HashMap<>(16);
            map.put("key1", UUID.randomUUID());
            map.put("key2",UUID.randomUUID());
            list.add(map);
        }

        List<Map> key1 = list.stream().map(map -> {
            Map map1 = new HashMap(16);
            map1.putAll(map);
            map1.put("key1", 111);
            return map1;
        }).collect(Collectors.toList());

        System.out.println(key1);
        System.out.println(list);

    }
}
