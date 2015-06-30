package com.qunar.pay.g2.core.remit.util.serializer;

/**
 * 自定义序列化(提高序列化性能)
 * 
 * @author yupei.wang
 * 
 */
public interface Serializer {

	String serialize(Object data);

	<T> T deSerialize(String content, Class<T> clazz);
}