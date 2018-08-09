package com.bigdata.datamanager.controller;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.ETLManager;
import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.service.DatabaseManagerService;
import com.bigdata.datamanager.service.ETLService;
import com.bigdata.datamanager.service.TableManagerService;
import com.bigdata.datamanager.util.JsonUtil;
import com.bigdata.datamanager.util.UuidUtil;
import com.bigdata.datamanager.util.dateUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/datamanageretl")
public class ETLController {


    @Autowired
    ETLService etlService;

    @Autowired
    TableManagerService tableManagerService ;


    /***
     * ETL数据查询
     * @return json
     */

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchETL(@RequestParam(value="parameters",required=true) String param)
    {
        List<ETLManager> etlsources=new ArrayList<ETLManager>();
        if (param.equals("{}")) {
          //  datasources = databaseManagerService.searcherDatabase(pageN,pageS);
        } else {
            JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
            String params = jsonObject.get("destination_table_id").toString();
            String paramss = params.replace("\"", "");
            if (paramss.isEmpty()) {
              //  datasources = databaseManagerService.searcherDatabase(pageN,pageS);
            } else {
                etlsources=etlService.searcherDestTable(paramss);
            }
        }





        return JsonUtil.getJsonbyList(etlsources);
    }


    /***
     * ETL数据增加
     * @return json
     */

    @RequestMapping(value="/add" ,method= RequestMethod.POST)
    public String InsertETL (@RequestBody ETLManager etlmanager)
    {
        String result="";
        String id= UuidUtil.getUuid();
        etlmanager.setId(id);
        etlmanager.setStatus("ACTIVE");
        etlmanager.setCreate_date(dateUtil.getDate());
        etlmanager.setSource_table_name(tableManagerService.searcherTableNamebyID(etlmanager.getSource_table_id()));
        etlmanager.setSource_database(tableManagerService.searcherSystemNamebyID(etlmanager.getSource_table_id()));
        etlmanager.setDestination_table_name(tableManagerService.searcherTableNamebyID(etlmanager.getDestination_table_id()));
        try {
            etlService.InsertDestTable(etlmanager);
            result="Insert ETL Success";
        }catch(Exception e)
        {
            result="Insert ETL Error :" + e.getMessage();
        }
        return result;
    }


    /***
     * ETL更新
     * @return json
     */

    @RequestMapping(value="/update" ,method= RequestMethod.PUT)
    public String UpdateField (@RequestBody ETLManager c)
    {

        String result="";
        try {
            c.setSource_table_name(tableManagerService.searcherTableNamebyID(c.getSource_table_id()));
            c.setSource_database(tableManagerService.searcherSystemNamebyID(c.getSource_table_id()));
            etlService.UpdateDestTable(c);
            result="Update ETL Success";
        }
        catch(Exception e)
        {
            result="Update ETL Error :" + e.getMessage();
        }
        return result;
    }

}
