package com.bigdata.labelmanager.controller;

import com.bigdata.labelmanager.domain.ImportResult;
import com.bigdata.labelmanager.domain.LabelManager;
import com.bigdata.labelmanager.exception.MyException;
import com.bigdata.labelmanager.util.ImportUtil;
import com.bigdata.labelmanager.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/labelmanagerimport")
public class ImportController {


    /***
     * 数据库数据更新
     * @return json
     */
    @RequestMapping(value="/getResult" ,method= RequestMethod.GET)
    public String getResult () throws MyException
    {
        Calendar cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        String yesterday = new SimpleDateFormat( "yy/MM/dd").format(cal.getTime());
        System.out.println(yesterday);
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");//设置日期格式
        String date=df.format(cal.getTime());
        List<ImportResult> result= ImportUtil.find(date);
        String results= JsonUtil.getJsonbyList(result);
        return results;
    }



}
