package com.bigdata.datamanager.domain;

public class ETLManager {

    //编号
    private String id;
    //转换名
    private String etl_name;
    //数据源表id
    private String source_table_id;
    //数据源表名
    private String source_table_name;
    //数据源表数据库
    private String source_database;
    //数据目的表id
    private String destination_table_id;
    //数据目的表名
    private String destination_table_name;
    //说明
    private String comments;
    //状态
    private String status;
    //创建时间
    private String create_date;
    //父id
    private String parent_id;
    //命令
    private String command;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource_table_id() {
        return source_table_id;
    }

    public void setSource_table_id(String source_table_id) {
        this.source_table_id = source_table_id;
    }

    public String getSource_table_name() {
        return source_table_name;
    }

    public void setSource_table_name(String source_table_name) {
        this.source_table_name = source_table_name;
    }

    public String getSource_database() {
        return source_database;
    }

    public void setSource_database(String source_database) {
        this.source_database = source_database;
    }

    public String getDestination_table_id() {
        return destination_table_id;
    }

    public void setDestination_table_id(String destination_table_id) {
        this.destination_table_id = destination_table_id;
    }

    public String getDestination_table_name() {
        return destination_table_name;
    }

    public void setDestination_table_name(String destination_table_name) {
        this.destination_table_name = destination_table_name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getEtl_name() {
        return etl_name;
    }

    public void setEtl_name(String etl_name) {
        this.etl_name = etl_name;
    }
}
