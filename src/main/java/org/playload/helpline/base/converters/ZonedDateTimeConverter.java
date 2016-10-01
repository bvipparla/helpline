package org.playload.helpline.base.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class ZonedDateTimeConverter implements Converter<String, ZonedDateTime> {

	@Value("${org.helpline.zonedDateTimePattern:yyyy-MM-dd'T'HH:mm:ssZZZ}")
	private String zonedDateTimePattern;

	@Override
	public ZonedDateTime convert(String s) {
		return ZonedDateTime.parse(s, ofPattern(zonedDateTimePattern));
	}
}
