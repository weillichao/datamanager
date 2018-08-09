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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
  系统数据管理代码

 @author weilichao
 @version 1.2
 @date 20180629
 */

@RestController
@RequestMapping("/datamanagersystem")
public class SystemManagerController {
    @Autowired
    SystemManagerService systemManagerService;
    @Autowired
   DatabaseManagerService databaseManagerService;


    /***
     * 系统数据查询
     * @return json
     */
    @RequestMapping(value="/search" ,method= RequestMethod.GET)
    public String searchSystem (@RequestParam(value="parameters",required=true)  String param){
        List<SystemManager> systems=new ArrayList<SystemManager>();
        //判断返回的json查询参数
        if(param.equals("{}"))
        {
           systems= systemManagerService.searcherSystem();
        }
        else {
            JsonObject jsonObject = new JsonParser().parse(param).getAsJsonObject();
            String params=jsonObject.get("sysName").toString();
            String paramss =params.replace("\"", "");
            if(paramss.isEmpty())
            {
                systems= systemManagerService.searcherSystem();//没有查询参数，查询全部
            }
            else {
                systems = systemManagerService.searcherSystembyID(paramss);//有参数，按照参数查询
            }
        }

       return JsonUtil.getJsonbyList(systems);
    }


    /***
     * 系统数据增加
     * @return json
     */

    @RequestMapping(value="/add" ,method= RequestMethod.POST)
    public String InsertSystem (@RequestBody SystemManager sysmanager)
    {
      //  System.out.println(sysmanager);
        String result="";
        String id= UuidUtil.getUuid();
        sysmanager.setSys_id(id);
       try {
           systemManagerService.InsertSystem(sysmanager);
           result="Insert System  Success";
       }catch(Exception e)
       {
           result="Insert System Error :" +e.getMessage();
       }

        return result;
    }




    /***
     * 系统数据更新
     * @return json
     */
    @RequestMapping(value="/update" ,method= RequestMethod.PUT)
    public String UpdateSystem (@RequestBody SystemManager sysmanager)
    {
        String result="";
        try {
            systemManagerService.UpdateSystem(sysmanager);
            //根据修改内容更改对应数据源内容
            List<DatabaseManager> list = databaseManagerService.searcherdatasourceNamebySysID(sysmanager.getSys_id());
            for (DatabaseManager dm : list) {
                dm.setSystem_name(sysmanager.sys_name);
                dm.setDatasource_alias(sysmanager.sys_name + dm.getDatasource_name());
                databaseManagerService.UpdateDBSysName(dm);
            }
            result="Update System  Success";
        }catch(Exception e)
        {
            result="Update System Error :" +e.getMessage();
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
        // SystemManager sysmanager =JsonUtil.getSystembyJson(systems);
        List<SystemManager> systems= systemManagerService.searchSystemName();
        List<Map<String,String>> result =new ArrayList<Map<String,String>>();
        for(SystemManager sm:systems)
        {
            Map<String,String> list=new HashMap<String,String>();
            list.put("label",sm.getSys_name());
            list.put("value",sm.getSys_id());
            result.add(list);
        }
        System.out.println(systems.toString());
        return result;

    }


    @RequestMapping(value="/test" ,method= RequestMethod.GET)
    public String getTest(String id)
    {

        return "1";

    }


}
