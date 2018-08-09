import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class postdemo implements WritableComparable {

    private String KName="";
    private String KID="";
    private String CName;
    private String CID;
    private String resource;

    public  postdemo() {}

    public  postdemo( postdemo  empJoinDep) {
        this.KName = empJoinDep.getKName();
        this.KID = empJoinDep.getKID();
        this.CName = empJoinDep.getCName();
        this.CID = empJoinDep.getCID();
        this.resource = empJoinDep.getResource();

    }

    public String getKName() {
        return KName;
    }

    public void setKName(String name) {
        KName = name;
    }

    public String getKID() {
        return KID;
    }

    public void setKID(String kid) {
        this.KID = kid;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String name) {
        CName = name;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String cid) {
        this.CID = cid;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(KName);
        out.writeUTF(KID);
        out.writeUTF(CName);
        out.writeUTF(CID);
        out.writeUTF(resource);

    }


    public void readFields(DataInput in) throws IOException {
        this.KName = in.readUTF();
        this.KID = in.readUTF();
        this.CName = in.readUTF();
        this.CID = in.readUTF();

        this.resource = in.readUTF();
    }

    //不做任何排序

    public int compareTo(Object o) {
        return 0;
    }


    public String toString() {
        return  KName + "," + KID + "," + CName
                + "," + CID+  "," + resource;
    }
}
