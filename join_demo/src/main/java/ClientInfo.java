import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ClientInfo implements WritableComparable {

    private String code="";
    private String name="";
    private String status="";
    private String organization="";

    public String getOrganization_code() {
        return organization_code;
    }

    public void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }

    private String organization_code="";
    private String opendate="";
    private String closedate="";
    private String idcard="";

    public String getIdcard_type() {
        return idcard_type;
    }

    public void setIdcard_type(String idcard_type) {
        this.idcard_type = idcard_type;
    }

    private String idcard_type="";
    private String clientType="";
    private String tablename="";
    private String birthday="";
    private String sex="";
    private String home_address="";
    private String work_address="";
    private String eng_name="";
    private String shidangxin="";
    private String zhuce_date="";
    private String zhuce_address="";

    public String getClient_group() {
        return client_group;
    }

    public void setClient_group(String client_group) {
        this.client_group = client_group;
    }

    private String client_group="";
    public static HashMap<String,String> statusmap=new HashMap<String,String>();
    public static HashMap<String,String> sexmap=new HashMap<String,String>();
    public zabrina setr1;
    public ClientInfo() throws IOException {

        statusmap.put("0","正常");
        statusmap.put("1","冻结");
        statusmap.put("2","客户卡挂失");
        statusmap.put("3","销户");
        statusmap.put("6","小额休眠");
        statusmap.put("7","不合格");
        statusmap.put("9","公司不合格");
        statusmap.put("99","公司不合格");
        sexmap.put("0","未知");
        sexmap.put("1","男");
        sexmap.put("2","女");
        sexmap.put("3","非自然人");
    //     setr = new organizationInfo();
        setr1=new zabrina();
    }

    public ClientInfo( ClientInfo ss)
    {
        this.name = ss.getName();
        this.sex = ss.getSex();
        this.tablename = ss.getTablename();
        this.status = ss.getStatus();
        this.birthday = ss.getBirthday();
        this.code = ss.getCode();
        this.organization = ss.getOrganization();
        this.shidangxin= ss.getShidangxin();
        this.idcard = ss.getIdcard();
        this.zhuce_address = ss.getZhuce_address();
        this.eng_name= ss.getEng_name();
        this.home_address = ss.getHome_address();
        this.zhuce_date = ss.getZhuce_date();
        this.work_address = ss.getWork_address();
        this.opendate = ss.getOpendate();
        this.closedate =ss.getClosedate();
        this.clientType=ss.getClientType();
        this.organization_code=ss.getOrganization_code();
        this.idcard_type=ss.getIdcard_type();
        this.client_group=ss.getClient_group();

    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getTable() {
        return tablename;
    }

    public void setTable(String table) {
        this.tablename = table;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {

        //this.organization = organization;
        this.organization = organization;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public String getClosedate() {
        return closedate;
    }

    public void setClosedate(String closedate) {
        this.closedate = closedate;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getWork_address() {
        return work_address;
    }

    public void setWork_address(String work_address) {
        this.work_address = work_address;
    }

    public String getEng_name() {
        return eng_name;
    }

    public void setEng_name(String eng_name) {
        this.eng_name = eng_name;
    }

    public String getShidangxin() {
        return shidangxin;
    }

    public void setShidangxin(String shidangxin) {
        this.shidangxin = shidangxin;
    }

    public String getZhuce_date() {
        return zhuce_date;
    }

    public void setZhuce_date(String zhuce_date) {
        this.zhuce_date = zhuce_date;
    }

    public String getZhuce_address() {
        return zhuce_address;
    }

    public void setZhuce_address(String zhuce_address) {
        this.zhuce_address = zhuce_address;
    }

    public String getRealStatus(String num)
    {
        if(num.length()<1)
        {
            return "错误";
        }
        else {
            return statusmap.get(num);
        }
    }

    public String getRealSex(String sex)
    {


            return sexmap.get(sex);

    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(code);
        out.writeUTF(name);
        out.writeUTF(sex);
        out.writeUTF(tablename);
        out.writeUTF(status);
        out.writeUTF(birthday);
        out.writeUTF(organization);
        out.writeUTF(opendate);
        out.writeUTF(closedate);
        out.writeUTF(home_address);
        out.writeUTF(work_address);
       out.writeUTF(shidangxin);
        out.writeUTF(idcard);
        out.writeUTF(zhuce_address);
        out.writeUTF(zhuce_date);
        out.writeUTF(eng_name);
        out.writeUTF(clientType);
        out.writeUTF(organization_code);
        out.writeUTF(idcard_type);
        out.writeUTF(client_group);
    }


    public void readFields(DataInput in) throws IOException {
        this.code = in.readUTF();
        this.name = in.readUTF();
        this.sex = in.readUTF();
        this.tablename = in.readUTF();
        this.status = in.readUTF();
        this.birthday = in.readUTF();
        this.organization = in.readUTF();
        this.opendate = in.readUTF();
        this.closedate = in.readUTF();
        this.home_address = in.readUTF();
        this.work_address = in.readUTF();
        this.shidangxin= in.readUTF();
        this.idcard = in.readUTF();
        this.zhuce_address = in.readUTF();
        this.zhuce_date = in.readUTF();
        this.eng_name= in.readUTF();
        this.clientType=in.readUTF();
        this.organization_code=in.readUTF();
        this.idcard_type=in.readUTF();
        this.client_group=in.readUTF();



    }

    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    public String getyynResult(String name) throws IOException {
        try {
            return setr1.getYybidResult(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String getzjlbResult(String name) throws IOException {
        try {
            return setr1.getzjlbResult(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
    }



    public String toString() {
        //return  code + "," + name + "," + status
          //      + "," + organization+  "," + organization_code+  ","+client_group+","+ opendate+  "," + closedate+"," + idcard_type+","+ idcard+","+ birthday+","  + sex+","  + home_address+","+ work_address+","+ zhuce_date+"," + zhuce_address+"," + shidangxin+"," + clientType;
        return code + "\t" + name + "\t" + status
              + "\t" +client_group;

    }

}
