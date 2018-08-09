package com.bigdata.datamanager.service;

import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.domain.TableManager;
import com.bigdata.datamanager.mapper.DatabaseMapper;
import com.bigdata.datamanager.mapper.TableMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableManagerService {

    @Autowired
    TableMapper tableMapper;

    public List<TableManager> searcherTable(int pgnum,int pgsize) {

        PageHelper.startPage(pgnum,  pgsize);
        return tableMapper.searcherTable();
    }


    public List<TableManager> searcherTableAll() {


        return tableMapper.searcherTable();
    }


    public List<TableManager> searcherTableName() {
        return tableMapper.searcherTableNmae();
    }

    public String InsertTable(TableManager ss) {
        return tableMapper.saveTable(ss).toString();
    }

    public String UpdateTable(TableManager ss) {
        return tableMapper.UpdateTable(ss).toString();
    }

    public List<TableManager> searcherSystembyID(String id) {
        return tableMapper.searcherTablebyID(id);
    }

    public String searcherTableNamebyID(String id)
    {
        return tableMapper.searcherTableNmaebyId(id);
    }



    public String searcherSystemNamebyID(String id)
    {
        return tableMapper.searcherTableSystembyId(id);
    }

    public List<TableManager>  searcherTableNamebydbID(String id)
    {
        return tableMapper.searcherTablebyDBNmae(id);
    }

}
