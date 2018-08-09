package com.bigdata.datamanager.controller;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.service.FieldManagerService;
import com.bigdata.datamanager.service.SystemManagerService;
import com.bigdata.datamanager.service.TableManagerService;
import com.bigdata.datamanager.util.JsonUtil;
import com.bigdata.datamanager.util.UuidUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/datamanagerfield")
public class FieldManagerController {

    @Autowired
    FieldManagerService fieldManagerService;

    @Autowired
    TableManagerService tableManagerService;


    /***
     * 数据表字段查询数据查询
     * @return json
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchField(@RequestParam(value="parameters",required=true) String param,@RequestParam(value="pageSize",required=true)  String pageSize,@RequestParam(value="pageNo",required=true) String pageNo,@RequestParam(value="loadAll",required=true) String loadAll) {
        List<FieldManager> fieldsources = new ArrayList<FieldManager>();
        //分页信息
        int pageS=Integer.valueOf(pageSize);
        int pageN=Integer.valueOf(pageNo);
        String table_id="";
        //判断是否有参数
        if(loadAll.equals("false")) {
            if (param.equals("{}")) {
                //datasources= databaseManagerService.searcherDatabase();
            } else {
                JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
                String params = jsonObject.get("table_name").toString();
                table_id = params.replace("\"", "");
                if (table_id.isEmpty()) {
                    //datasources= databaseManagerService.searcherDatabase();
                } else {
                    fieldsources = fieldManagerService.searcherFieldbyId(table_id,pageN,pageS);
                }
            }
        }
        else
        {
            JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
            if(jsonObject.has("table_name")) {
                String params = jsonObject.get("table_name").toString();
                table_id = params.replace("\"", "");

                fieldsources = fieldManagerService.searcherFieldbyIdAll(table_id);
            }
        }


        return JsonUtil.getJsonbyList(fieldsources);
    }




    /***
     * 数据表字段增加
     * @return json
     */

    @RequestMapping(value="/add" ,method= RequestMethod.POST)
    public String InsertField (@RequestBody FieldManager fdmanager)
    {
        //   System.out.println(sysmanager);
        String id= UuidUtil.getUuid();
        fdmanager.setField_id(id);
        fdmanager.setStatus("ACTIVE");
        fdmanager.setTable_name(tableManagerService.searcherTableNamebyID(fdmanager.getTable_id()));
        String result =fieldManagerService.InsertField(fdmanager);
        return result;
    }




    /***
     * 数据表字段更新
     * @return json
     */
    @RequestMapping(value="/update" ,method= RequestMethod.PUT)
    public String UpdateField (@RequestBody FieldManager fdmanager)
    {
        // SystemManager sysmanager =JsonUtil.getSystembyJson(systems);
        FieldManager oldfield=fieldManagerService.searcherFieldbyFieldId(fdmanager.getField_id());
        oldfield.setStatus("inactive");
        String id= UuidUtil.getUuid();
        fdmanager.setField_id(id);
        fdmanager.setStatus("active");
        fdmanager.setOperation("update");
        String result =fieldManagerService.UpdateField(oldfield);
        fieldManagerService.InsertField(fdmanager);
        return result;
    }




}
