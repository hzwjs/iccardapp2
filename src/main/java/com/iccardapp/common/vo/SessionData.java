package com.iccardapp.common.vo;




import java.util.HashMap;
import java.util.Map;

public class SessionData {

	private static final ThreadLocal<Map<String, Object>> SESSION_DATA = new ThreadLocal<Map<String, Object>>() {

		@Override
		protected Map<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}

	};

	public static void add(String key, Object value) {
		SESSION_DATA.get().put(key, value);
	}

	public static Object get(String key) {
		return SESSION_DATA.get().get(key);
	}

}
