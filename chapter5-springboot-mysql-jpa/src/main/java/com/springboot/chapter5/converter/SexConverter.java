package com.springboot.chapter5.converter;

import javax.persistence.AttributeConverter;

import com.springboot.chapter5.enumeration.SexEnum;

public class SexConverter implements AttributeConverter<SexEnum, Integer>{

	@Override
	public Integer convertToDatabaseColumn(SexEnum sex) {
		return sex.getId();
	}

	@Override
	public SexEnum convertToEntityAttribute(Integer id) {
		return SexEnum.getEnumById(id);
	}

}
