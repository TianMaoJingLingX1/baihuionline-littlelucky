package com.baihuionline.usercenter.chat.util;

import com.baihuionline.usercenter.chat.entity.User;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * protostuff序列化工具与类，基于protobuf封装
 */
public class ProtostuffUtil {
    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

    private static <T> Schema<T> getScheme(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if(schema == null) {
            schema = RuntimeSchema.getSchema(clazz);
            if (schema != null) {
                cachedSchema.put(clazz, schema);
            }
        }
        return schema;
    }

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serializer(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> scheme = getScheme(clazz);
            return ProtostuffIOUtil.toByteArray(obj, scheme, buffer);
        }  finally {
            buffer.clear();
        }
    }


    public static <T> T deserializer(byte[] data, Class<T> clazz) {
        try {
            T obj = clazz.newInstance();
            Schema<T> scheme = getScheme(clazz);
            ProtostuffIOUtil.mergeFrom(data, obj, scheme);
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        byte[] userBytes = ProtostuffUtil.serializer(User.builder().age(3).name("测试人员"));
        User user = ProtostuffUtil.deserializer(userBytes, User.class);
        System.out.println(user);
    }
}
