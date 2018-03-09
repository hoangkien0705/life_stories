package com.kienhv.stories.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private SimpleDateFormat fomat;
	private static DateUtils instance;
	
	public static DateUtils getInstance() {
		if(instance == null) {
			instance = new DateUtils();
		}
		return instance;
	}
	
	private DateUtils() {
		fomat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	public Date convertStringToDate(String strDate) {
		try {
			return fomat.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}

}
