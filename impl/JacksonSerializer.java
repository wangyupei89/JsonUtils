package com.qunar.pay.g2.core.remit.util.serializer.impl;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.qunar.pay.g2.core.remit.util.serializer.Serializer;
import com.qunar.pay.g2.core.remit.util.serializer.strategy.UpperCasePropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Jackson序列化
 * 
 * @author yupei.wang
 * 
 */
public class JacksonSerializer implements Serializer {
	
	private static final Logger logger = LoggerFactory.getLogger(JacksonSerializer.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();		// 线程安全(官方:can reuse, share globally)

	static {

		/**
		 * 序列化的规则
		 */
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.disable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        mapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.setPropertyNamingStrategy(new UpperCasePropertyNamingStrategy());
	}

	@Override
	public String serialize(Object data) {
		try {
			return mapper.writeValueAsString(data);
		} catch (IOException e) {
			logger.error("serialize data error", e);
			return null;
		}
	}

	@Override
	public <T> T deSerialize(String content, Class<T> clazz) {
		try {
			return mapper.readValue(content, clazz);
		} catch (IOException e) {
			logger.error("deserialize object error: {}", content, e);
			return null;
		}
	}

}