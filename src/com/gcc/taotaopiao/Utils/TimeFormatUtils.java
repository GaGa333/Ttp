package com.gcc.taotaopiao.Utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeFormatUtils {
	
	// date����ת��ΪString����  
    // formatType��ʽΪyyyy-MM-dd HH:mm:ss//yyyy��MM��dd�� HHʱmm��ss��  
    // data Date���͵�ʱ��  
    public static String dateToString(Date data, String formatType) {  
        return new SimpleDateFormat(formatType).format(data);  
    }  
   
    // long����ת��ΪString����  
    // currentTimeҪת����long���͵�ʱ��  
    // formatTypeҪת����string���͵�ʱ���ʽ  
    public static String longToString(long currentTime, String formatType)  
            throws ParseException {  
        Date date = longToDate(currentTime, formatType); // long����ת��Date����  
        String strTime = dateToString(date, formatType); // date����ת��String  
        return strTime;  
    }  
   
    // string����ת��Ϊdate����  
    // strTimeҪת����string���͵�ʱ�䣬formatTypeҪת���ĸ�ʽyyyy-MM-dd HH:mm:ss//yyyy��MM��dd��  
    // HHʱmm��ss�룬  
    // strTime��ʱ���ʽ����Ҫ��formatType��ʱ���ʽ��ͬ  
    public static Date stringToDate(String strTime, String formatType)  
            throws ParseException {  
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);  
        Date date = null;  
        date = formatter.parse(strTime);  
        return date;  
    }  
   
    // longת��ΪDate����  
    // currentTimeҪת����long���͵�ʱ��  
    // formatTypeҪת����ʱ���ʽyyyy-MM-dd HH:mm:ss//yyyy��MM��dd�� HHʱmm��ss��  
    public static Date longToDate(long currentTime, String formatType)  
            throws ParseException {  
        Date dateOld = new Date(currentTime); // ����long���͵ĺ���������һ��date���͵�ʱ��  
        String sDateTime = dateToString(dateOld, formatType); // ��date���͵�ʱ��ת��Ϊstring  
        Date date = stringToDate(sDateTime, formatType); // ��String����ת��ΪDate����  
        return date;  
    }  
   
    // string����ת��Ϊlong����  
    // strTimeҪת����String���͵�ʱ��  
    // formatTypeʱ���ʽ  
    // strTime��ʱ���ʽ��formatType��ʱ���ʽ������ͬ  
    public static long stringToLong(String strTime, String formatType)  
            throws ParseException {  
        Date date = stringToDate(strTime, formatType); // String����ת��date����  
        if (date == null) {  
            return 0;  
        } else {  
            long currentTime = dateToLong(date); // date����ת��long����  
            return currentTime;  
        }  
    }  
   
    // date����ת��Ϊlong����  
    // dateҪת����date���͵�ʱ��  
    public static long dateToLong(Date date) {  
        return date.getTime();  
    }  

}