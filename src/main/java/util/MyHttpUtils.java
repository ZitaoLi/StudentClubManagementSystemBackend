package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class MyHttpUtils {

	public static void getParameters(HttpServletRequest request) {
		System.out.println("HttpUtils");
		Enumeration paramNames = request.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            System.out.println("paramName: " + paramName + " | " + "paramValues" + paramValues.toString());
        }
	}
	
	public static String getJsonFromBody(HttpServletRequest request) {
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
			sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
}
