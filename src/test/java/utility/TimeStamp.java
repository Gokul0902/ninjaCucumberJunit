package utility;

import java.util.Date;

public class TimeStamp {
	
	public static String getTimeStampEmailText() {
		Date date = new Date();
		return "gokula.chander12"+date.toString().replace(" ", "_").replace(":", "_")+"gmail.com";
	}

}
