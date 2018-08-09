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

public class accountMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, accountinfo > {
        private accountinfo empJoinDep;

        {
            try {
                empJoinDep = new accountinfo ();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
            /*if (values.length == 11) {
                empJoinDep.setClientcode(values[0]);
                empJoinDep.setOrganization(empJoinDep.getResult(values[1]));
                empJoinDep.setOrganization_name(values[1]);
                empJoinDep.setFund_account(values[2]);
                empJoinDep.setAccount_code(values[2]);
                empJoinDep.setStatus(empJoinDep.getZJstatusResult(values[6]));
                empJoinDep.setOpendate(values[8]);
                empJoinDep.setClosedate(values[9]);
                empJoinDep.setCatagory(empJoinDep.getZJLBResult(values[4]));
                empJoinDep.setAccountType("资金账户");
                context.write(value, empJoinDep);
            }

            if (values.length == 12) {
                empJoinDep.setClientcode(values[0]);
                empJoinDep.setBusinessSystem(values[1]);
                empJoinDep.setBussiness_account(values[2]);
                empJoinDep.setAccount_code(values[2]);
                empJoinDep.setStatus(empJoinDep.getYWstatusResult(values[8]));
                empJoinDep.setOrganization(empJoinDep.getYybResult(values[5]));
                empJoinDep.setOrganization_name(values[5]);
                empJoinDep.setOpendate(values[9]);
                empJoinDep.setClosedate(values[10]);
                empJoinDep.setFund_account(values[11]);
                empJoinDep.setAccountType("业务账户");
                context.write(value, empJoinDep);
            }*/

            if (values.length == 26) {

                empJoinDep.setClientcode(values[0]);
                empJoinDep.setOrganization(empJoinDep.getResult(values[1]));
                empJoinDep.setOrganization_name(values[1]);
                empJoinDep.setExchange(values[2]);
                empJoinDep.setExchange_name(empJoinDep.getjysResult(values[2]));

                empJoinDep.setShareholder_number(values[3]);
                empJoinDep.setAccount_code(values[3]);
                empJoinDep.setCurrency(values[4]);
                empJoinDep.setClientname(values[5]);
                empJoinDep.setStatus(empJoinDep.getGDstatusResult(values[9]));
                empJoinDep.setCatagory(empJoinDep.getGDLBResult(values[10]));

                empJoinDep.setOpendate(values[13]);
                empJoinDep.setClosedate(values[14]);
                empJoinDep.setFirst_business_date(values[15]);
                empJoinDep.setSign_date(values[16]);
                empJoinDep.setEffect_date(values[17]);
                empJoinDep.setBusinessSystem(values[24]);
                empJoinDep.setBussiness_account(values[25]);
                empJoinDep.setAccountType("股东账户");
                context.write(value, empJoinDep);
            }

           /* if (values.length == 19) {

                empJoinDep.setClientcode(values[0]);
                empJoinDep.setClientname(values[1]);
                empJoinDep.setBank_code(values[2]);
                empJoinDep.setAccount_code(values[2]);
                empJoinDep.setBank_account(values[5]);
                empJoinDep.setCurrency(values[6]);
                empJoinDep.setFund_account(values[7]);
                empJoinDep.setStatus(empJoinDep.getZJstatusResult(values[10]));
                empJoinDep.setBank_date(values[9]);
                empJoinDep.setOrganization(empJoinDep.getYybResult(values[11]));
                empJoinDep.setOrganization_name(values[11]);
                empJoinDep.setBank_balance(values[14]);
                empJoinDep.setAccountType("银行账号");
                context.write(value, empJoinDep);
            }

            if (values.length == 38) {

                empJoinDep.setClientcode(values[0]);
                empJoinDep.setJj_account(values[2]);
                empJoinDep.setAccount_code(values[2]);
                empJoinDep.setFund_account(values[5]);
                empJoinDep.setOpendate(values[7]);
                empJoinDep.setCurrency(values[6]);
                empJoinDep.setStatus(empJoinDep.getJJstatusResult(values[12]));
                empJoinDep.setCatagory(empJoinDep.getJJLBResult(values[13]));
                empJoinDep.setClientname(values[14]);
                empJoinDep.setOrganization(empJoinDep.getYybResult(values[33]));
                empJoinDep.setOrganization_name(values[33]);
                empJoinDep.setAccountType("基金账号");
                context.write(value, empJoinDep);
            }*/



        }
    }

    public static class MyReducer extends Reducer<Text, accountinfo , NullWritable, accountinfo> {

        @Override
        protected void reduce(Text key, Iterable<accountinfo > values,
                              Context context)
                throws IOException, InterruptedException {

            for (accountinfo val : values) {
                context.write(NullWritable.get(), val);
            }

        }
        //如果上面部门编号是1，则这里也是1。

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
        job.setMapOutputValueClass(accountinfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(accountinfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/label/cif/TGDZH");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/account3"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
