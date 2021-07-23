package com.itheima.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //获取时间加一年或加一月或加一天

/*        Date date = new Date();
        System.out.println("操作日期之前的日期为"+date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.MONTH, 1);//增加一个月
        System.out.println("输出::"+cal.getTime());*/

        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
           date = fmt.parse("2021-05-31 16:24:39");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(date);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -3);  //设置为前3月
        dBefore = calendar.getTime();   //得到前3月的时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前3月的时间
        String defaultEndDate = sdf.format(date); //格式化当前时间
        System.out.println("三个月之前时间======="+defaultStartDate);
        System.out.println("当前时间==========="+defaultEndDate);

        Date startTime = getStartTime(calendar);
        String startTimeStr = sdf.format(startTime);
        System.out.println("三个月之前时间起始时间======="+startTimeStr);

        String preThreeMonthTimeStr = sdf.format(dBefore);

        String tranTime = preThreeMonthTimeStr.substring(0,11)+"00:00:00";
        System.out.println("tranTime三个月之前时间起始时间======="+tranTime);



    }


    public static Date getStartTime(Calendar todayStart) {
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }
}
