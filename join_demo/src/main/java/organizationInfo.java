import java.io.*;
import java.util.HashMap;

public class organizationInfo {


    public static HashMap<String, String> orgmap = new HashMap<String, String>();

    public organizationInfo() throws FileNotFoundException {

        getInfo();

    }

    public void getInfo() throws FileNotFoundException {

        try {
            FileInputStream in = new FileInputStream("/usr/src/yyb.txt");
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inReader);
            String line = null;
            int i = 1;
            while ((line = bufReader.readLine()) != null) {
                String[] info = line.split("\t");
                orgmap.put(info[0], info[1]);
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
     public String getResult(String name) throws FileNotFoundException {
         getInfo();
         String ss=orgmap.get(name);
         if(ss == null || ss.length() <= 0) {
             return "1";
         }
         else
         {
             return orgmap.get(name);
         }
     }
     public static void main(String[] args) throws FileNotFoundException {
         organizationInfo ss=new  organizationInfo();
         System.out.println(ss.getResult("43"));
     }

    }
