package com.hkk.buyer.tools;

import org.springframework.stereotype.Component;

@Component
public class CommUtil {
	
	public static int null2Int(Object s){
		int v = 0;
		if(s != null){
			try {
				v = Integer.parseInt(s.toString());
			} catch (NumberFormatException e) {
			}
		}
		return v;
	}
	
	public static Long null2Long(Object s){
		Long v = -1l;
		if (s != null)
			try {
				v = Long.parseLong(s.toString());
			} catch (Exception e) {
			}
		return v;
	}

}
