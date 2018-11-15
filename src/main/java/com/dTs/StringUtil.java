package com.dTs;

public class StringUtil {

	public static String tick(String str) {

		while (str.startsWith(" "))
			str = str.substring(1);
		while (str.endsWith(" "))
			str = str.substring(0, str.length() - 1);

		return str;
	}

	public static boolean isEmpty(String str) {
		
		return null == str || str.equals("");
	}
}
