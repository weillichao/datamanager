import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class product_ls_info  implements WritableComparable {

    private String code="";
    private String name="";
    private String share_code="";

    private String exchage="";

    private String product_code="";

    private String currency="";

    private String catagory="";

    private String start_data="";

    private String end_date="";

    private String product_num="";

    private String organization="";

    public zabrina setr;


    public product_ls_info() throws IOException {


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

    public String getShare_code() {
        return share_code;
    }

    public void setShare_code(String share_code) {
        this.share_code = share_code;
    }

    public String getExchage() {
        return exchage;
    }

    public void setExchage(String exchage) {
        this.exchage = exchage;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getStart_data() {
        return start_data;
    }

    public void setStart_data(String start_data) {
        this.start_data = start_data;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getProduct_num() {
        return product_num;
    }

    public void setProduct_num(String product_num) {
        this.product_num = product_num;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public void write(DataOutput out) throws IOException {
        out.writeUTF(code);
        out.writeUTF(name);
        out.writeUTF(product_code);
        out.writeUTF(share_code);
        out.writeUTF(exchage);
        out.writeUTF(currency);
        out.writeUTF(catagory);
        out.writeUTF(start_data);
        out.writeUTF(end_date);
        out.writeUTF(product_num);


        out.writeUTF(organization);


    }


    public void readFields(DataInput in) throws IOException {
        this.code = in.readUTF();
        this.name = in.readUTF();
        this.product_code = in.readUTF();
        this.share_code = in.readUTF();
        this.exchage = in.readUTF();
        this.currency = in.readUTF();
        this.catagory=in.readUTF();

        this.start_data = in.readUTF();

        this.end_date= in.readUTF();
        this.product_num = in.readUTF();



        this.organization= in.readUTF();



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

    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }

    public String toString() {
        return code+","+name+","+product_code+","+share_code+","+exchage+","+currency+","+catagory+","+currency+","+start_data+","+end_date+","+product_num+","+organization;
    }
}
