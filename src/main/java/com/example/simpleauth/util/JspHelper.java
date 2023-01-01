package com.example.simpleauth.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {

	private static final String JSP_FORMAT = "/%s.jsp";

	public static String getPath(String jspName) {

		return String.format(JSP_FORMAT, jspName);
	}
}
