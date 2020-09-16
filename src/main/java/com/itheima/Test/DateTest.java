package com.itheima.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //获取时间加一年或加一月或加一天

        Date date = new Date();
        System.out.println("操作日期之前的日期为"+date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.MONTH, 1);//增加一个月
        System.out.println("输出::"+cal.getTime());

    }
}
