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

public class cashMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, cashinfo > {
        private cashinfo empJoinDep;

        {
            try {
                empJoinDep = new cashinfo ();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            empJoinDep.setRequest(values[0]);
            empJoinDep.setDate(values[2]);
            empJoinDep.setTime(values[3]);
            empJoinDep.setDeal_date(values[4]);
            empJoinDep.setClientcode(values[5]);
            empJoinDep.setClientname(values[6]);
            empJoinDep.setCash_account(values[7]);
            empJoinDep.setCatagory(values[9]);
            empJoinDep.setCurrency(values[10]);
            empJoinDep.setInput_num(values[11]);
            empJoinDep.setOutput_num(values[12]);
            empJoinDep.setRemaining_sum(values[13]);
            empJoinDep.setLoginid(values[14]);
            empJoinDep.setLoginway(values[15]);
            empJoinDep.setApplyway(values[17]);
            empJoinDep.setHappen_organization(empJoinDep.getYybResult(values[18]));
            empJoinDep.setApplyaddress(values[19]);
            empJoinDep.setRequest_abstract(values[20]);
            empJoinDep.setExchange(values[21]);
            empJoinDep.setBussiness_cata(values[22]);
            empJoinDep.setBussiness_account(values[23]);
            empJoinDep.setOrganization(empJoinDep.getYybResult(values[24]));
            context.write(value, empJoinDep);



        }
    }

    public static class MyReducer extends Reducer<Text, cashinfo , NullWritable, cashinfo> {

        @Override
        protected void reduce(Text key, Iterable<cashinfo > values,
                              Context context)
                throws IOException, InterruptedException {

            for (cashinfo val : values) {
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
        job.setMapOutputValueClass(cashinfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(cashinfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/aboss/mr3");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/cash1"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
