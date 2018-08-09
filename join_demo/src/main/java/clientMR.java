import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class clientMR {



public static class MyMapper extends Mapper<LongWritable, Text,  Text, ClientInfo> {
    private ClientInfo empJoinDep;
    private clientutil cliutil;

    {
        try {
            empJoinDep = new ClientInfo();
            cliutil=new clientutil();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] values = value.toString().split("\t");
        if (values.length == 38) {
            empJoinDep.setCode(values[0]);
            empJoinDep.setName(values[2]);
            empJoinDep.setStatus(empJoinDep.getRealStatus(values[3].toString()));
            empJoinDep.setOrganization(empJoinDep.getyynResult(values[4].toString()));
            empJoinDep.setOrganization_code(values[4]);
            empJoinDep.setOpendate(values[9]);
            empJoinDep.setClosedate(values[10]);

            empJoinDep.setClient_group(cliutil.getOTC_CPZTResult(values[5]));

            empJoinDep.setIdcard_type(empJoinDep.getzjlbResult(values[12]));

            empJoinDep.setIdcard(values[13]);
           // empJoinDep.setShidangxin(values[0]);
            empJoinDep.setTablename("tkhxx");
            context.write(new Text(empJoinDep.getCode()), empJoinDep);
        }

        if (values.length == 16) {
            empJoinDep.setBirthday(values[1]);
            empJoinDep.setSex(empJoinDep.getRealSex(values[2].toString()));
            empJoinDep.setHome_address(values[9]);
            empJoinDep.setWork_address(values[12]);
            empJoinDep.setTablename("TGRKHXX");
            empJoinDep.setClientType("个人");
            context.write(new Text(values[0]), empJoinDep);
        }

        if (values.length == 79) {
            empJoinDep.setEng_name(values[1]);
            empJoinDep.setZhuce_address(values[10]);
            empJoinDep.setZhuce_date(values[11]);
            empJoinDep.setTablename("TJGKHXX");
            empJoinDep.setClientType("机构");
            context.write(new Text(values[0]), empJoinDep);
        }

        if (values.length == 7) {
            empJoinDep.setShidangxin(values[3]);
            empJoinDep.setTablename("shidang");
            context.write(new Text(values[0]), empJoinDep);
        }
    }
}

public static class MyReducer extends Reducer<Text, ClientInfo, NullWritable, ClientInfo> {

    @Override
    protected void reduce(Text key, Iterable<ClientInfo> values,
                          Context context)
            throws IOException, InterruptedException {

        String birthday = "";
        String sex = "";
        String haddress = "";
        String waddress = "";
        String enghome = "";
        String dz = "";
        String date = "";
        String clientType = "";
        String shidangxin = "";
        List<ClientInfo> list = new LinkedList<ClientInfo>();
        //1  emp
        //1  dep
        for (ClientInfo val : values) {
            list.add(new ClientInfo(val));
            //如果是部门表，如果部门编号为1，则获取该部门的名字。
            if (val.getTablename().equals("TGRKHXX")) {
                birthday = val.getBirthday();
                sex = val.getSex();
                System.out.println(sex);
                haddress = val.getHome_address();
                waddress = val.getWork_address();
                clientType = val.getClientType();
            }
            if (val.getTablename().equals("TJGKHXX")) {
                enghome = val.getEng_name();
                dz = val.getZhuce_address();
                date = val.getZhuce_date();
                clientType = val.getClientType();
            }
            if (val.getTablename().equals("shidang")) {
                shidangxin = val.getShidangxin();
            }
        }
        //如果上面部门编号是1，则这里也是1。
        for (ClientInfo listjoin : list) {
            //如果是员工表，则需要设置员工的所属部门。
            if (listjoin.getTablename().equals("tkhxx")) {
                listjoin.setBirthday(birthday);
                listjoin.setSex(sex);
                listjoin.setHome_address(haddress);
                listjoin.setWork_address(waddress);
                listjoin.setEng_name(enghome);
                listjoin.setZhuce_date(date);
                listjoin.setZhuce_address(dz);
                listjoin.setClientType(clientType);
                listjoin.setShidangxin(shidangxin);
                context.write(NullWritable.get(), listjoin);
            }

        }
        //如果上面部门编号是1，则这里也是1。

    }
}

    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        // ClientInfo empJoinDep = new ClientInfo();
        // System.out.println(empJoinDep.getResult("43"));
        System.out.println(System.getenv("HADOOP_HOME"));
        Job job = Job.getInstance();
        Configuration conf = job.getConfiguration();
//        conf.set("mapred.jar","C:\\Users\\fd\\IdeaProjects\\hadoop\\out\\artifacts\\hadoop_jar.jar");
        conf.set("fs.default.name", "hdfs://n1:8020");
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("mapred.remote.os", "Linux");
        conf.set("mapreduce.app-submission.cross-platform", "true");
        conf.set("yarn.resourcemanager.hostname", "n1");
//        conf.set("yarn.resourcemanager.resource-tracker.address", "hadoop1:8031");
//        conf.set("yarn.resourcemanager.scheduler.address", "hadoop1:8030");
        job.setJarByClass(postdemo.class);
        ((JobConf) job.getConfiguration()).setJar("C:\\Users\\weilichao\\join_demo\\target\\join_demo-1.0-SNAPSHOT.jar");
        job.setNumReduceTasks(1);
        job.setJobName("word count");
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(ClientInfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(ClientInfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/cif/mr");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/outputclient14"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
