package com.city.testmap;

import com.city.cloud.B;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author weiyl
 * @date 2021/3/8 13:42
 */
public class TestMap {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        stringBuffer.append("2");
        System.out.println(stringBuffer.toString());
        B b = new B();

        b.setAge("aaa");
        b.setName("bbb");
        B c = new B();

        c.setAge("aaa");
        c.setName("bbb");

        System.out.println("b.equal c"+b.equals(c));

        HashMap<B, Object> temp = new HashMap<>();

        temp.put(c,"1");
        temp.put(b,"1");

        System.out.println(temp);

        // 创建map
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("aaa", 12);
        maps.put("bbb", 1);
        maps.put("ccc", 22);
        // 输出 初始化后的map
        maps.forEach((k, v) -> {
            System.out.println("原始map:" + k + "->" + v);
        });
//        maps = maps
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer> comparingByValue()
//                        .reversed())
//                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));
//


        HashSet<Object> objects = new HashSet<>();

        objects.add(1);

        List<Map.Entry<String, Integer>> listMap = maps
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue()
                        .reversed()).collect(Collectors.toList());


        // 排序完后返回list
        listMap.forEach(e -> {
            System.out.println("排序完后返回List<Entry<String, Integer>>:"
                    + e.getKey() + "->" + e.getValue());
        });









        // key值排序
        List<String> list = maps.keySet().stream()
                .sorted((c1, c2) -> c2.compareTo(c1))
                .collect(Collectors.toList());
        maps.forEach((k, v) -> {
            System.out.println("排序完后返回map:" + k + "->" + v);
        });
        list.forEach(e -> {
            System.out.println("key值单独排序返回list<String>:" + e);
        });

        // 排序完后返回Iterator
        Iterator<Map.Entry<String, Integer>> entryIterator = maps
                .entrySet()
                .stream()
                .filter(e -> StringUtils.isNotBlank(e.getKey()))
                .sorted(Map.Entry.<String, Integer> comparingByValue()
                        .reversed()).iterator();// 排序
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> o = entryIterator.next();
            System.out.println("排序完后返回迭代器:" + o.getKey() + "->" + o.getValue());

        }
    }

}
