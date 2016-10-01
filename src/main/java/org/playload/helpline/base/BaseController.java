package org.playload.helpline.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

public abstract class BaseController {
	public Map<String, String> getParams(HttpServletRequest request) {
		Enumeration<String> names = request.getParameterNames();
		Map<String, String> params = new HashMap<>();

		while (names.hasMoreElements()) {
			String string = names.nextElement();
			params.put(string, request.getParameter(string));
		}

		return params;
	}

	protected Pageable prePageable(Integer pageNumber, Integer pageSize, Sort sort) {
		if ((pageNumber == null) || (pageSize == null) || (pageNumber < 0) || (pageSize < 0)) {
			return null;
		}

		if (sort == null) {
			return new PageRequest(pageNumber - 1, pageSize);
		} else {
			return new PageRequest(pageNumber - 1, pageSize, sort);
		}
	}

	protected Sort preSort(String direction, String field) {
		if (StringUtils.hasText(field)) {
			if (StringUtils.hasText(direction)) {

				Sort.Direction dir = Sort.Direction.ASC;
				if (direction.equalsIgnoreCase("A") || direction.equalsIgnoreCase("ASC")) {
					dir = Sort.Direction.ASC;
				} else if (direction.equalsIgnoreCase("D") || direction.equalsIgnoreCase("DESC")) {
					dir = Sort.Direction.DESC;
				}
				return new Sort(dir, field);
			} else {
				return new Sort(field);
			}
		} else {
			return null;
		}
	}

} // end class BaseController
