package com.bigdata.datamanager.service;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.ETLManager;
import com.bigdata.datamanager.mapper.DatabaseMapper;
import com.bigdata.datamanager.mapper.ETLMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETLService {

    @Autowired
    ETLMapper etlMapper;

    public List<ETLManager> searcherDestTable(String id) {



        return etlMapper.searcherDestTable(id);
    }


    public String UpdateDestTable(ETLManager em) {



        return etlMapper.update(em).toString();
    }

    public String InsertDestTable(ETLManager em)
    {
        return etlMapper.save(em).toString();
    }

    public String SearchETL_id(String id)
    {
        return etlMapper.searcherDestTableIDByID(id).toString();
    }
}
