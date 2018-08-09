package com.bigdata.datamanager.service;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.mapper.DatabaseMapper;
import com.bigdata.datamanager.mapper.SystemManagerMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatabaseManagerService {


    @Autowired
    DatabaseMapper databaseMapper;

    /***
     * 查询数据库
     * @return List<DatabaseManager>
     */
    public List<DatabaseManager> searcherDatabase(int pgnum,int pgsize) {


        PageHelper.startPage(pgnum,  pgsize);
        return databaseMapper.searcherDB();
    }



    public List<DatabaseManager> searcherDatabaseAll() {



        return databaseMapper.searcherDB();
    }

    /***
     * 查看数据库的ID,名称
     * @return List<DatabaseManager>
     */
    public List<DatabaseManager> searcherDatabaseName() {
        return databaseMapper.searcherDBName();
    }


    /***
     * 插入数据库
     * @return String
     */
    public String InsertDatabase(DatabaseManager dm) {
        return databaseMapper.saveDB(dm).toString();
    }
    /***
     * 更新数据库
     * @return String
     */
    public String UpdateDatabase(DatabaseManager dm) {
        return databaseMapper.UpdateDB(dm).toString();
    }
    /***
     * 根据编号查询数据库
     * @return DatabaseManager
     */
    public List<DatabaseManager> searcherDatabasebyId(String id) {
        return databaseMapper.searcherDBbyId(id);
    }



    public String searcherDatasourceNamebyID(String id) {
        return databaseMapper.searcherDBNamebyID(id);
    }


    public String searcherDatasourceAliasbyID(String id) {
        return databaseMapper.searcherDBAliasbyID(id);
    }



    public List<DatabaseManager> searcherdatasourceNamebySysID(String id)
    {
        return databaseMapper.searcherDBbySysID(id);
    }



    public Integer UpdateDBSysName(DatabaseManager dm)
    {
        return databaseMapper.UpdateDBSysName(dm);
    }
}
