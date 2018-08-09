package countmr;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.*;

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

public class ywzhMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, Text> {





        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            context.write(new Text(values[0]), value);


        }
    }

    public static class MyReducer extends Reducer<Text, Text, Text, Text> {

        @Override
        protected void reduce(Text key, Iterable<Text> values,
                              Context context)
                throws IOException, InterruptedException {

            int sum=0;
            String result="";
            Set<String> mark=new HashSet<String>();
            ywzhInfo empJoinDep = new ywzhInfo();
            if(values.iterator().hasNext()) {
                for (Text val : values) {
                    String[] valuess = val.toString().split("\t");
                  //  Set<String> mark=new HashSet<String>();
                    if (valuess.length==2) {
                        sum = Integer.valueOf(valuess[1]);
                        if (sum == 1000) {
                            mark.add("集中交易");
                            empJoinDep.setYizhongjiayi("集中交易");
                            //context.write(key, new Text("非常活跃"));
                        } else if (sum ==1001) {
                            //result = result+" 融资融券";
                            mark.add("融资融券");
                            empJoinDep.setRzrq("融资融券");
                           // context.write(key, new Text("活跃"));
                        } else if (sum ==1002) {
                         //   result = result+" 股票期权";
                            mark.add("股票期权");
                            empJoinDep.setGpqq("股票期权");
                        } else if (sum ==1003) {
                          //  result = result+" 场外市场";
                            mark.add("场外市场");
                                empJoinDep.setCwsc("场外市场");
                            //context.write(key, new Text("不活跃"));
                        }else if (sum ==1010) {
                         //   result = result+" 理财子账户";
                            mark.add("理财子账户");
                            empJoinDep.setLczah("理财子账户");
                           //context.write(key, new Text("不活跃"));
                        }
                    }

                }

                context.write(key, new Text( empJoinDep.toString()));


            }

            //如果上面部门编号是1，则这里也是1。

            //如果是员工表，则需要设置员工的所属部门。




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
        //job.setJarByClass(postdemo.class);
        ((JobConf) job.getConfiguration()).setJar("C:\\Users\\weilichao\\join_demo\\target\\join_demo-1.0-SNAPSHOT.jar");
        job.setNumReduceTasks(1);
        job.setJobName("word count");
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/label/cif/TWYZH");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/mr/yewuzhanghu6"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
