import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;

public class JGLS implements WritableComparable {


    private String ls_code="";

    private String wt_code="";
    //资金账号
    private String clientcode="";

    private String share_code="";

    private String exchange="";

    private String fund_code="";

    private String currency="";

    private String organization="";

    public String getProduct_organization() {
        return product_organization;
    }

    public void setProduct_organization(String product_organization) {
        this.product_organization = product_organization;
    }

    private String product_organization="";

    private String product_code="";

    private String product_name="";

    private String product_way="";

    private String product_cata="";

    private String deal_date="";

    private String deal_time="";

    private String deal_bishi="";

    private String deal_num="";

    private String deal_price="";

    private String deal_sum ="";

    private String ysje="";

    private String yssl="";

    private String balance="";

    private String jsrq="";

    private String rzrq="";


    private String catagory="";

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFund_balance() {
        return fund_balance;
    }

    public void setFund_balance(String fund_balance) {
        this.fund_balance = fund_balance;
    }

    public String getShare_balance() {
        return share_balance;
    }

    public void setShare_balance(String share_balance) {
        this.share_balance = share_balance;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    private String type="";

    private String fund_balance="";

    private String share_balance="";

    private String system_name="";



    public zabrina setr;
    public static HashMap<String,String> statusmap=new HashMap<String,String>();

    public JGLS() throws IOException {

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

        statusmap.put("256","内线电话");
        statusmap.put("512","其他场内");
        statusmap.put("1024","其他场外");
        setr=new zabrina();
    }

    public String getSb_date() {
        return sb_date;
    }

    public void setSb_date(String sb_date) {
        this.sb_date = sb_date;
    }

    private String sb_date="";

    public String getLs_code() {
        return ls_code;
    }

    public void setLs_code(String ls_code) {
        this.ls_code = ls_code;
    }

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

    public String getProduct_way() {
        return product_way;
    }

    public void setProduct_way(String product_way) {
        this.product_way = product_way;
    }

    public String getProduct_cata() {
        return product_cata;
    }

    public void setProduct_cata(String product_cata) {
        this.product_cata = product_cata;
    }

    public String getDeal_date() {
        return deal_date;
    }

    public void setDeal_date(String deal_date) {
        this.deal_date = deal_date;
    }

    public String getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(String deal_time) {
        this.deal_time = deal_time;
    }

    public String getDeal_bishi() {
        return deal_bishi;
    }

    public void setDeal_bishi(String deal_bishi) {
        this.deal_bishi = deal_bishi;
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

    public String getDeal_sum() {
        return deal_sum;
    }

    public void setDeal_sum(String deal_sum) {
        this.deal_sum = deal_sum;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getYssl() {
        return yssl;
    }

    public void setYssl(String yssl) {
        this.yssl = yssl;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getJsrq() {
        return jsrq;
    }

    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    public String getRzrq() {
        return rzrq;
    }

    public void setRzrq(String rzrq) {
        this.rzrq = rzrq;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(ls_code);
        out.writeUTF(wt_code);
        out.writeUTF(clientcode);
        out.writeUTF(share_code);
        out.writeUTF(exchange);
        out.writeUTF(fund_code);
        out.writeUTF(currency);
        out.writeUTF(organization);
        out.writeUTF(product_code);
        out.writeUTF(product_name);
        out.writeUTF(product_way);
        out.writeUTF(product_cata);
        out.writeUTF(deal_date);
        out.writeUTF(deal_time);
        out.writeUTF(deal_bishi);
        out.writeUTF(deal_num);
        out.writeUTF(deal_price);
        out.writeUTF(deal_sum);
        out.writeUTF(yssl);
        out.writeUTF(ysje);
        out.writeUTF(jsrq);
        out.writeUTF(rzrq);
        out.writeUTF(sb_date);
        out.writeUTF(catagory);
        out.writeUTF(type);
        out.writeUTF(fund_balance);
        out.writeUTF(share_balance);
        out.writeUTF(system_name);
        out.writeUTF(product_organization);
    }


    public void readFields(DataInput in) throws IOException {
        this.ls_code = in.readUTF();
        this.wt_code = in.readUTF();
        this.clientcode = in.readUTF();
        this.share_code=in.readUTF();
        this.exchange = in.readUTF();
        this.fund_code = in.readUTF();
        this.currency=in.readUTF();
        this.organization=in.readUTF();
        this.product_code = in.readUTF();
        this.product_name = in.readUTF();
        this.product_way= in.readUTF();
        this.product_cata= in.readUTF();
        this.deal_date = in.readUTF();
        this.deal_time = in.readUTF();
        this.deal_bishi= in.readUTF();
        this.deal_num = in.readUTF();
        this.deal_price = in.readUTF();
        this.deal_sum= in.readUTF();
        this.ysje= in.readUTF();
        this.yssl=in.readUTF();
        this.jsrq = in.readUTF();
        this.rzrq= in.readUTF();
        this.sb_date=in.readUTF();
        this.catagory=in.readUTF();
        this.type=in.readUTF();
        this.fund_balance=in.readUTF();
        this.share_balance=in.readUTF();
        this.system_name=in.readUTF();
        this.product_organization=in.readUTF();



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
    public String getorgResult(String name) {
        try {
            return setr.getOrgResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public String getotc_jysResult(String name) {
        try {
            return setr.getotc_jyscodeResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public String getCPFLResult(String name) {
        try {
            return setr.getCpflResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getcplxResult(String name) {
        try {
            return setr.getcplxResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String toString() {
       return   ls_code+"," + wt_code+"," + clientcode+","+share_code+","+exchange+ "," + fund_code + "," + currency + ","+organization
                + "," + product_code+ "," +product_name+"," +product_way+"," +product_cata +"," +sb_date+"," +deal_date+"," +deal_time +"," +
               deal_bishi+  "," + deal_num+  "," + deal_price+  "," + deal_sum+  "," + yssl+  "," + ysje+  "," +jsrq+  "," +rzrq+"," +catagory+","+fund_balance+","+share_balance+","+product_organization+","+type+","+system_name;
   }


}
