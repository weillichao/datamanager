package com.bigdata.datamanager.mapper;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.SystemManager;
import com.bigdata.datamanager.domain.TableManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TableMapper {

    @Select("SELECT * FROM source_table")
    public List<TableManager> searcherTable();

    @Select("SELECT table_id,table_name FROM source_table")
    public List<TableManager> searcherTableNmae();


    @Insert("insert into source_table(TABLE_ID,TABLE_NAME,SOURCE_ID,SOURCE_NAME,TABLESPACE_NAME,DATA_ACQUSITION,CREATE_DATE,SOURCE,FRENQUENCY,STATUS,COMMENTS,TABLE_ALIAS) values(#{table_id},#{table_name},#{source_id},#{source_name},#{tablespace_name},#{data_acqusition},#{create_date},#{source},#{frenquency},#{status},#{comments},#{table_alias})")
    public Integer saveTable(TableManager tbman);


    @Update("update source_table set TABLE_ID=#{table_id},TABLE_NAME=#{table_name},SOURCE_ID=#{source_id},SOURCE_NAME=#{source_name},TABLESPACE_NAME=#{tablespace_name},DATA_ACQUSITION=#{data_acqusition},SOURCE=#{source},FRENQUENCY=#{frenquency},CREATE_DATE=#{create_date},STATUS=#{status},COMMENTS=#{comments},TABLE_ALIAS=#{table_alias} where TABLE_ID=#{table_id}")
    public Integer UpdateTable(TableManager tbman);


    @Select("SELECT * FROM source_table  where TABLE_ID=#{id}")
    public List<TableManager> searcherTablebyID(String id);



    @Select("SELECT table_name FROM source_table WHERE TABLE_ID=#{id}")
    public String searcherTableNmaebyId(String id);



    @Select("SELECT SOURCE_NAME FROM source_table WHERE TABLE_ID=#{id}")
    public String searcherTableSystembyId(String id);

    @Select("SELECT * FROM source_table WHERE SOURCE_ID=#{id}")
    public List<TableManager> searcherTablebyDBNmae(String id);


}
