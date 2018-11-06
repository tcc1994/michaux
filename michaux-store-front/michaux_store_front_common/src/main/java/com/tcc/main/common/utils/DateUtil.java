package com.tcc.main.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具类
 */
public class DateUtil {

	/**
	 * @MethodDesc:得到日期格式： yyyy-MM-dd
	 * @return String
	 * @Exception:
	 * @Author: Tu chengcheng
	 * @Date:2016年7月8日 下午2:36:21
	 */
	public static String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	/**
	 * @MethodDesc: 得到日期格式： yyyy-MM-dd HH:mm:ss
	 * @return String
	 * @Author: Tu chengcheng
	 * @Date:2016年7月8日 下午2:31:59
	 */
	public static String getDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * 得到日期格式： yyyy-MM-dd HH:mm:ss:SSS 精确到毫秒
	 */
	public static String getDateTimeSSS() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		return df.format(new Date());
	}
	

	/**
	 * @MethodDesc 得到日期的毫秒值
	 */
	public static Long getTime(String dateTime) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.parse(dateTime).getTime();
	}

	/**
	 * 处理日期格式字符串 只支持补全类似这种日期格式的日期字符串2018-1-4 1:4
	 */
	public static String handleDateStr(String dateStr) {
		String[] split = dateStr.split(" ");
		String date = split[0];
		String time = split[1];
		if (date.length() < 10) {
			// 对日期进行处理
			String[] dateArr = date.split("-");
			String year = dateArr[0];
			if (year.length() < 4) {
				year = "20" + year;
			}
			String month = dateArr[1];
			if (month.length() < 2) {
				month = "0" + month;
			}
			String day = dateArr[2];
			if (day.length() < 2) {
				day = "0" + day;
			}
			date = year + "-" + month + "-" + day;
		}
		if (time.length() < 8) {
			// 对时间进行处理
			String[] timeArr = time.split(":");
			if (timeArr.length == 1) {
				String hour = timeArr[0];
				time = (hour.length() < 2 ? "0" + hour : hour) + ":00:00";
			} else if (timeArr.length == 2) {
				String hour = timeArr[0];
				hour = hour.length() < 2 ? "0" + hour : hour;
				String minute = timeArr[1];
				minute = minute.length() < 2 ? "0" + minute : minute;
				time = hour + ":" + minute + ":00";
			} else {
				String hour = timeArr[0];
				hour = hour.length() < 2 ? "0" + hour : hour;
				String minute = timeArr[1];
				minute = minute.length() < 2 ? "0" + minute : minute;
				String second = timeArr[2];
				second = second.length() < 2 ? "0" + second : second;
				time = hour + ":" + minute + ":" + second;
			}
		}
		return date + " " + time;
	}

	/**
	 * 计算两个时间的分钟差，返回int型的值
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static int dateDiff(String fromDate, String toDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int minutes = 0;
		try {
			long from = sdf.parse(fromDate).getTime();
			long to = sdf.parse(toDate).getTime();
			minutes = (int) ((to - from) / (1000 * 60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return minutes;
	}

	/**
	 * 计算两个时间的小时差，返回int型的值
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static int dateDiffByHour(String fromDate, String toDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int hours = 0;
		if(StringUtils.isEmpty(fromDate)){
			return hours;
		}
		try {
			long from = sdf.parse(fromDate).getTime();
			long to = sdf.parse(toDate).getTime();
			hours = (int) ((to - from) / (1000 * 60 * 60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return hours;
	}

	public static String getTimes(String time) {
		return time.substring(0, 19);
	}

	/**
	 * @MethodDesc 判断两个字符串类型的日期是否是同一天
	 * @param str1
	 *str2 (yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss 格式)
	 * @Return boolean
	 * @Author Tu chengcheng
	 * @Date 2018年1月9日上午11:21:46
	 */
	public static boolean isSameDate(String str1, String str2) {
		boolean isSameDate = false;
		try {
			if (str1.length() > 10) {
				str1 = str1.substring(0, 10);
			}
			if (str2.length() > 10) {
				str2 = str2.substring(0, 10);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(str1);
			Date date2 = sdf.parse(str2);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
					.get(Calendar.YEAR);
			boolean isSameMonth = isSameYear
					&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
			isSameDate = isSameMonth
					&& cal1.get(Calendar.DAY_OF_MONTH) == cal2
							.get(Calendar.DAY_OF_MONTH);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return isSameDate;
	}
	
	/** 
	 * 获得指定日期的前一天 
	 *
	 * @param specifiedDay 
	 * @return 
	 * @throws Exception 
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	/** 
	 * 获得指定日期的后一天 
	 * @param specifiedDay 
	 * @return 
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
	
	/**
	 * 获取当前时间，指定前面多少小时的时间
	 */
	public static String getBeforeHourTime(int hour){  
	    String returnstr = "";  
	    Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);  
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    returnstr = df.format(calendar.getTime());  
	    return returnstr;  
	}
	
	/**
	 * @MethodDesc 判断日期字符串距离当前日期是否大于30天
	 * @Return boolean
	 */
	public static boolean isOneMonth(String date) {
        try {
            if (date == null || "".equals(date) || date.length() < 10) {
                return false;
            }
            if (date.length() > 10) {
                date = date.substring(0, 10);
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String curr = format.format(new Date());
            Date currDate = format.parse(curr);
            Date dataDate = format.parse(date);
            int a = (int) ((currDate.getTime() - dataDate.getTime()) / (1000 * 3600 * 24));
            if(Math.abs(a) >= 30){
                return true;
            }else{
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
	
    /**
     * @MethodDesc 是否过期
     * @Return boolean
     */
    public static boolean isOutDate(long stamp) throws ParseException {
        long curstamp = Calendar.getInstance().getTimeInMillis() / 1000;
        if (stamp < curstamp) {
            return true;
        } else {
            return false;
        }
    }
	
    /**
	 * 得到前一天字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getNextDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return df.format(date);
	}
}
