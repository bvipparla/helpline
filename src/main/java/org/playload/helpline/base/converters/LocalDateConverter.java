package org.playload.helpline.base.converters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

	@Value("${org.helpline.localDatePattern:yyyy-MM-dd}")
	private String localDatePattern;

	@Override
	public LocalDate convert(String s) {
		return LocalDate.parse(s, ofPattern(localDatePattern));
	}
}
