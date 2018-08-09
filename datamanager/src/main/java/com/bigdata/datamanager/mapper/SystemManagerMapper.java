package com.bigdata.datamanager.mapper;

import com.bigdata.datamanager.domain.SystemManager;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface SystemManagerMapper {



    @Select("SELECT * FROM source_system")
    public List<SystemManager> searcherSystem();


    @Select("SELECT sys_name,sys_id FROM source_system")
    public List<SystemManager> searcherSystemName();


    @Select("SELECT sys_name FROM source_system  where SYS_ID=#{id}")
    public String searcherSystemNamebyID(String id);


    @Select("SELECT * FROM source_system  where SYS_ID=#{id}")
    public List<SystemManager> searcherSystembyID(String id);


    @Insert("insert into source_system(SYS_ID,SYS_NAME,SYS_ALIAS,STATUS,COMMENTS) values(#{sys_id},#{sys_name},#{sys_alias},#{status},#{comments})")
    public Integer save(SystemManager sysman);

    @Update("update source_system set SYS_NAME=#{sys_name},SYS_ALIAS=#{sys_alias},STATUS=#{status},COMMENTS=#{comments} where SYS_ID=#{sys_id}")
    public Integer update(SystemManager sysman);




}
