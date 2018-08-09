package com.bigdata.datamanager.domain;

public class TableManager {

    //表格编号
    private String table_id;
    //表格姓名
    private String table_name;
    //数据源编号
    private String source_id;
    //数据源名称
    private String source_name;

    //命名空间
    private String tablespace_name;
    //创建日期
    private String create_date;
    //备注
    private String comments;
    //数据来源
    private String source;
    //数据采集
    private String data_acqusition;
    //采集频率
    private String frenquency;
    //状态
    private String status;

    //数据库表别名
    private String table_alias;


    public String getTable_alias() {
        return table_alias;
    }

    public void setTable_alias(String table_alias) {
        this.table_alias = table_alias;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getTable_id() {
        return table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getTablespace_name() {
        return tablespace_name;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getData_acqusition() {
        return data_acqusition;
    }

    public void setData_acqusition(String data_acqusition) {
        this.data_acqusition = data_acqusition;
    }

    public String getFrenquency() {
        return frenquency;
    }

    public void setFrenquency(String frenquency) {
        this.frenquency = frenquency;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }
}
