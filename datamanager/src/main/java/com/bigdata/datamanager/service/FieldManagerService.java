package com.bigdata.datamanager.service;

import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.TableManager;
import com.bigdata.datamanager.mapper.FieldMapper;
import com.bigdata.datamanager.mapper.TableMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FieldManagerService {


    @Autowired
    FieldMapper fieldMapper;

    public List<FieldManager> searcherField() {
        return fieldMapper.searcherField();
    }
    public List<FieldManager> searcherFieldbyId(String id,int pgnum,int pgsize) {
        PageHelper.startPage(pgnum,  pgsize);
        return fieldMapper.searcherFieldbyId(id);
    }
    public List<FieldManager> searcherFieldbyIdAll(String id)
    {
        return fieldMapper.searcherFieldbyId(id);
    }
    public FieldManager searcherFieldbyFieldId(String id) {
        return fieldMapper.searcherFieldbyFieldId(id);
    }
    public String InsertField(FieldManager ss) {
        return fieldMapper.save(ss).toString();
    }

    public String UpdateField(FieldManager ss) {
        return fieldMapper.update(ss).toString();
    }




}
