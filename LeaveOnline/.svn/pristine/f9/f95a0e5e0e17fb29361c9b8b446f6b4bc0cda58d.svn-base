package com.epro.infrastructure.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Nattawut Verarattakul
 * @author Watsaphol Koongaew
 * @author Worachet Suparat
 */
public class SimpleDateFormatUtils {
	
	private static SimpleDateFormat dateFormat;
	private static SimpleDateFormat dateTimeFormat;
	private static SimpleDateFormat dateFormat2;
	private static SimpleDateFormat dateTimeFormat2;
	private static SimpleDateFormat dateTimeFormat3;
	private static SimpleDateFormat dateFormat4;
	private static SimpleDateFormat timeFormat5;
	
	public static DateFormat getDateFormat() {
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		}
		return dateFormat;
	}
	public static DateFormat getDateTimeFormat() {
		if (dateTimeFormat == null) {
			dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
		}
		return dateTimeFormat;
	}
	public static DateFormat getDateFormatTrim() {
		if (dateFormat2 == null) {
			dateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		}
		return dateFormat2;
	}
	
	public static DateFormat getDateFormatDMYHyphen() {
		if (dateFormat4 == null) {
			dateFormat4 = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
		}
		return dateFormat4;
	}
	
	public static DateFormat getDateTimeFormatTrim() {
		if (dateTimeFormat2 == null) {
			dateTimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		}
		return dateTimeFormat2;
	}
	
	public static DateFormat getTimeFormatTrim() {
		if (timeFormat5 == null) {
			timeFormat5 = new SimpleDateFormat("HH:mm:ss", Locale.US);
		}
		return timeFormat5;
	}
	
	public static Date getDateTimeFormatTrim(String strDateTime) throws ParseException {
		if (dateTimeFormat3 == null) {
			dateTimeFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		}
		Date dateTime=dateTimeFormat3.parse(strDateTime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateTime);
		return calendar.getTime();
	}

	public static String dateUSToDateThaiYMD(Date date){
		String temp = SimpleDateFormatUtils.getDateFormat().format(date);
		String arrayDate[] = temp.split("/");
		int tempYear = Integer.parseInt(arrayDate[2]);
		String dateThai =tempYear+"-"+arrayDate[1]+"-"+arrayDate[0];
		return dateThai;
	}
	
	
	public static String dateUSToDateThai(Date date){
		String temp = SimpleDateFormatUtils.getDateFormat().format(date);
		String arrayDate[] = temp.split("/");
		int tempYear = Integer.parseInt(arrayDate[2])+543;
		String dateThai = arrayDate[0]+"/"+arrayDate[1]+"/"+tempYear;
		return dateThai;
	}
	
	public static String dateTimeUSToDateTimeThai(Date date){
		String temp = SimpleDateFormatUtils.getDateTimeFormat().format(date);
		String arrayDate[] = temp.split("/");
		String arrayTime[] = arrayDate[2].split(" ");
		int tempYear = Integer.parseInt(arrayTime[0])+543;
		String dateThai = arrayDate[0]+"/"+arrayDate[1]+"/"+tempYear+" "+arrayTime[1];
		return dateThai;
	}
	
	public static Date getDateThaiFormat(Date date) throws ParseException{
		String temp = SimpleDateFormatUtils.getDateFormat().format(date);
		String arrayDate[] = temp.split("/");
		int tempYear = Integer.parseInt(arrayDate[2])+543;
		String dateThai = arrayDate[0]+"/"+arrayDate[1]+"/"+tempYear;
		return SimpleDateFormatUtils.getDateFormat().parse(dateThai);
	}
	public static Date dateThaiToDateUS(String date) throws ParseException{
		String arrayDate[] = date.split("/");
		int tempYear = Integer.parseInt(arrayDate[2])-543;
		String dateUS = tempYear+"-"+arrayDate[1]+"-"+arrayDate[0];
		return SimpleDateFormatUtils.getDateFormatTrim().parse(dateUS);
	}
	
	public static Date dateThaiToDateTimeUS(String date) throws ParseException{
		String arrayDateTime[] = date.split(" ");
		String arrayDate[] = arrayDateTime[0].split("/");
		int tempYear = Integer.parseInt(arrayDate[2])-543;
		String dateUS = tempYear+"-"+arrayDate[1]+"-"+arrayDate[0];
		return SimpleDateFormatUtils.getDateTimeFormatTrim().parse(dateUS+" "+arrayDateTime[1]);
	}
	public static String getDateUSFormat(String date) throws ParseException{
		String arrayDate[] = date.split("/");
		int tempYear = Integer.parseInt(arrayDate[2])-543;
		String dateUS = tempYear+"-"+arrayDate[1]+"-"+arrayDate[0];
		return dateUS;
	}
	public static Date dateThaiToDateUS(Date date) throws ParseException{
		String temp = SimpleDateFormatUtils.getDateFormat().format(date);
		String arrayDate[] = temp.split("/");
		int tempYear = Integer.parseInt(arrayDate[2])-543;
		String dateUS = tempYear+"-"+arrayDate[1]+"-"+arrayDate[0];
		return SimpleDateFormatUtils.getDateFormatTrim().parse(dateUS);
	}
	public static Date dateThaiToDateTimeUS(Date date) throws ParseException{
		String temp = SimpleDateFormatUtils.getDateTimeFormat().format(date);
		String arrayTime[] = temp.split(" ");
		String arrayDate[] = arrayTime[0].split("/");
		int tempYear = Integer.parseInt(arrayDate[2])-543;
		String dateUS = tempYear+"-"+arrayDate[1]+"-"+arrayDate[0]+" "+arrayTime[1];
		return SimpleDateFormatUtils.getDateTimeFormatTrim().parse(dateUS);
	} 
	
	public static Date truncateTime (Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime( date);
	    cal.set( Calendar.HOUR_OF_DAY, 0);
	    cal.set( Calendar.MINUTE, 0);
	    cal.set( Calendar.SECOND, 0);
	    cal.set( Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	
	public static long daysDiff(Date d1,Date d2){

		long difference = d2.getTime()-d1.getTime();
		
		long diffDays = difference / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}
	
  public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
  
  public static boolean isDateBetween(final Date min, final Date max, final Date date){
	  System.err.println("date=:"+date);
	  System.err.println("min=:"+min);
	  System.err.println("max=:"+max);
	    return !(date.before(min) || date.after(max));
  }
  
public static Date convertDateThaiToUS(Date date,String textDate) throws ParseException{// fix bug for 29/02/2559  
	if(BeanUtils.isNull(date) && BeanUtils.isNotEmpty(textDate)){
		return new SimpleDateFormat("dd/MM/yyyy",new Locale("th","TH")).parse(textDate);
	}else{
		return SimpleDateFormatUtils.dateThaiToDateUS(date);
	}
}

public static Date convertDateTimeThaiToUS(Date date,String textDate) throws ParseException{// fix bug for 29/02/2559  
	if(BeanUtils.isNull(date) && BeanUtils.isNotEmpty(textDate)){
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("th","TH")).parse(textDate);
	}else{
		return SimpleDateFormatUtils.dateThaiToDateTimeUS(date);
	}
}
}
