//package com.city.cloud;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class TestStream {
//
//    public static void main(String[] args) {
////        Stream.of("apple","banana","orange","waltermaleon","grape")
////                .map(e->e.length()) //转成单词的长度 int
////                .forEach(e->System.out.println(e)); //输出
////
////
////        Optional<String> stringOptional = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
////                .parallel()
////                .findAny(); //在并行流下每次返回的结果可能一样也可能不一样
////        stringOptional.ifPresent(e->System.out.println(e));
////
////
////     Stream.of("1","2").forEach(e->System.out.println(e));
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        list.add(5);
//
//        Stream.of(1,2,3,1)
//                .collect(Collectors.toCollection(HashSet::new)).forEach(e->{
//
////                    if(e.equals(1)){
////                        System.out.println(e);
////                    }
//            System.out.println(e);
//        });
//
//
//        OptionalInt first = IntStream.of( 2, 3, 4).findFirst();
//        first.ifPresent(e->{System.out.println(e);});
//        boolean present = first.isPresent();
//        if(present){
//            System.out.println(first.getAsInt());
//        }
//
//
//        Stream.of(1,2,3,45,57,53).sorted().forEach(e->{
//            System.out.println(e);
//        });
//
//        list.forEach(e->{
//            System.out.print(e);
//        });
////
////        Stream.of("apple","banana","orange","waltermaleon","grape")
////                .map(String::length) //转成单词的长度 int
////                .forEach(System.out::println);
//
//        Stream.of(0,9,8,4,5,6,-1)
//                .sorted().forEach(e->{System.out.print(e);});
//
//
//        HashMap<String,Integer> hashMap = new HashMap();
//        hashMap.put("key",2);
//        HashMap<String,Integer>  hashMap1 = new HashMap();
//        hashMap1.put("key",1);
//        HashMap<String,Integer>  hashMap2 = new HashMap();
//        hashMap2.put("key",3);
//
//        Stream.of(hashMap,hashMap1,hashMap2).sorted((e1,e2)->e1.get("key")>e2.get("key")?0:e1.get("key")==e2.get("key")?1:-1).forEach(e->{
//            System.out.println(e);
//        });
//
//
//
//
//    Stream.of("1","2","3","4").collect(Collectors.toList()).forEach(e->{
//        System.out.println("++++++++++++++++++++"+e);
//    });
//
//
//
//
//
//    }
//}
