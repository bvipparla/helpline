package org.playload.helpline.base.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

	@Value("${org.helpline.localDateTimePattern:yyyy-MM-dd HH:mm:ss}")
	private String localDateTimePattern;

	@Override
	public LocalDateTime convert(String s) {
		return LocalDateTime.parse(s, ofPattern(localDateTimePattern));
	}
}
