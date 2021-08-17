package com.citycloud.dcm.street.util;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.geotools.geometry.jts.JTSFactoryFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GisCommUtils {

    private static GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
    private static double MIN_BUF = 0.0000001;

    public static Boolean isInShape(String shape, double lon, double lat, boolean isChange) {
        boolean flag = false;
        WKTReader reader = new WKTReader(geometryFactory);
        String shapedata = null;
        Polygon polygon = null;
        Coordinate p1 = new Coordinate(lon, lat);
        Point point = geometryFactory.createPoint(p1);
        try {
            if (isChange) {
                int it = shape.indexOf("type\":\"");
                if (shape.indexOf("[[[[") >= 0 && shape.indexOf("]]]]") > 0) {
                    if ("MultiPolygon".equals(shape.substring(it + 7, it + 19))) {
                        int n = (shape.length() - shape.replaceAll("]]]", "").length()) / 3;
                        if (n > 0) {
                            Map map = new HashMap<Integer, String>(50);
                            int a = shape.indexOf("[[[");//*第一个出现的索引位置
                            int a1 = 0;
                            while (a != -1) {
                                a = shape.indexOf("[[[", a + 1);//*从这个索引往后开始第一个出现的位置
                                map.put(a1, a);
                                a1++;
                            }
                            int a2 = 0;
                            int b = shape.indexOf("]]]");//*第一个出现的索引位置
                            while (b != -1) {
                                b = shape.indexOf("]]]", b + 1);//*从这个索引往后开始第一个出现的位置
                                if (a2 == n - 1) {
                                    map.put(a2, map.get(a2).toString() + "," + (b + 2));
                                } else {
                                    map.put(a2, map.get(a2).toString() + "," + (b + 3));
                                }
                                a2++;
                            }
                            for (int i = 0; i < n; i++) {
                                String bn = map.get(i).toString();
                                String s = shape.substring(Integer.parseInt(bn.split(",")[0]), Integer.parseInt(bn.split(",")[1]));
                                shapedata = comm(s);
                                polygon = (Polygon) reader.read(shapedata);
                                flag = point.within(polygon);
                                if (flag) {
                                    break;
                                }
                            }
                        }

                    }
                } else {
                    if (shape.indexOf("[[[") >= 0 && shape.indexOf("]]]") > 0) {
                        shapedata = comm(shape);
                        polygon = (Polygon) reader.read(shapedata);
                        flag = point.within(polygon);
                    }
                }
            } else {
                polygon = (Polygon) reader.read(shape);
                flag = point.within(polygon);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean isInMulShape(List<String> shapes, double lon, double lat) {
        boolean flag = false;
        WKTReader reader = new WKTReader(geometryFactory);
        String shapedata = "MULTIPOLYGON((";
        for (String s : shapes) {
            if ("MULTIPOLYGON((".equals(shapedata)) {
                shapedata += comm(s).replace("POLYGON(", "").replace("))", ")");
            } else {
                shapedata += "," + comm(s).replace("POLYGON(", "").replace("))", ")");
            }
        }
        shapedata += "))";
        MultiPolygon polygons = null;
        Coordinate p1 = new Coordinate(lon, lat);
        Point point = geometryFactory.createPoint(p1);
        try {
            polygons = (MultiPolygon) reader.read(shapedata);
            flag = point.within(polygons);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static String comm(String shape) {
        String zj = shape.substring(shape.indexOf("[[["), shape.indexOf("]]]") + 3).replace("[[[", "POLYGON((").replace("]]]", "))").replace("],[", "-").replace(",", " ").replace("-", ",");
        String zj1 = zj.substring(zj.indexOf("((") + 2, zj.indexOf(","));
        return zj.replace("))", "," + zj1 + "))");
    }

    public static void main(String[] args) {
        double lon = 120.27775076700004;
        double lat = 30.31299173900004;
        String shape1 = "{\"coordinates\":[[[120.27775076700004,30.31299173900004],[120.27770423200002,30.312992088000044],[120.27770417200009,30.313006596000037],[120.27775056400003,30.313006220000034],[120.27775076700004,30.31299173900004]]],\"type\":\"Polygon\"}";
        Boolean inShape = isInShape(shape1, lon, lat, true);
        System.out.println(inShape);
    }

    /**
     * 轨迹分段
     *
     * @param oldPlaceVos 所有轨迹
     * @param spliteMins  按时间长度分段,单位:分钟
     * @return 分段集合
     */
/*    private List<List<VehicleGpsVo>> splitTrajectory(List<VehicleGpsVo> oldPlaceVos, Integer spliteMins) {
        List<List<VehicleGpsVo>> resultLists = new ArrayList<>();
        ArrayList<VehicleGpsVo> current = new ArrayList<>();
        resultLists.add(current);
        VehicleGpsVo last = null;
        for (VehicleGpsVo oldPlace : oldPlaceVos) {
            if (null == oldPlace.getGpsRealtime() || oldPlace.getLongitude() == null || oldPlace.getLatitude() == null) {
                continue;
            }
            if (last == null) {
                current.add(oldPlace);
            } else {
                Date tTime0 = last.getGpsRealtime();
                Date tTime1 = oldPlace.getGpsRealtime();
                if ((tTime1.getTime() - tTime0.getTime()) > (1000 * 60 * spliteMins)) {
                    // 新的轨迹段
                    current = new ArrayList<>();
                    current.add(oldPlace);
                    resultLists.add(current);
                } else {// 否则
                    current.add(oldPlace);
                }
            }
            last = oldPlace;

        }
        Iterator<List<VehicleGpsVo>> iterator = resultLists.iterator();
        ArrayList<List<VehicleGpsVo>> resultList = new ArrayList<>();

        while (iterator.hasNext()) {
            List<VehicleGpsVo> next = iterator.next();
            if (next.size() > 1) {
                resultList.add(next);
            }
        }
        return resultList;
    }*/

}
