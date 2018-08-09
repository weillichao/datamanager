import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;

public class productInfo implements WritableComparable {

    //产品代码
    private String code="";
    //产品名称
    private String name="";

    //产品代码信托
    private String code_xt="";


    private String exchange="";

    public String getExchange_code() {
        return exchange_code;
    }

    public void setExchange_code(String exchange_code) {
        this.exchange_code=exchange_code;
    }

    private String exchange_code="";


    private String opendate="";

    private String catagory="";

    private String status="";


    private String productType="";

    private String tablename="";

    private String currency="";

    private String risk="";

    private String nav="";

    private String sub_start_time="";

    private String sub_close_time="";

    private String issue_time="";

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    private String organization="";

    //发行期限
    private String issue_period="";


    //发行期限
    private String investment_catagory="";



    public String getProduct_system() {
        return product_system;
    }

    public void setProduct_system(String product_system) {
        this.product_system = product_system;
    }


    private String product_system="";

    public String getExchange_name() {
        return exchange_name;
    }

    public void setExchange_name(String exchange_name) {
        this.exchange_name = exchange_name;
    }

    private String exchange_name="";

    public zabrina setr;


    public productInfo() throws IOException {


        setr = new zabrina();
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getSub_start_time() {
        return sub_start_time;
    }

    public void setSub_start_time(String sub_start_time) {
        this.sub_start_time = sub_start_time;
    }

    public String getSub_close_time() {
        return sub_close_time;
    }

    public void setSub_close_time(String sub_close_time) {
        this.sub_close_time = sub_close_time;
    }

    public String getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(String issue_time) {
        this.issue_time = issue_time;
    }

    public String getCode_xt() {
        return code_xt;
    }

    public void setCode_xt(String code_xt) {
        this.code_xt = code_xt;
    }

    public String getIssue_period() {
        return issue_period;
    }

    public void setIssue_period(String issue_period) {
        this.issue_period = issue_period;
    }

    public String getInvestment_catagory() {
        return investment_catagory;
    }

    public void setInvestment_catagory(String investment_catagory) {
        this.investment_catagory = investment_catagory;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(code);
        out.writeUTF(name);
        out.writeUTF(exchange);
        out.writeUTF(exchange_code);
        out.writeUTF(tablename);
        out.writeUTF(status);
        out.writeUTF(catagory);
        out.writeUTF(currency);
        out.writeUTF(productType);
        out.writeUTF(risk);
        out.writeUTF(nav);
        out.writeUTF(sub_start_time);
        out.writeUTF(sub_close_time);
        out.writeUTF(issue_time);
        out.writeUTF(product_system);
        out.writeUTF(code_xt);
        out.writeUTF(issue_period);
        out.writeUTF(investment_catagory);
        out.writeUTF(organization);

    }


    public void readFields(DataInput in) throws IOException {
        this.code = in.readUTF();
        this.name = in.readUTF();
        this.exchange = in.readUTF();
        this.exchange_code=in.readUTF();
        this.tablename = in.readUTF();
        this.status = in.readUTF();
        this.catagory = in.readUTF();
        this.currency = in.readUTF();
        this.productType = in.readUTF();
        this.risk = in.readUTF();
        this.nav = in.readUTF();
        this.sub_start_time= in.readUTF();
        this.sub_close_time= in.readUTF();
        this.issue_time = in.readUTF();
        this.product_system=in.readUTF();
        this.code_xt=in.readUTF();
        this.issue_period=in.readUTF();
        this.investment_catagory=in.readUTF();
        this.organization=in.readUTF();
    }


    public String getResult(String name) {
        try {
            return setr.getResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getZtResult(String name) {
        try {
            return setr.getZtResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
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

    public String getCPFLResult(String name) {
        try {
            return setr.getCpflResult(name);
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


    public String getcplxResult(String name) {
        try {
            return setr.getcplxResult(name);
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

    public String getotc_cpztResult(String name) {
        try {
            return setr.getOTC_CPZTResult(name);
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

    public String getotc_tzqxResult(String name) {
        try {
            return setr.getTZQXResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public String getotc_tzpzResult(String name) {
        try {
            return setr.getTZpzResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getotc_fxpjResult(String name) {
        try {
            return setr.getfxpjResult(name);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    public String toString() {
      return code+","+name+","+exchange+","+exchange_code+","+status+","+issue_time+","+catagory+","+currency+","+organization+","+risk+","+sub_start_time+","+sub_close_time+","+nav+","+productType+","+issue_period +","+investment_catagory+","+product_system;
    }






}
