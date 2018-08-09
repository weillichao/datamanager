package com.bigdata.datamanager.controller;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.service.DatabaseManagerService;
import com.bigdata.datamanager.service.FieldManagerService;
import com.bigdata.datamanager.service.SystemManagerService;
import com.bigdata.datamanager.util.DBUtil;
import com.bigdata.datamanager.util.JsonUtil;
import com.bigdata.datamanager.util.UuidUtil;
import com.bigdata.datamanager.util.dateUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/datamanagerdatabase")
public class DatabaseManagerController {


    @Autowired
    DatabaseManagerService databaseManagerService;

    @Autowired
    FieldManagerService fieldManagerService;

    @Autowired
    SystemManagerService systemManagerService;

    /***
     * 数据库数据查询
     * @return json
     */
    @RequestMapping(value="/search" ,method= RequestMethod.GET)
    public String databaseSystem (@RequestParam(value="parameters",required=true)  String param,@RequestParam(value="pageSize",required=true)  String pageSize,@RequestParam(value="pageNo",required=true)  String pageNo,@RequestParam(value="loadAll",required=true)  String loadAll){

        List<DatabaseManager> datasources=new ArrayList<DatabaseManager>();
        //后去分页信息
        int pageS=Integer.valueOf(pageSize);
        int pageN=Integer.valueOf(pageNo);
        //获取查询条件
        if(loadAll.equals("false")) {
            if (param.equals("{}")) {
                datasources = databaseManagerService.searcherDatabase(pageN,pageS);
            } else {
                JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
                String params = jsonObject.get("datasource_name").toString();
                String paramss = params.replace("\"", "");
                if (paramss.isEmpty()) {
                    datasources = databaseManagerService.searcherDatabase(pageN,pageS);
                } else {
                    datasources = databaseManagerService.searcherDatabasebyId(paramss);
                }
            }



        }
        else
        {
            datasources = databaseManagerService.searcherDatabaseAll();
        }
        return JsonUtil.getJsonbyList(datasources);
    }


    /***
     * 数据库数据增加
     * @return json
     */
    @RequestMapping(value="/add" ,method= RequestMethod.POST)
    public String InsertDatabase (@RequestBody DatabaseManager dbmanager)
    {
        String result="";
        String id= UuidUtil.getUuid();
        dbmanager.setDatasource_id(id);
        dbmanager.setCreate_date(dateUtil.getDate());
        try {
            String sysname = systemManagerService.searcherSystemNamebyID(dbmanager.getSystem_id());
            String alias = sysname + dbmanager.getDatasource_name() + "数据库";
            dbmanager.setDatasource_alias(alias);
            dbmanager.setSystem_name(sysname);
          databaseManagerService.InsertDatabase(dbmanager);
            result="Insert Database Success";
        } catch(Exception e)
        {
            result="Insert Database Error :" +e.getMessage();
        }
        return result;
    }




    /***
     * 数据库数据更新
     * @return json
     */
    @RequestMapping(value="/update" ,method= RequestMethod.PUT)
    public String UpdateDatabase (@RequestBody DatabaseManager dbmanager)
    {
        String result="";
        //DatabaseManager dbmanager  =JsonUtil.getDatabasebyJson(systems);
        try {
              databaseManagerService.UpdateDatabase(dbmanager);
            result="Update Database Success";

        }catch(Exception e)
        {
            result="Update Database Error :" +e.getMessage();
        }
        return result;
    }

    /***
     * 返回查询label
     * @return json
     */
    @RequestMapping(value="/getLabel" ,method= RequestMethod.GET)
    public List<Map<String,String>> getSystemLabel ()
    {

        List<DatabaseManager> systems= databaseManagerService.searcherDatabaseName();
        List<Map<String,String>> result =new ArrayList<Map<String,String>>();
        for(DatabaseManager sm:systems)
        {
            Map<String,String> list=new HashMap<String,String>();
            list.put("label",sm.getDatasource_alias());
            list.put("value",sm.getDatasource_id());
            result.add(list);
        }
        System.out.println(systems.toString());
        return result;

    }



}
