package com.bigdata.datamanager.service;

import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.mapper.SystemManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemManagerService {


    @Autowired
    SystemManagerMapper systemManagerMapper;


    public List<SystemManager> searcherSystem() {
        return systemManagerMapper.searcherSystem();
    }


    public String InsertSystem(SystemManager ss) {
        return systemManagerMapper.save(ss).toString();
    }


    public String UpdateSystem(SystemManager ss) {
        return systemManagerMapper.update(ss).toString();
    }


    public List<SystemManager> searchSystemName()
    {
        return systemManagerMapper.searcherSystemName();
    }


    public List<SystemManager> searcherSystembyID(String id) {
        return systemManagerMapper.searcherSystembyID(id);
    }


    public String searcherSystemNamebyID(String id) {
        return systemManagerMapper.searcherSystemNamebyID(id);
    }

}
