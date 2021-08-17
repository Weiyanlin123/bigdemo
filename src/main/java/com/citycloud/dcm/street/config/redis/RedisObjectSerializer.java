//package com.citycloud.dcm.street.config.redis;
//
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//import java.io.*;
//
///**
// * @author yvan
// * @version 1.0.0
// * @description redis关于Object类型存储序列化
// * @date 2019-11-02 14:00:00
// */
//public class RedisObjectSerializer implements RedisSerializer<Object> {
//
//    private static final byte[] EMPTY_ARRAY = new byte[0];
//
//    @Override
//    public Object deserialize(byte[] bytes) {
//        if (isEmpty(bytes)) {
//            return null;
//        }
//        ObjectInputStream oii;
//        ByteArrayInputStream bis;
//        bis = new ByteArrayInputStream(bytes);
//        try {
//            oii = new ObjectInputStream(bis);
//            return oii.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public byte[] serialize(Object object) {
//        if (object == null) {
//            return EMPTY_ARRAY;
//        }
//        ObjectOutputStream obi;
//        ByteArrayOutputStream bai;
//        try {
//            bai = new ByteArrayOutputStream();
//            obi = new ObjectOutputStream(bai);
//            obi.writeObject(object);
//            return bai.toByteArray();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private boolean isEmpty(byte[] data) {
//        return (data == null || data.length == 0);
//    }
//}
