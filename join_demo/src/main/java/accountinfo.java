import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;

public class accountinfo implements WritableComparable {

    private String clientcode="";

    private String organization="";

    private String account_code="";

    private String organization_name="";
    //资金账号
    private String fund_account="";

    private String status="";

    private String opendate="";

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    private String catagory="";

    private String closedate="";

    private String accountType="";

    private String businessSystem="";

    private String bussiness_account="";

    private String exchange="";

    public String getExchange_name() {
        return exchange_name;
    }

    public void setExchange_name(String exchange_name) {
        this.exchange_name = exchange_name;
    }

    private String exchange_name="";

    private String clientname="";

    private String Shareholder_number ="";

    private String currency="";

    private String first_business_date="";

    private String sign_date="";

    private String effect_date="";

    private String bank_code="";

    private String bank_account="";

    private String bank_date="";

    private String bank_balance="";

    private String jj_account="";

    private String jy_account="";

    public zabrina setr;
    public static HashMap<String,String> statusmap=new HashMap<String,String>();
    //股东号状态
    public static HashMap<String,String> GDstatusmap=new HashMap<String,String>();

    public static HashMap<String,String> GDLBmap=new HashMap<String,String>();

    //资金账号状态
    public static HashMap<String,String> ZJstatusmap=new HashMap<String,String>();

    public static HashMap<String,String> ZJlbmap=new HashMap<String,String>();

    //YW账号状态
    public static HashMap<String,String> YWstatusmap=new HashMap<String,String>();


    //基金账号状态
    public static HashMap<String,String> JJstatusmap=new HashMap<String,String>();
    public static HashMap<String,String> JJLBmap=new HashMap<String,String>();

    public String getAccount_code() {
        return account_code;
    }

    public void setAccount_code(String account_code) {
        this.account_code = account_code;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public accountinfo() throws IOException {

        statusmap.put("0","正常");
        statusmap.put("1","资金业务类");

        statusmap.put("2","客户操作明细类");
        statusmap.put("3","柜员操作审计类");
        statusmap.put("5","证券股份操作类");
        statusmap.put("11","证券帐户类收费");
        statusmap.put("12","委托类收费");
        statusmap.put("13","资源限制类收费");

        GDstatusmap.put("0","正常");
        GDstatusmap.put("1","冻结");
        GDstatusmap.put("2","挂失");
        GDstatusmap.put("3","销户");
        GDstatusmap.put("6","小额休眠");
        GDstatusmap.put("7","不合格");
        GDstatusmap.put("9","公司不合格");

        ZJstatusmap.put("0","正常");
        ZJstatusmap.put("1","冻结");
        ZJstatusmap.put("2","挂失");
        ZJstatusmap.put("3","销户");
        ZJstatusmap.put("4","预指定存管银行");
        ZJstatusmap.put("6","小额休眠");
        ZJstatusmap.put("7","不合格");
        ZJstatusmap.put("9","公司不合格");
        ZJstatusmap.put("99","开户锁定");

        YWstatusmap.put("0","正常");
        YWstatusmap.put("1","冻结");
        YWstatusmap.put("3","销户");
        YWstatusmap.put("6","小额休眠");
        YWstatusmap.put("7","不合格");
        YWstatusmap.put("9","公司不合格");
        YWstatusmap.put("99","开户锁定");

        ZJlbmap.put("1","普通账户");
        ZJlbmap.put("2","信用账户");
        ZJlbmap.put("5","期权账户");
        ZJlbmap.put("6","理财账户");
        ZJlbmap.put("10","理财子账户");

        GDLBmap.put("0","A股账户");
        GDLBmap.put("1","基金账户");
        GDLBmap.put("2","B股账户");
        GDLBmap.put("3","信用账户");

        JJLBmap.put("0","个人");
        JJLBmap.put("1","机构");


        JJstatusmap.put("0","正常");
        JJstatusmap.put("1","冻结");
        JJstatusmap.put("2","挂失");
        JJstatusmap.put("3","销户");
        JJstatusmap.put("4","开户申请中");
        JJstatusmap.put("5","销户申请中");
        JJstatusmap.put("7","内部冻结");
        JJstatusmap.put("99","开户锁定");


        setr=new zabrina();
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    private String table_name="";

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFund_account() {
        return fund_account;
    }

    public void setFund_account(String fund_account) {
        this.fund_account = fund_account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBusinessSystem() {
        return businessSystem;
    }

    public void setBusinessSystem(String businessSystem) {
        this.businessSystem = businessSystem;
    }

    public String getBussiness_account() {
        return bussiness_account;
    }

    public void setBussiness_account(String bussiness_account) {
        this.bussiness_account = bussiness_account;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getShareholder_number() {
        return Shareholder_number;
    }

    public void setShareholder_number(String shareholder_number) {
        Shareholder_number = shareholder_number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFirst_business_date() {
        return first_business_date;
    }

    public void setFirst_business_date(String first_business_date) {
        this.first_business_date = first_business_date;
    }

    public String getSign_date() {
        return sign_date;
    }

    public void setSign_date(String sign_date) {
        this.sign_date = sign_date;
    }

    public String getEffect_date() {
        return effect_date;
    }

    public void setEffect_date(String effect_date) {
        this.effect_date = effect_date;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getBank_date() {
        return bank_date;
    }

    public void setBank_date(String bank_date) {
        this.bank_date = bank_date;
    }

    public String getBank_balance() {
        return bank_balance;
    }

    public void setBank_balance(String bank_balance) {
        this.bank_balance = bank_balance;
    }

    public String getJj_account() {
        return jj_account;
    }

    public void setJj_account(String jj_account) {
        this.jj_account = jj_account;
    }

    public String getJy_account() {
        return jy_account;
    }

    public void setJy_account(String jy_account) {
        this.jy_account = jy_account;
    }
    public void write(DataOutput out) throws IOException {
        out.writeUTF(clientcode);
        out.writeUTF(clientname);
        out.writeUTF(organization);
        out.writeUTF(fund_account);
        out.writeUTF(opendate);
        out.writeUTF(closedate);
        out.writeUTF(status);
        out.writeUTF(catagory);
        out.writeUTF(accountType);
        out.writeUTF(currency);
        out.writeUTF(businessSystem);
        out.writeUTF(bussiness_account);
        out.writeUTF(exchange);
        out.writeUTF(Shareholder_number);
        out.writeUTF(first_business_date);
        out.writeUTF(sign_date);
        out.writeUTF(effect_date);
        out.writeUTF(bank_code);
        out.writeUTF(bank_account);
        out.writeUTF(bank_date);
        out.writeUTF(bank_balance);
        out.writeUTF(jj_account);
        out.writeUTF(jy_account);
        out.writeUTF(organization_name);
        out.writeUTF(account_code);
        out.writeUTF(exchange_name);
    }


    public void readFields(DataInput in) throws IOException {
        this.clientcode = in.readUTF();
        this.clientname = in.readUTF();
        this.organization = in.readUTF();
        this.fund_account=in.readUTF();
        this.opendate = in.readUTF();
        this.closedate = in.readUTF();
        this.status=in.readUTF();
        this.catagory=in.readUTF();
        this.accountType = in.readUTF();
        this.currency = in.readUTF();
        this.businessSystem= in.readUTF();
        this.bussiness_account= in.readUTF();
        this.exchange = in.readUTF();
        this.Shareholder_number = in.readUTF();
        this.first_business_date= in.readUTF();
        this.sign_date = in.readUTF();
        this.effect_date = in.readUTF();
        this.bank_code = in.readUTF();
        this.bank_account= in.readUTF();
        this.bank_date=in.readUTF();
        this.bank_balance = in.readUTF();
        this.jj_account= in.readUTF();
        this.jy_account=in.readUTF();
        this.organization_name=in.readUTF();
        this.account_code=in.readUTF();
        this.exchange_name=in.readUTF();



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
            return setr.getYybidResult(name);
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


    public String getJJstatusResult(String name) {
        String ss=JJstatusmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }

    public String getGDLBResult(String name) {
        try {
            return GDLBmap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getGDstatusResult(String name) {
        String ss=GDstatusmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }




    public String getYWstatusResult(String name) {
        String ss=YWstatusmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }

    public String getJJLBResult(String name) {
        try {
            return JJLBmap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getZJstatusResult(String name) {
        try {
            return ZJstatusmap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getZJLBResult(String name) {
        try {
            return ZJlbmap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public String getjysResult(String name) {
        try {
            return setr.getjysResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
   /* public String toString() {
        return   account_code+"," + clientcode+"," + clientname+"," + organization_name+"," +organization+","+fund_account+","+opendate+ "," + closedate + "," + status + ","+catagory
                + "," + currency+ "," +businessSystem+"," +bussiness_account+"," +exchange +","+exchange_name +"," +Shareholder_number+"," +first_business_date +"," +
                sign_date+  "," + effect_date+  "," + bank_code+  "," + bank_account+  "," + bank_date+  "," + bank_balance+  ","  +accountType;
    }*/

    public String toString() {
        return  clientcode +"\t" + exchange_name;
    }



}
