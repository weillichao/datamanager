import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;

public class wtinfo implements WritableComparable {


    public String getWt_code() {
        return wt_code;
    }

    public void setWt_code(String wt_code) {
        this.wt_code = wt_code;
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

    public String getShare_code() {
        return share_code;
    }

    public void setShare_code(String share_code) {
        this.share_code = share_code;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getFund_code() {
        return fund_code;
    }

    public void setFund_code(String fund_code) {
        this.fund_code = fund_code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getWt_way() {
        return wt_way;
    }

    public void setWt_way(String wt_way) {
        this.wt_way = wt_way;
    }

    public String getWt_cata() {
        return wt_cata;
    }

    public void setWt_cata(String wt_cata) {
        this.wt_cata = wt_cata;
    }

    public String getWt_num() {
        return wt_num;
    }

    public void setWt_num(String wt_num) {
        this.wt_num = wt_num;
    }

    public String getWt_amount() {
        return wt_amount;
    }

    public void setWt_amount(String wt_amount) {
        this.wt_amount = wt_amount;
    }

    public String getWt_time() {
        return wt_time;
    }

    public void setWt_time(String wt_time) {
        this.wt_time = wt_time;
    }

    public String getWt_date() {
        return wt_date;
    }

    public void setWt_date(String wt_date) {
        this.wt_date = wt_date;
    }

    public String getSb_time() {
        return sb_time;
    }

    public void setSb_time(String sb_time) {
        this.sb_time = sb_time;
    }

    public String getSb_date() {
        return sb_date;
    }

    public void setSb_date(String sb_date) {
        this.sb_date = sb_date;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public String getDeal_amount() {
        return deal_amount;
    }

    public void setDeal_amount(String deal_amount) {
        this.deal_amount = deal_amount;
    }

    public String getDeal_num() {
        return deal_num;
    }

    public void setDeal_num(String deal_num) {
        this.deal_num = deal_num;
    }

    public String getDeal_price() {
        return deal_price;
    }

    public void setDeal_price(String deal_price) {
        this.deal_price = deal_price;
    }

    public String getDdlx() {
        return ddlx;
    }

    public void setDdlx(String ddlx) {
        this.ddlx = ddlx;
    }

    private String wt_code="";
    //资金账号
    private String clientcode="";

    private String clientname="";

    private String share_code="";

    private String exchange="";

    private String fund_code="";

    private String currency="";

    private String organization="";

    private String product_code="";

    private String product_name="";

    private String wt_way="";

    private String wt_cata="";

    private String wt_num="";

    private String wt_amount="";

    private String wt_time="";

    public String getWt_price() {
        return wt_price;
    }

    public void setWt_price(String wt_price) {
        this.wt_price = wt_price;
    }

    //委托净额
    private String wt_price="";

    private String wt_date="";

    private String sb_time="";

    private String sb_date="";

    public String getSb_result() {
        return sb_result;
    }

    public void setSb_result(String sb_price) {
        this.sb_result = sb_price;
    }

    private String sb_result="";

    private String deal_time="";

    private String deal_amount="";

    private String deal_num="";

    private String deal_price="";

    public String getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(String deal_date) {
        this.deal_date = deal_date;
    }

    private String deal_date="";

    private String ddlx ="";
  private String Type="";

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    private String system_name="";

    public String getOrder_abstract() {
        return order_abstract;
    }

    public void setOrder_abstract(String order_abstract) {
        this.order_abstract = order_abstract;
    }

    private String order_abstract="";

    public zabrina setr;
    public static HashMap<String,String> statusmap=new HashMap<String,String>();

    public wtinfo() throws IOException {

        statusmap.put("1","电话");
        statusmap.put("128","银行");
        statusmap.put("2","磁卡");
        statusmap.put("4","热键");
        statusmap.put("8","柜台");
        statusmap.put("64","手机");
        statusmap.put("32","互联网");
        statusmap.put("128","银行");
        statusmap.put("16","远程");
        statusmap.put("0","0");
        setr=new zabrina();
    }



    public void write(DataOutput out) throws IOException {

        out.writeUTF(wt_code);
        out.writeUTF(clientcode);
        out.writeUTF(clientname);
        out.writeUTF(share_code);
        out.writeUTF(exchange);
        out.writeUTF(fund_code);
        out.writeUTF(currency);
        out.writeUTF(organization);
        out.writeUTF(product_code);
        out.writeUTF(product_name);
        out.writeUTF(wt_way);
        out.writeUTF(wt_cata);
        out.writeUTF(wt_date);
        out.writeUTF(wt_time);
        out.writeUTF(wt_num);
        out.writeUTF(wt_amount);
        out.writeUTF(wt_price);
        out.writeUTF(deal_time);
        out.writeUTF(deal_num);
        out.writeUTF(deal_price);
        out.writeUTF(deal_amount);
        out.writeUTF(ddlx);

        out.writeUTF(sb_date);
        out.writeUTF(sb_time);
        out.writeUTF(sb_result);
        out.writeUTF(deal_date);
        out.writeUTF(Type);
        out.writeUTF(system_name);
        out.writeUTF(order_abstract);

    }


    public void readFields(DataInput in) throws IOException {

        this.wt_code = in.readUTF();
        this.clientcode = in.readUTF();
        this.clientname= in.readUTF();
        this.share_code=in.readUTF();
        this.exchange = in.readUTF();
        this.fund_code = in.readUTF();
        this.currency=in.readUTF();
        this.organization=in.readUTF();
        this.product_code = in.readUTF();
        this.product_name = in.readUTF();

        this.wt_way= in.readUTF();
        this.wt_cata= in.readUTF();
        this.wt_date = in.readUTF();
        this.wt_time= in.readUTF();
        this.wt_num= in.readUTF();
        this.wt_amount = in.readUTF();
        this.wt_price=in.readUTF();
        this.deal_time = in.readUTF();

        this.deal_num = in.readUTF();
        this.deal_price = in.readUTF();
        this.deal_amount= in.readUTF();
        this.ddlx= in.readUTF();
        this.sb_date=in.readUTF();
        this.sb_time=in.readUTF();
        this.sb_result=in.readUTF();
        this.deal_date=in.readUTF();
        this.Type=in.readUTF();
        this.system_name=in.readUTF();
        this.order_abstract=in.readUTF();




    }

    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    public String getResult(String name) {
        String ss=statusmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "1";
        }
        else
        {
            return ss;
        }
    }
    public String getLBResult(String name) {
        try {
            return setr.getWTLBResult(name);
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

    public String getDdlxResult(String name) {
        try {
            return setr.getDDLXResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getYWDMResult(String name) {
        try {
            return setr.getYWDMResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String toString() {
        return   wt_code+"," + clientcode+","+clientname+","+share_code+","+exchange+ "," + fund_code + "," + currency + ","+organization
                + "," + product_code+ "," +product_name+"," +wt_cata+","  +wt_date +","+wt_time +","+wt_num +","+wt_amount +","+wt_price +","+sb_date+"," +sb_time+","+sb_result+"," +deal_time +"," +
                 deal_num+  "," + deal_price+  "," + deal_amount+  "," + ddlx+  "," + order_abstract+ ","+ Type+  "," + system_name;
    }


}
