package countmr;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ywzhInfo implements WritableComparable {



    private String yizhongjiayi="";

    private String rzrq="";

    public String getYizhongjiayi() {
        return yizhongjiayi;
    }

    public void setYizhongjiayi(String yizhongjiayi) {
        this.yizhongjiayi = yizhongjiayi;
    }

    public String getRzrq() {
        return rzrq;
    }

    public void setRzrq(String rzrq) {
        this.rzrq = rzrq;
    }

    public String getCwsc() {
        return cwsc;
    }

    public void setCwsc(String cwsc) {
        this.cwsc = cwsc;
    }

    public String getGpqq() {
        return gpqq;
    }

    public void setGpqq(String gpqq) {
        this.gpqq = gpqq;
    }

    public String getLczah() {
        return lczah;
    }

    public void setLczah(String lczah) {
        this.lczah = lczah;
    }

    private String cwsc="";

    private String gpqq="";
    //资金账号
    private String lczah="";

    public void write(DataOutput out) throws IOException {
        out.writeUTF(yizhongjiayi);
        out.writeUTF(rzrq);
        out.writeUTF(cwsc);
        out.writeUTF(gpqq);
        out.writeUTF(lczah);

    }


    public void readFields(DataInput in) throws IOException {
        this.yizhongjiayi= in.readUTF();
        this.rzrq = in.readUTF();
        this.cwsc = in.readUTF();
        this.gpqq=in.readUTF();
        this.lczah = in.readUTF();




    }
    public int compareTo(Object o) {
        return 0;
    }


    public String toString() {
        return  yizhongjiayi+"\t"+rzrq+"\t"+cwsc+"\t"+gpqq+"\t"+lczah;
    }
}
