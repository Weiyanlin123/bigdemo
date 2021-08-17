package com.city.stream;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.citycloud.dcm.street.param.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author weiyl
 * @date 2020/9/7 15:11
 */
public class Studenttest {

    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        List<Person> list2 = new ArrayList<>();
//        Person p = new Person(1, "小明", 0);
//        Person p2 = new Person(2, "小红", 0);
//        Person p3 = new Person(3, "老王", 0);
//        list.add(p);
//        list.add(p2);
//        list.add(p3);
//        Person p4 = new Person(1, null, 10);
//        Person p5 = new Person(2, null, 20);
//
//        list2.add(p4);
//        list2.add(p5);
//
//        list.stream().flatMap(x -> list2.stream().filter(
//                y -> x.getId() == y.getId() && x.getAge() == 0 && y.getName() == null)
//                .map(y -> new Person(x.getId(), x.getName(), y.getAge()))
//        ).collect(Collectors.toList()).forEach(m -> System.out.println(m));


            Map<String, String> headers =new HashMap<String,String>();
            headers.put("accesstoken","8f3a3962-9dda-4afa-8cbd-d580f73ef363");
            JSONArray array = new JSONArray();
            array.add("GE_b7c3142c0ff247cdaab435bb8062654f");
            array.add("GE_3e58fe20039b4f63b19ab974b71eddfa");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("employeeCodes",array);
            jsonObject.put("msgContent","你好");
            String res = HttpUtil.createPost("http://10.10.70.185:8082/zzdapp/notice/sendToPersons").addHeaders(headers).body(jsonObject.toJSONString()).timeout(5000).execute().body();
            System.out.println(jsonObject.toJSONString());
//            String resultRegister = HttpRequest.post("http://10.10.77.160:8082/zzdapp/notice/sendToPersons")
//                    .header("accesstoken", "8f3a3962-9dda-4afa-8cbd-d580f73ef363")// token鉴权
//                    .body(jsonObject.toJSONString()).timeout(5000)
//                    .execute().body();
            System.out.println("+++++++++++++++"+res);

    }

}
