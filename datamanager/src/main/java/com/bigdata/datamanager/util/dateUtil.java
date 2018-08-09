package com.bigdata.datamanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtil {
    //设置日期格式
    public static String getDate()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String date=df.format(new Date());
        return date;
    }

}
