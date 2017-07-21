package com;

import java.util.HashMap;
import java.util.Map;

public class Model {

	private Map<String, Object> map = new HashMap<>();

	public void addAttribute(String key, Object value) {
		map.put(key, value);
	}

	public Object getAttribute(String key) {
		return map.get(key);
	}

}
