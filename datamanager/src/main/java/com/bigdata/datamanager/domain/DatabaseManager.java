package com.bigdata.datamanager.domain;

public class DatabaseManager {

    //数据源编码
    private String datasource_id;
    //数据源名称
    private String datasource_name;
    //系统编码
    private String system_id;

    //系统名称
    private String system_name;

    //数据源类型
    private String datasource_type;
    //数据源类别
    private String datasource_format;
    //数据源地址
    private String url;
    //用户名
    private String username;
    //密码
    private String password;
    //数据库创建日期
    private String create_date;
    //数据库状态
    private String status;
    //备注
    private String comments;
    //数据源别名
    private String datasource_alias;


    public String getDatasource_alias() {
        return datasource_alias;
    }

    public void setDatasource_alias(String datasource_alias) {
        this.datasource_alias = datasource_alias;
    }



    public String getDatasource_id() {
        return datasource_id;
    }

    public void setDatasource_id(String datasource_id) {
        this.datasource_id = datasource_id;
    }

    public String getDatasource_name() {
        return datasource_name;
    }

    public void setDatasource_name(String datasource_name) {
        this.datasource_name = datasource_name;
    }

    public String getSystem_id() {
        return system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public String getDatasource_type() {
        return datasource_type;
    }

    public void setDatasource_type(String datasource_type) {
        this.datasource_type = datasource_type;
    }

    public String getDatasource_format() {
        return datasource_format;
    }

    public void setDatasource_format(String datasource_format) {
        this.datasource_format = datasource_format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }
}
