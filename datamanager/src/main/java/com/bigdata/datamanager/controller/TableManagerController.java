package com.bigdata.datamanager.controller;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.domain.TableManager;
import com.bigdata.datamanager.service.DatabaseManagerService;
import com.bigdata.datamanager.service.FieldManagerService;
import com.bigdata.datamanager.service.TableManagerService;
import com.bigdata.datamanager.util.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/datamanagertable")
public class TableManagerController {

    @Autowired
    TableManagerService tableManagerService;
    @Autowired
    DatabaseManagerService databaseManagerService;

    @Autowired
    FieldManagerService fieldManagerService;




    /***
     * 数据表查询
     * @return json
     */
    @RequestMapping(value="/search" ,method= RequestMethod.GET)
    public String searchTable (@RequestParam(value="parameters",required=true) String param,@RequestParam(value="pageSize",required=true)  String pageSize,@RequestParam(value="pageNo",required=true) String pageNo,@RequestParam(value="loadAll",required=true) String loadAll){

        List<TableManager> tablesources=new ArrayList<TableManager>();
        //获取分页数据
        int pageS=Integer.valueOf(pageSize);
        int pageN=Integer.valueOf(pageNo);
        //获取查询条件json
        if(loadAll.equals("false"))
        {
        if(param.equals("{}"))
        {
            tablesources= tableManagerService.searcherTable(pageN,pageS);
        }
        else {
            //判断查询条件
            JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
            String params_table=jsonObject.get("table_name").toString();
            String params_database=jsonObject.get("database_name").toString();
            String paramss =params_table.replace("\"", "");
            String paramssdb =params_database.replace("\"", "");
            if(paramss.isEmpty()&&paramssdb.isEmpty() )
            {
                tablesources= tableManagerService.searcherTable(pageN,pageS);
            }
            else if(!paramss.isEmpty()){
                tablesources = tableManagerService.searcherSystembyID(paramss);
            }
            else
            {
                tablesources = tableManagerService.searcherTableNamebydbID(paramssdb);
            }
        }
        }
        else
        {
            tablesources = tableManagerService.searcherTableAll();
        }



        return JsonUtil.getJsonbyList(tablesources);
    }


    /***
     * 数据表数据增加
     * @return json
     */
    @RequestMapping(value="/add" ,method= RequestMethod.POST)
    public String InsertTable (@RequestBody TableManager dbmanager)
    {
        String result="";
        String fieldresult="";

        dbmanager.setTable_id(UuidUtil.getUuid());
        dbmanager.setCreate_date(dateUtil.getDate());
        String sysname=databaseManagerService.searcherDatasourceAliasbyID(dbmanager.getSource_id());

        dbmanager.setSource_name(databaseManagerService.searcherDatasourceAliasbyID( dbmanager.getSource_id()));
        try {
             tableManagerService.InsertTable(dbmanager);
            //根据表所属系统，调用函数获取表元数据信息，并将信息查询到字段表中
            if (sysname.contains("hadoop")) {
                fieldresult=insertFieldHive(dbmanager.getSource_id(), dbmanager.getTable_name(), dbmanager.getTable_id());
            } else {
                fieldresult=insertField(dbmanager.getSource_id(), dbmanager.getTable_alias(), dbmanager.getTable_id());
            }
        result="Insert table success";

        }catch(Exception e)
        {
            result="Insert table error";
        }

        return result+" "+fieldresult;
    }




    /***
     * 数据表更新
     * @return json
     */
    @RequestMapping(value="/update" ,method= RequestMethod.PUT)
    public String UpdateDatabase (@RequestBody TableManager dbmanager )
    {
       // TableManager dbmanager  =JsonUtil.getTablebyJson(systems);
        String result="";
        String fieldresult="";
        try {
            tableManagerService.UpdateTable(dbmanager);
            String sysname = databaseManagerService.searcherDatasourceAliasbyID(dbmanager.getSource_id());
            if (sysname.contains("hadoop")) {
                fieldresult = UpdateFieldHive(dbmanager.getSource_id(), dbmanager.getTable_name(), dbmanager.getTable_id());
            } else {
                fieldresult = UpdateField(dbmanager.getSource_id(), dbmanager.getTable_alias(), dbmanager.getTable_id());
            }
            result="update table success";
        }catch(Exception e)
        {
            result="update table error";
        }


        return result+" "+fieldresult;
    }

    /***
     * 数据表插入字段
     * @return json
     */
    private String insertField(String id,String tablename,String table_id)
    {
        String result="";
        List<DatabaseManager> ss=databaseManagerService.searcherDatabasebyId(id);
        String name=databaseManagerService.searcherDatasourceNamebyID(id);

        //获取字段信息
        List<FieldManager> st= DBUtil.find(ss.get(0),tablename,name);
        if(st.isEmpty())
        {
             return "find table field error";
        }
        else {
            String source = name + "." + tablename;
            for (FieldManager fm : st) {
                fm.setField_id(UuidUtil.getUuid());
                fm.setCreate_date(dateUtil.getDate());
                fm.setTable_id(table_id);
                fm.setSource(source);
                fm.setOperation("create");
                fm.setStatus("active");
                fm.setParent_id(table_id);
                fm.setApply("未使用");
                try {
                    fieldManagerService.InsertField(fm);
                    result="Insert Field success";
                } catch(Exception e)
                {
                       result="Insert Field error";
                }
            }

            return result;

        }
    }




    /***
     * HIVE中数据表插入字段
     * @return json
     */
    private String insertFieldHive(String id,String tablename,String table_id)
    {
        String result="";
        List<DatabaseManager> ss=databaseManagerService.searcherDatabasebyId(id);
        String name=databaseManagerService.searcherDatasourceNamebyID(id);
        List<FieldManager> st= HiveMetaDataUtil.getHiveMetadata(tablename);
        if(st.isEmpty())
        {
            return "find table field error";
        }
        else {
            String source = name + "." + tablename;
            for (FieldManager fm : st) {
                fm.setField_id(UuidUtil.getUuid());
                fm.setCreate_date(dateUtil.getDate());
                fm.setTable_id(table_id);
                fm.setSource(source);
                fm.setOperation("create");
                fm.setStatus("active");
                fm.setParent_id(table_id);
                fm.setApply("未使用");

                try {
                    fieldManagerService.InsertField(fm);
                    result="Insert Field success";
                } catch(Exception e)
                {
                    result="Insert Field error";
                }
            }

            return result;
        }
    }



    /***
     * HIVE中更新表字段
     * @return json
     */
    private String UpdateFieldHive(String id,String tablename,String table_id)
    {
        String result="";
        List<DatabaseManager> database=databaseManagerService.searcherDatabasebyId(id);
        String name=databaseManagerService.searcherDatasourceNamebyID(id);
        Map<String,String> map =new HashMap<String,String>();
        Map<String,String> commentmap =new HashMap<String,String>();
        List<FieldManager> fieldlist=fieldManagerService.searcherFieldbyIdAll(table_id);
        //数据库字段更新，将原来的字段状态进行修改
        for(FieldManager fm:fieldlist)
        {
            fm.setStatus("inactive");
            map.put(fm.getField_name(),fm.getField_id());
            commentmap.put(fm.getField_name(),fm.getComments());


            fieldManagerService.UpdateField(fm);


        }


        //获取字段信息
        List<FieldManager> st= HiveMetaDataUtil.getHiveMetadata(tablename);
        if(st.isEmpty())
        {
            return "find table field error";
        }
        else {
            String source = name + "." + tablename;
            for (FieldManager fm : st) {
                fm.setField_id(UuidUtil.getUuid());
                fm.setCreate_date(dateUtil.getDate());
                fm.setTable_id(table_id);
                fm.setSource(source);
                fm.setOperation("update");
                fm.setStatus("active");
                if (map.containsKey(fm.getField_name())) {
                    fm.setParent_id(map.get(fm.getField_name()));
                }
                if (commentmap.containsKey(fm.getField_name())) {
                    fm.setComments(commentmap.get(fm.getField_name()));
                }
                try {
                    fieldManagerService.InsertField(fm);
                    result="Insert Field success";
                }
                catch(Exception e)
                {
                    result="Insert Field error";
                }
            }
        }
        return result;
    }

    /***
     * 数据表更新字段
     * @return json
     */

    private String UpdateField(String id,String tablename,String table_id) {
        String result = "";
        List<DatabaseManager> ss = databaseManagerService.searcherDatabasebyId(id);
        String name = databaseManagerService.searcherDatasourceNamebyID(id);
        Map<String, String> map = new HashMap<String, String>();
        Map<String,String> commentmap =new HashMap<String,String>();
        List<FieldManager> st1 = fieldManagerService.searcherFieldbyIdAll(table_id);
        String source = name + "." + tablename;
        //数据库字段更新，将原来的字段状态进行修改
        for (FieldManager fm : st1) {
            fm.setStatus("inactive");
            map.put(fm.getField_name(), fm.getField_id());
            commentmap.put(fm.getField_name(),fm.getComments());
            fieldManagerService.UpdateField(fm);
        }
        //获取字段信息
        List<FieldManager> st = DBUtil.find(ss.get(0), tablename, name);
        if (st.isEmpty()) {
            return "find table field error";
        } else {
            for (FieldManager fm1 : st) {
                fm1.setField_id(UuidUtil.getUuid());
                fm1.setCreate_date(dateUtil.getDate());
                fm1.setTable_id(table_id);
                fm1.setSource(source);
                fm1.setOperation("update");
                fm1.setStatus("active");
                if (map.containsKey(fm1.getField_name())) {
                    fm1.setParent_id(map.get(fm1.getField_name()));
                }
                if (commentmap.containsKey(fm1.getField_name())) {
                    fm1.setComments(commentmap.get(fm1.getField_name()));
                }

                try {
                    fieldManagerService.InsertField(fm1);
                    result="Insert Field success";
                } catch(Exception e)
                {
                    result="Insert Field error";
                }
            }
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

        List<TableManager> systems= tableManagerService.searcherTableName();
        List<Map<String,String>> result =new ArrayList<Map<String,String>>();
        for(TableManager sm:systems)
        {
            Map<String,String> list=new HashMap<String,String>();
            list.put("label",sm.getTable_name());
            list.put("value",sm.getTable_id());
            result.add(list);
        }
        System.out.println(systems.toString());
        return result;

    }

}
