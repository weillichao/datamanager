package com.bigdata.datamanager.util;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.domain.TableManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class JsonUtil {




    private static Gson gson =new GsonBuilder().serializeNulls().create();

    public static String getJsonbyList(List<?> ds)
    {

        return gson.toJson(ds);
    }

    public static SystemManager getSystembyJson(String json)
    {
        SystemManager sysmanager = gson.fromJson(json, SystemManager.class);
        return sysmanager;
    }


    public static TableManager getTablebyJson(String json)
    {
        TableManager tablemanager = gson.fromJson(json, TableManager.class);
        return tablemanager;
    }


    public static DatabaseManager getDatabasebyJson(String json)
    {
        DatabaseManager dbmanager = gson.fromJson(json, DatabaseManager.class);
        return dbmanager;
    }


}
