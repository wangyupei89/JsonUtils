package com.qunar.pay.g2.core.remit.util.serializer;


import com.qunar.pay.g2.core.remit.util.serializer.impl.JacksonSerializer;

/**
 * 序列化
 * 
 * @author yupei.wang
 *
 */
public class SerializerFactory {

    private static final Serializer DEFAULT = new JacksonSerializer();

    public static Serializer defaultSerializer() {
        return DEFAULT;
    }
}