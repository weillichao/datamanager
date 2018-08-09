package com.bigdata.datamanager.mapper;

import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.SystemManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FieldMapper {


    @Select("SELECT * FROM source_field")
    public List<FieldManager> searcherField();


    @Insert("insert into source_field(FIELD_ID,FIELD_NAME,FIELD_TYPE,FIELD_LENGTH,TABLE_ID,TABLE_NAME,CREATE_DATE,SOURCE,COMMENTS,PARENT_ID,STATUS,OPERATION,APPLY,SAMPLE) values(#{field_id},#{field_name},#{field_type},#{field_length},#{table_id},#{table_name},#{create_date},#{source},#{comments},#{parent_id},#{status},#{operation},#{apply},#{sample})")
    public Integer save(FieldManager fdman);

    @Update("update source_field set FIELD_ID=#{field_id},FIELD_NAME=#{field_name},FIELD_TYPE=#{field_type},FIELD_LENGTH=#{field_length},TABLE_ID=#{table_id},TABLE_NAME=#{table_name},CREATE_DATE=#{create_date},SOURCE=#{source},COMMENTS=#{comments},PARENT_ID=#{parent_id},STATUS=#{status},OPERATION=#{operation},APPLY=#{apply},SAMPLE=#{sample} where FIELD_ID=#{field_id}")
    public Integer update(FieldManager fdman);


    @Select("SELECT * FROM source_field where TABLE_ID=#{id} and STATUS='active'")
    public List<FieldManager> searcherFieldbyId(String id);


    @Select("SELECT * FROM source_field where Field_ID=#{id}")
    public FieldManager searcherFieldbyFieldId(String id);



}
