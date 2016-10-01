package org.playload.helpline.base.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class LocalTimeConverter implements Converter<String, LocalTime> {

	@Value("${org.helpline.localTimePattern:HH:mm:ss}")
	private String localTimePattern;

	@Override
	public LocalTime convert(String s) {
		return LocalTime.parse(s, ofPattern(localTimePattern));
	}
}
