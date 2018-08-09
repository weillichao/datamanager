package com.bigdata.datamanager.mapper;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.SystemManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DatabaseMapper {

    @Select("SELECT * FROM source_database")
    public List<DatabaseManager> searcherDB();


    @Select("SELECT datasource_id,datasource_alias FROM source_database")
    public List<DatabaseManager> searcherDBName();

    @Insert("insert into source_database(DATASOURCE_ID,DATASOURCE_NAME,DATASOURCE_TYPE,DATASOURCE_FORMAT,URL,USERNAME,PASSWORD,SYSTEM_ID,SYSTEM_NAME,CREATE_DATE,STATUS,COMMENTS,DATASOURCE_ALIAS) values(#{datasource_id},#{datasource_name},#{datasource_type},#{datasource_format},#{url},#{username},#{password},#{system_id},#{system_name},#{create_date},#{status},#{comments},#{datasource_alias})")
    public Integer saveDB(DatabaseManager dbman);

    @Update("update source_database set DATASOURCE_NAME=#{datasource_name},DATASOURCE_TYPE=#{datasource_type},DATASOURCE_FORMAT=#{datasource_format},URL=#{url},USERNAME=#{username},PASSWORD=#{password},SYSTEM_ID=#{system_id},SYSTEM_NAME=#{system_name},CREATE_DATE=#{create_date},STATUS=#{status},COMMENTS=#{comments},DATASOURCE_ALIAS=#{datasource_alias} where DATASOURCE_ID=#{datasource_id}")
    public Integer UpdateDB(DatabaseManager dbman);

    @Update("update source_database set SYSTEM_NAME=#{system_name},DATASOURCE_ALIAS=#{datasource_alias} where DATASOURCE_ID=#{datasource_id}")
    public Integer UpdateDBSysName(DatabaseManager dbman);

    @Select("SELECT * FROM source_database where DATASOURCE_ID=#{id}")
    public List<DatabaseManager> searcherDBbyId(String id);


    @Select("SELECT datasource_alias FROM source_database where DATASOURCE_ID=#{id}")
    public String searcherDBAliasbyID(String id);

    @Select("SELECT datasource_name FROM source_database where DATASOURCE_ID=#{id}")
    public String searcherDBNamebyID(String id);

    @Select("SELECT * FROM source_database where SYSTEM_ID=#{sys_id}")
    public List<DatabaseManager> searcherDBbySysID(String sys_id);




}
