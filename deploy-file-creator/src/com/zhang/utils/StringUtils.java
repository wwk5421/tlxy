package com.zhang.utils;

public class StringUtils {

	public static boolean isStrOrObjectNull(String str) {
		return str == null || str.equals("") || str.trim().equals("");
	}
	
	public static boolean isStrObjBlank(String str) {
		return str == null || str.equals("") || str.trim().equals("");
	}
}
