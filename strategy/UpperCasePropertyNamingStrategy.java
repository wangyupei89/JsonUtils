package com.qunar.pay.g2.core.remit.util.serializer.strategy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;

/**
 * 适配策略(将属性大写)
 * 
 * @author yupei.wang
 *
 */
public class UpperCasePropertyNamingStrategy extends PropertyNamingStrategyBase {

	private static final long serialVersionUID = 1L;

	@Override
	public String translate(String propertyName) {
		return propertyName.toUpperCase();
	}
}