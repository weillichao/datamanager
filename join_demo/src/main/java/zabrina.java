import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URI;
import java.util.HashMap;

public class zabrina {


    public static HashMap<String, String> zqlbmap = new HashMap<String, String>();
    public static HashMap<String, String> ztmap = new HashMap<String, String>();
    public static HashMap<String, String> yybmap = new HashMap<String, String>();
    public static HashMap<String, String> yybidmap = new HashMap<String, String>();
    public static HashMap<String, String> wtlbidmap = new HashMap<String, String>();
    public static HashMap<String, String> ddlxmap = new HashMap<String, String>();
    public static HashMap<String, String> ZJLBmap = new HashMap<String, String>();
    public static HashMap<String, String> jysmap = new HashMap<String, String>();
    public static HashMap<String, String> cpflmap = new HashMap<String, String>();
    public static HashMap<String, String> cplxmap = new HashMap<String, String>();
    public static HashMap<String,String> orgcode=new HashMap<String,String>();
    public static HashMap<String,String> otc_cpztcode=new HashMap<String,String>();
    public static HashMap<String,String> otc_JYScode=new HashMap<String,String>();
    public static HashMap<String,String> otc_TZQX=new HashMap<String,String>();
    public static HashMap<String,String> otc_TZPZ=new HashMap<String,String>();
    public static HashMap<String,String> otc_fxpj=new HashMap<String,String>();
    public static HashMap<String,String> otc_ywdm=new HashMap<String,String>();
    public zabrina() throws IOException {

        //getProductInfo();
        getInfo();
        getZtInfo();
        getYybInfo();
        getYybIDInfo();
        getWTLBInfo();
        getDDLXInfo();
        getZJLBInfo();
        getJYSInfo();
        getcpflInfo();
        getcplxInfo();
        getOtc_cpztInfo();
        getOtc_TZPZInfo();
        getfxpjInfo();
        getYWDMInfo();
        orgcode.put("1000010","兴业银行");
        orgcode.put("1000008","证券协会");
        orgcode.put("XYYH","兴业银行");
        orgcode.put("ZQXH","证券协会");
        orgcode.put("0","首创证券");
        orgcode.put("0000","首创证券");
        otc_JYScode.put("0","内部");
        otc_JYScode.put("1","沪市");
        otc_JYScode.put("2","深市");
        otc_JYScode.put("3","银行");
        otc_JYScode.put("4","协会");
        otc_JYScode.put("5","中登");
        otc_TZQX.put("1","0到1年");
        otc_TZQX.put("2","1到5年");
        otc_TZQX.put("3","5年以上");
        otc_fxpj.put("1","低风险-低");
        otc_fxpj.put("2","低风险-中");
        otc_fxpj.put("3","低风险-高");
        otc_fxpj.put("4","中风险-低");
        otc_fxpj.put("5","中风险-中");
        otc_fxpj.put("6","高风险-低");
        otc_fxpj.put("7","高风险-中低");
        otc_fxpj.put("8","高风险-中");
        otc_fxpj.put("9","高风险-中高");
        otc_fxpj.put("10","高风险-高");

    }
    public void getInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/lb.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            zqlbmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getYWDMInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/YWDM.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            otc_ywdm.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getfxpjInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/fxpj1.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            otc_fxpj.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getOtc_cpztInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/otc_cpzt.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            otc_cpztcode.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }




    public void getOtc_TZPZInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/TZPZ.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            otc_TZPZ.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getcplxInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/cplx1.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            cplxmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getcpflInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/otc_cpfl.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            cpflmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getZJLBInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/ZJLB.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            ZJLBmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getJYSInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/new_JYS.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            jysmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getZtInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/jyzt.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            ztmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getYybInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/yyb2.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            yybmap.put(info[1], info[2]);
        }
        bufferedReader.close();
        fsr.close();

    }


    public void getYybIDInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/yyb2.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            yybidmap.put(info[0], info[2]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getWTLBInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/wtlb.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            wtlbidmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public void getDDLXInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/ddlx.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            ddlxmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }
    public void getProductInfo() throws FileNotFoundException {

        try {
            //FileInputStream in = new FileInputStream("C:\\Users\\weilichao\\Desktop\\zqlb.txt");
            FileInputStream in = new FileInputStream("/usr/src/lb.txt");
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inReader);
            String line = null;
            int i = 1;
            while ((line = bufReader.readLine()) != null) {
                String[] info = line.split("\t");
                zqlbmap.put(info[0], info[1]);
            }
            bufReader.close();
            inReader.close();
            in.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getResult(String name) throws IOException {
        // getProductInfo();
        String ss=zqlbmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }

    public String getZtResult(String name) throws IOException {
        // getProductInfo();
        String ss=ztmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "1";
        }
        else
        {
            return ss;
        }
    }


    public String getcplxResult(String name) throws IOException {
        // getProductInfo();
        String ss=cplxmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "1";
        }
        else
        {
            return ss;
        }
    }


    public String getCpflResult(String name) throws IOException {
        // getProductInfo();
        String ss=cpflmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "1";
        }
        else
        {
            return ss;
        }
    }

    public String getDDLXResult(String name) throws IOException {
        // getProductInfo();
        String ss=ddlxmap.get(name);


        if(ss == null || ss.length() < 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getWTLBResult(String name) throws IOException {
        // getProductInfo();
        String ss=wtlbidmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "1";
        }
        else
        {
            return ss;
        }
    }

    public String getzjlbResult(String name) throws IOException {
        // getProductInfo();
        String ss=ZJLBmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "12";
        }
        else
        {
            return ss;
        }
    }


    public String getjysResult(String name) throws IOException {
        // getProductInfo();
        String ss=jysmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return "12";
        }
        else
        {
            return ss;
        }
    }

    public String getYybResult(String name) throws IOException {
        // getProductInfo();
        String ss=yybmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getOrgResult(String name) throws IOException {
        // getProductInfo();
        String ss=orgcode.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }

    public String getYybidResult(String name) throws IOException {
        // getProductInfo();
        String ss=yybidmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getotc_jyscodeResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_JYScode.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getOTC_CPZTResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_cpztcode.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getTZQXResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_TZQX.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getTZpzResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_TZPZ.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getYWDMResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_ywdm.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }


    public String getfxpjResult(String name) throws IOException {
        // getProductInfo();
        String ss=otc_fxpj.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }
    public static void main(String[] args) throws IOException {
        zabrina ss=new zabrina();
       // System.out.println(ss.getResult("A0"));
    }
}
