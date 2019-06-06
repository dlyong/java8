package com.dlyong.java8demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java8 foreach
 * @author dlyong
 * @date 20190606
 */
public class ForeachDemo {

    public static void main(String[] args) {
        // map
        Map<Integer,Object> map = new HashMap<>(5);
            map.put(1,"banana");
            map.put(2,"apple");
            map.put(3,"pear");
            map.put(4,"xigua");
            map.put(5,"caomei");
         map.forEach((k,v)->{
             System.out.println("key:"+k+" value:"+v);
         });
        // list
        List<String> list = new ArrayList<>();
            list.add("banana");
            list.add("apple");
            list.add("pear");
            list.add("xigua");
            list.add("caomei");
         // 第一种
         list.forEach((item)->{
             System.out.println(item);
             // if判断
         });
        list.forEach((item)-> System.out.println(item));
        list.forEach(System.out::println);
        list.forEach(System.out::println);
        // 第二种 stream filter  过滤
        // out bnanana
        list.stream()
                .filter(s -> s.contentEquals("banana"))
                .forEach(System.out::println);
    }

}
