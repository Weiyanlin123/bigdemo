package com.city.cloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Java中对JSONArray中的对象的某个字段进行排序
 *
 * @author lijianbo
 * @version 1.0
 */
public class TestJsonArraySort {

    public static void main(String[] args) {
        String jsonArrStr = "[\n" +
                "        {\n" +
                "            \"areaName\": \"上城区\",\n" +
                "            \"publicMS\": 0.49,\n" +
                "            \"totalMS\": 1096.77,\n" +
                "            \"commercialMS\": 1096.28\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"下城区\",\n" +
                "            \"publicMS\": 6.21,\n" +
                "            \"totalMS\": 2763.09,\n" +
                "            \"commercialMS\": 2756.88\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"江干区\",\n" +
                "            \"publicMS\": 0.53,\n" +
                "            \"totalMS\": 1497.87,\n" +
                "            \"commercialMS\": 1497.34\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"拱墅区\",\n" +
                "            \"publicMS\": 0.52,\n" +
                "            \"totalMS\": 1614.73,\n" +
                "            \"commercialMS\": 1614.21\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"西湖区\",\n" +
                "            \"publicMS\": 0.49,\n" +
                "            \"totalMS\": 2755.76,\n" +
                "            \"commercialMS\": 2755.27\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"滨江区\",\n" +
                "            \"publicMS\": 6.85,\n" +
                "            \"totalMS\": 2854.5,\n" +
                "            \"commercialMS\": 2847.65\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"萧山区\",\n" +
                "            \"publicMS\": 0.04,\n" +
                "            \"totalMS\": 207.75,\n" +
                "            \"commercialMS\": 207.71\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"余杭区\",\n" +
                "            \"publicMS\": 0.02,\n" +
                "            \"totalMS\": 130.22,\n" +
                "            \"commercialMS\": 130.2\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"富阳区\",\n" +
                "            \"publicMS\": 0.02,\n" +
                "            \"totalMS\": 114.03,\n" +
                "            \"commercialMS\": 114.01\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"临安区\",\n" +
                "            \"publicMS\": 0.01,\n" +
                "            \"totalMS\": 147.51,\n" +
                "            \"commercialMS\": 147.49\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"桐庐县\",\n" +
                "            \"publicMS\": 0.01,\n" +
                "            \"totalMS\": 0.01,\n" +
                "            \"commercialMS\": 0.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"淳安县\",\n" +
                "            \"publicMS\": 0.0,\n" +
                "            \"totalMS\": 0.0,\n" +
                "            \"commercialMS\": 0.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"areaName\": \"建德市\",\n" +
                "            \"publicMS\": 0.0,\n" +
                "            \"totalMS\": 0.0,\n" +
                "            \"commercialMS\": 0.0\n" +
                "        }\n" +
                "    ]";
        System.out.println("排序前：" + jsonArrStr);
        String jsonArraySort = jsonArraySort(jsonArrStr);
        System.out.println("排序后：" + jsonArraySort);
    }

    /**
     * 按照JSONArray中的对象的某个字段进行排序(采用fastJson)
     *
     * @param jsonArrStr json数组字符串
     */
    public static String jsonArraySort(String jsonArrStr) {
        JSONArray jsonArr = JSON.parseArray(jsonArrStr);
        JSONArray sortedJsonArray = new JSONArray();
        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < jsonArr.size(); i++) {
            jsonValues.add(jsonArr.getJSONObject(i));
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>() {
            // You can change "Name" with "ID" if you want to sort by ID
            private static final String KEY_NAME = "totalMS";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Long valA = new Long(0);
                Long valB = new Long(0);
                try {
                    // 这里是a、b需要处理的业务，需要根据你的规则进行修改。
                     valA = a.getLong(KEY_NAME);
                     valB = b.getLong(KEY_NAME);
                } catch (JSONException e) {
                    // do something
                }
                return -valA.compareTo(valB);
                // if you want to change the sort order, simply use the following:
                // return -valA.compareTo(valB);
            }
        });
        for (int i = 0; i < jsonArr.size(); i++) {
            sortedJsonArray.add(jsonValues.get(i));
        }
        return sortedJsonArray.toString();
    }

}
