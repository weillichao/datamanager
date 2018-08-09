import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class positionInfo implements WritableComparable {

    private String code="";
    private String name="";
    private String product_code="";

    private String product_name="";

    private String opendate="";

    public String getShare_code() {
        return share_code;
    }

    public void setShare_code(String share_code) {
        this.share_code = share_code;
    }

    private String share_code="";


    private String changedate="";

    private String currency="";

    private String productType="";

    private String product_num="";

    private String cost="";

    private String profit="";

    private String exchange="";

    public String getExchange_name() {
        return exchange_name;
    }

    public void setExchange_name(String exchange_name) {
        this.exchange_name = exchange_name;
    }

    private String exchange_name="";

    private String organzisition="";


    public String getOrganzisition_code() {
        return organzisition_code;
    }

    public void setOrganzisition_code(String organzisition_code) {
        this.organzisition_code = organzisition_code;
    }

    private String organzisition_code="";

    private String new_sale="";

    private String buy_num="";

    private String buy_price="";

    private String sale_num="";

    private String sale_price="";

    private String fund_num="";

    private String tablename="";

    private String buy_wt_today="";

    private String sale_wt_today="";

    private String buy_num_today="";

    private String sale_num_today="";

    private String buy_price_today="";

    private String sale_price_today="";


    private String System_name="";

    private String catagory="";

    public String getSystem_name() {
        return System_name;
    }

    public void setSystem_name(String system_name) {
        System_name = system_name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    private String update_date="";



    public zabrina setr;

    public positionInfo() throws IOException {


        setr = new zabrina();
    }

        public String getBuy_wt_today() {
        return buy_wt_today;
    }

    public void setBuy_wt_today(String buy_wt_today) {
        this.buy_wt_today = buy_wt_today;
    }

    public String getSale_wt_today() {
        return sale_wt_today;
    }

    public void setSale_wt_today(String sale_wt_today) {
        this.sale_wt_today = sale_wt_today;
    }

    public String getBuy_num_today() {
        return buy_num_today;
    }

    public void setBuy_num_today(String buy_num_today) {
        this.buy_num_today = buy_num_today;
    }

    public String getSale_num_today() {
        return sale_num_today;
    }

    public void setSale_num_today(String sale_num_today) {
        this.sale_num_today = sale_num_today;
    }

    public String getBuy_price_today() {
        return buy_price_today;
    }

    public void setBuy_price_today(String buy_price_today) {
        this.buy_price_today = buy_price_today;
    }

    public String getSale_price_today() {
        return sale_price_today;
    }

    public void setSale_price_today(String sale_price_today) {
        this.sale_price_today = sale_price_today;
    }

    public String getRecord_date() {
        return record_date;

    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    private String record_date="";


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

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate;
    }

    public String getChangedate() {
        return changedate;
    }

    public void setChangedate(String changedate) {
        this.changedate = changedate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getOrganzisition() {
        return organzisition;
    }

    public void setOrganzisition(String organzisition) {
        this.organzisition = organzisition;
    }

    public String getNew_sale() {
        return new_sale;
    }

    public void setNew_sale(String new_sale) {
        this.new_sale = new_sale;
    }

    public String getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(String buy_num) {
        this.buy_num = buy_num;
    }

    public String getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(String buy_price) {
        this.buy_price = buy_price;
    }

    public String getSale_num() {
        return sale_num;
    }

    public void setSale_num(String sale_num) {
        this.sale_num = sale_num;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getFund_num() {
        return fund_num;
    }

    public void setFund_num(String fund_num) {
        this.fund_num = fund_num;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(code);
        out.writeUTF(name);
        out.writeUTF(product_code);
        out.writeUTF(product_name);
        out.writeUTF(product_num);

        out.writeUTF(opendate);

        out.writeUTF(changedate);
        out.writeUTF(productType);
        out.writeUTF(currency);
        out.writeUTF(cost);
        out.writeUTF(profit);
        out.writeUTF(organzisition);
        out.writeUTF(organzisition_code);
        out.writeUTF(exchange);
        out.writeUTF(exchange_name);

        out.writeUTF(new_sale);
        out.writeUTF(buy_num);
        out.writeUTF(buy_price);
        out.writeUTF(sale_num);
        out.writeUTF(sale_price);
        out.writeUTF(fund_num);
        out.writeUTF(tablename);

        out.writeUTF(sale_wt_today);

        out.writeUTF(sale_wt_today);
        out.writeUTF(buy_num_today);
        out.writeUTF(sale_num_today);
        out.writeUTF(buy_price_today);
        out.writeUTF(sale_price_today);

        out.writeUTF(record_date);
        out.writeUTF(share_code);
        out.writeUTF(update_date);
        out.writeUTF(catagory);
        out.writeUTF(System_name);
    }


    public void readFields(DataInput in) throws IOException {
        this.code = in.readUTF();
        this.name = in.readUTF();
        this.product_code = in.readUTF();
        this.product_name = in.readUTF();
        this.product_num = in.readUTF();
        this.opendate = in.readUTF();

        this.changedate = in.readUTF();
        this.productType = in.readUTF();
        this.currency = in.readUTF();
        this.cost = in.readUTF();
        this.profit= in.readUTF();
        this.organzisition= in.readUTF();
        this.organzisition_code=in.readUTF();
        this.exchange = in.readUTF();
        this.exchange_name=in.readUTF();
        this.new_sale = in.readUTF();
        this.buy_num = in.readUTF();
        this.buy_price = in.readUTF();
        this.sale_num = in.readUTF();
        this.sale_price= in.readUTF();
        this.fund_num= in.readUTF();
        this.tablename = in.readUTF();


        this.buy_wt_today = in.readUTF();
        this.sale_wt_today = in.readUTF();
        this.buy_num_today= in.readUTF();
        this.sale_num_today= in.readUTF();
        this.buy_price_today = in.readUTF();
        this.sale_price_today=in.readUTF();
        this.record_date=in.readUTF();
        this.share_code=in.readUTF();
        this.update_date=in.readUTF();
        this.catagory=in.readUTF();
        this.System_name=in.readUTF();
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


    public String getjysResult(String name) {
        try {
            return setr.getjysResult(name);
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

        //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    public String toString() {
        return code+","+name+","+share_code+","+product_code+","+product_name+","+opendate+","+changedate+","+currency+","+productType+","+product_num+","+cost+","+profit+","+exchange+","+exchange_name+","+organzisition_code+","+organzisition+","+new_sale+","+buy_num+","+buy_price+","+sale_num+","+sale_price+","+fund_num+","+record_date+","+update_date+","+catagory+","+System_name;
    }






}
