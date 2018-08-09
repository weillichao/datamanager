package countmr;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class jginfo implements WritableComparable {


    public String getXingye() {
        return xingye;
    }

    public void setXingye(String xingye) {
        this.xingye = xingye;
    }

    public String getXiehui() {
        return xiehui;
    }

    public void setXiehui(String xiehui) {
        this.xiehui = xiehui;
    }

    private String xingye="";

    private String xiehui="";



    public void write(DataOutput out) throws IOException {
        out.writeUTF(xingye);
        out.writeUTF(xiehui);


    }


    public void readFields(DataInput in) throws IOException {
        this.xingye= in.readUTF();
        this.xiehui = in.readUTF();





    }
    public int compareTo(Object o) {
        return 0;
    }


    public String toString() {
        return  xingye+"\t"+xiehui;
    }
}
