import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class cashinfo implements WritableComparable {

    private String request="";
    private String time="";
    private String date="";
    private String deal_date="";
    private String clientcode="";

    public String getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(String deal_date) {
        this.deal_date = deal_date;
    }

    private String clientname="";

    public String getCash_account() {
        return cash_account;
    }

    public void setCash_account(String cash_account) {
        this.cash_account = cash_account;
    }

    private String cash_account="";

    private String catagory="";
    private String currency="";

    private String input_num="";
    private String output_num="";
    private String remaining_sum="";
    private String loginid="";
    private String loginway="";
    private String applyway="";
    private String applyaddress="";
    private String happen_organization="";

    private String request_abstract="";
    private String exchange="";
    private String bussiness_cata="";
    private String bussiness_account="";
    private String organization="";
    public zabrina setr;
    public static HashMap<String,String> statusmap=new HashMap<String,String>();

    public cashinfo() throws IOException {

        statusmap.put("0","正常");
        statusmap.put("1","资金业务类");
        statusmap.put("2","客户操作明细类");
        statusmap.put("3","柜员操作审计类");
        statusmap.put("5","证券股份操作类");
        statusmap.put("11","证券帐户类收费");
        statusmap.put("12","委托类收费");
        statusmap.put("13","资源限制类收费");
        setr=new zabrina();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInput_num() {
        return input_num;
    }

    public void setInput_num(String input_num) {
        this.input_num = input_num;
    }

    public String getOutput_num() {
        return output_num;
    }

    public void setOutput_num(String output_num) {
        this.output_num = output_num;
    }

    public String getRemaining_sum() {
        return remaining_sum;
    }

    public void setRemaining_sum(String remaining_sum) {
        this.remaining_sum = remaining_sum;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginway() {
        return loginway;
    }

    public void setLoginway(String loginway) {
        this.loginway = loginway;
    }

    public String getApplyway() {
        return applyway;
    }

    public void setApplyway(String applyway) {
        this.applyway = applyway;
    }

    public String getApplyaddress() {
        return applyaddress;
    }

    public void setApplyaddress(String applyaddress) {
        this.applyaddress = applyaddress;
    }

    public String getHappen_organization() {
        return happen_organization;
    }

    public void setHappen_organization(String happen_organization) {
        this.happen_organization = happen_organization;
    }

    public String getRequest_abstract() {
        return request_abstract;
    }

    public void setRequest_abstract(String request_abstract) {
        this.request_abstract = request_abstract;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getBussiness_cata() {
        return bussiness_cata;
    }

    public void setBussiness_cata(String bussiness_cata) {
        this.bussiness_cata = bussiness_cata;
    }

    public String getBussiness_account() {
        return bussiness_account;
    }

    public void setBussiness_account(String bussiness_account) {
        this.bussiness_account = bussiness_account;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(request);
        out.writeUTF(time);
        out.writeUTF(date);
        out.writeUTF(deal_date);
        out.writeUTF(clientcode);
        out.writeUTF(clientname);
        out.writeUTF(cash_account);
        out.writeUTF(catagory);
        out.writeUTF(currency);
        out.writeUTF(input_num);
        out.writeUTF(output_num);
        out.writeUTF(remaining_sum);
        out.writeUTF(loginid);
        out.writeUTF(loginway);
        out.writeUTF(applyway);
        out.writeUTF(applyaddress);
        out.writeUTF(request_abstract);
        out.writeUTF(exchange);
        out.writeUTF(bussiness_cata);
        out.writeUTF(bussiness_account);
        out.writeUTF(organization);
        out.writeUTF(happen_organization);
    }


    public void readFields(DataInput in) throws IOException {
        this.request = in.readUTF();
        this.time = in.readUTF();
        this.date = in.readUTF();
        this.deal_date=in.readUTF();
        this.clientcode = in.readUTF();
        this.clientname = in.readUTF();
        this.cash_account=in.readUTF();
        this.catagory = in.readUTF();
        this.currency = in.readUTF();
        this.input_num = in.readUTF();
        this.output_num = in.readUTF();
        this.remaining_sum = in.readUTF();
        this.loginid = in.readUTF();
        this.loginway= in.readUTF();
        this.applyway = in.readUTF();
        this.applyaddress = in.readUTF();
        this.request_abstract = in.readUTF();
        this.exchange= in.readUTF();
        this.bussiness_cata=in.readUTF();
        this.bussiness_account = in.readUTF();
        this.organization= in.readUTF();
        this.happen_organization=in.readUTF();




    }

    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    /*public String getResult(String name) {
        try {
            return setr.getResult(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
    }*/
    public String getResult(String name) {
        try {
            return statusmap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String getYybResult(String name) {
        try {
            return setr.getYybResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String toString() {
        return  request +"\t" + date+"\t" + time+"\t"+deal_date+"\t"+clientcode+ "\t" + clientname + "\t" + cash_account + "\t"+catagory
               + "\t" + currency+ "\t" +input_num+"\t" +output_num+"\t" +remaining_sum +"\t" +loginid+"\t" +loginway +"\t" +
                applyway+  "\t" + applyaddress+  "\t" + request_abstract+  "\t" + exchange+  "\t" + bussiness_cata+  "\t" + bussiness_account+  "\t" +organization+  "\t" +happen_organization;
    }
}
