package com.dlyong.java8demo;

import com.dlyong.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * streams
 * @author dlyong
 */
public class StreamsDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "pear", "banana");
        list.forEach(System.out::println);

        // 利用Streams filter() and collect()
        // 1.转换成流
        // 2. 过滤
        // 3.流转换成集合
        List<String> result = list.stream()
                .filter(item -> !item.contentEquals("banana"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        // 利用Streams findAny() and orElse()

        List<Person> personList = Arrays.asList(
                new Person("dlyong", 25),
                new Person("wxh", 22),
                new Person("buding", 2)
        );

        Person person = personList.stream()
                .filter(item -> "dlyong".equals(item.getName()) && 25 == item.getAge())
                .findAny()
                .orElse(null);
        System.out.println(person);

        // 利用Streams filter() and orElse()

        String person1 = personList.stream()
                .filter(item -> {
                    if ("dlyong".equals(item.getName()) && 25 == item.getAge()) {
                        return true;
                    } else {
                        return false;
                    }
                }).map(Person::getName)
                .findAny()
                .orElse("查无此人");
        System.out.println(person1);


        List<String> stringList = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(stringList);






    }
}
