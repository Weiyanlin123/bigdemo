package com.citycloud.dcm.street.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class AreaSortUtil {

    private static String[] area = new String[]{"上城区", "下城区", "江干区", "拱墅区", "西湖区", "西湖景区", "滨江区", "钱塘新区", "萧山区", "余杭区", "富阳区", "临安市", "建德市","桐庐县","淳安县"};
    private static String[] mainArea = new String[]{"上城区", "下城区", "江干区", "拱墅区", "西湖区", "西湖景区", "滨江区", "钱塘新区"};
    private static String[] urbanArea = new String[]{"萧山区", "余杭区", "富阳区", "临安市", "桐庐市", "建德市", "桐庐县","淳安县"};

    public static void main(String[] args) {
        Map map = new <String, Object>HashMap();
        map.put("上城区", 1);
        map.put("江干区", 1);
        map.put("下城区", 1);
        map.put("拱墅区", 1);
        map.put("西湖区", 1);
        map.put("西湖景区", 1);
        map.put("滨江区", 1);
        map.put("钱塘新区", 1);
        map.put("余杭区", 2);
        map.put("富阳区", 2);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("area", "上城区");
        jsonObject.put("total", 1);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("area", "江干区");
        jsonObject1.put("total", 1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("area", "西湖区");
        jsonObject2.put("total", 1);


        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("area", "滨江区");
        jsonObject3.put("total", 1);


        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("area", "余杭区");
        jsonObject4.put("total", 1);

        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("area", "桐庐县");
        jsonObject5.put("total", 2);

        JSONArray array = new JSONArray();
        array.add(jsonObject);
        array.add(jsonObject1);
        array.add(jsonObject2);
        array.add(jsonObject3);
        array.add(jsonObject4);
        array.add(jsonObject5);
        JSONArray totalArrayList = new JSONArray();
        for (int j=0;j<area.length;j++) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject cell = array.getJSONObject(i);
                cell.getInteger("total");
                if(cell.getString("area").contains(area[j])){
                    LinkedHashMap<String, Object> totalData = new LinkedHashMap<>();
                    totalData.put("area",cell.getString("area"));
                    totalData.put("total",cell.getInteger("total"));
                    totalArrayList.add(totalData);
                }
            }
        }
        System.out.println("+++++++++++++++" + totalArrayList);
    }

    private static JSONObject getMainOrUrbanSortAndSumData(Map<String, Object> map) {
        String key = null;
        Integer total = 0;
        LinkedHashMap<String, Object> totalData = new LinkedHashMap<>();
        LinkedHashMap<String, Object> mainData = new LinkedHashMap<>();
        LinkedHashMap<String, Object> urbanData = new LinkedHashMap<>();
        for (int i = 0; i < area.length; i++) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (key.contains(area[i])) {
                    totalData.put(area[i], map.get(key));
                    total = total + (Integer) map.get(key);
                }
            }
        }

        Integer sum = 0;
        for (int i = 0; i < mainArea.length; i++) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (key.contains(mainArea[i])) {
                    mainData.put(mainArea[i], map.get(key));
                    sum = sum + (Integer) map.get(key);
                }
            }
        }
        Integer urbansum = 0;
        for (int j = 0; j < urbanArea.length; j++) {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                key = (String) iterator.next();
                if (key.contains(urbanArea[j])) {
                    urbanData.put(urbanArea[j], map.get(key));
                    urbansum = urbansum + (Integer) map.get(key);
                }
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mainCount", sum);
        jsonObject.put("urbanCount", urbansum);
        jsonObject.put("Count", total);
        jsonObject.put("totalData", totalData);
        jsonObject.put("mainData", mainData);
        jsonObject.put("urbanData", urbanData);

        return jsonObject;
    }

}
