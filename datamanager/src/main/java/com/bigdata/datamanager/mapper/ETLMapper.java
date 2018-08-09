package com.bigdata.datamanager.mapper;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.ETLManager;
import com.bigdata.datamanager.domain.FieldManager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ETLMapper {


    @Select("SELECT * FROM source_etl where DESTINATION_TABLE_ID=#{id}")
    public List<ETLManager> searcherDestTable(String id);


    @Select("SELECT ID FROM source_etl where DESTINATION_TABLE_ID=#{id}")
    public String searcherDestTableIDByID(String id);


    @Insert("insert into source_etl(ID,ETL_NAME,SOURCE_TABLE_ID,SOURCE_TABLE_NAME,SOURCE_DATABASE,DESTINATION_TABLE_ID,DESTINATION_TABLE_NAME,PARENT_ID,CREATE_DATE,STATUS,COMMENTS,COMMAND) values(#{id},#{etl_name},#{source_table_id},#{source_table_name},#{source_database},#{destination_table_id},#{destination_table_name},#{parent_id},#{create_date},#{status},#{comments},#{command})")
    public Integer save(ETLManager dbman);

    @Update("update source_etl set ETL_NAME=#{etl_name},SOURCE_TABLE_ID=#{source_table_id},SOURCE_TABLE_NAME=#{source_table_name},SOURCE_DATABASE=#{source_database},DESTINATION_TABLE_ID=#{destination_table_id},DESTINATION_TABLE_NAME=#{destination_table_name},PARENT_ID=#{parent_id},CREATE_DATE=#{create_date},COMMENTS=#{comments},STATUS=#{status},COMMAND=#{command} where ID=#{id}")
    public Integer update(ETLManager dbman);
}
