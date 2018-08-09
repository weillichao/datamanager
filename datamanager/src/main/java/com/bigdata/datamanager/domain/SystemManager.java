package com.bigdata.datamanager.domain;
 //系统原型
public class SystemManager {
     //系统编号
     public String sys_id;
     //系统名称
     public String sys_name;


     //系统名称
     public String sys_alias;
     //系统状态
     public String status;
     //备注
     public String comments;

     public String getSys_id() {
          return sys_id;
     }

     public String getSys_name() {
          return sys_name;
     }

     public String getStatus() {
          return status;
     }

     public void setSys_id(String sys_id) {
          this.sys_id = sys_id;
     }

     public void setSys_name(String sys_name) {
          this.sys_name = sys_name;
     }

     public void setStatus(String status) {
          this.status = status;
     }

     public void setComments(String comments) {
          this.comments = comments;
     }

     public String getComments() {

          return comments;
     }

     public String getSys_alias() {
          return sys_alias;
     }

     public void setSys_alias(String sys_alias) {
          this.sys_alias = sys_alias;
     }
}
