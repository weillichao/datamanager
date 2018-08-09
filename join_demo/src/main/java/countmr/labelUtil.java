package countmr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class labelUtil {

    public static HashMap<String, String> cpdjmap = new HashMap<String, String>();


    public labelUtil() throws IOException {

        //getProductInfo();
        getInfo();


    }
    public void getInfo() throws IOException {
        String uri = "hdfs://n1:8020";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);
        FSDataInputStream fsr= fs.open(new Path("/user/test/cpdj.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsr));
        String line = null;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split("\t");
            cpdjmap.put(info[0], info[1]);
        }
        bufferedReader.close();
        fsr.close();

    }

    public String getCPDJResult(String name) throws IOException {
        // getProductInfo();
        String ss= cpdjmap.get(name);


        if(ss == null || ss.length() <= 0) {
            return name;
        }
        else
        {
            return ss;
        }
    }







}
