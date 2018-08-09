import com.sun.jdi.connect.Connector;
import countmr.wtgyMR;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.lib.HashPartitioner;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class partitionMr {


    public static class MyMapper extends Mapper<LongWritable, Text,  Text, Text> {






        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            context.write(new Text(values[0]), value);


        }
    }

    public static class MyPartitioner extends Partitioner<Text, Text> {
        @Override
        public int getPartition(Text key, Text value, int numReduceTasks) {
            int result=0;
            int p= Integer.parseInt(key.toString());
            if(p%2==0){
                result=1;
            }
            return result;
        }
    }

    public static class MyReducer extends Reducer<Text, Text, Text, Text> {

        @Override
        protected void reduce(Text key, Iterable<Text> values,
                              Context context)
                throws IOException, InterruptedException {

            //如果上面部门编号是1，则这里也是1。
            String ss="";
            //如果是员工表，则需要设置员工的所属部门。
            for (Text s : values) {
                ss=ss+s;
            }
            context.write(key, new Text(ss));
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
        job.setMapperClass(partitionMr.MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setReducerClass(partitionMr.MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
     //   job.setPartitionerClass(partitionMr.MyPartition.class);

        job.setPartitionerClass(partitionMr.MyPartitioner.class);
        // 设置reduce的任务个数,由于map输出后建立了两个分区，所以应该设置两个reduce任务输出到不同的文件（一个分区对应一个reduce任务）
        job.setNumReduceTasks(2);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/test/demo");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/demo3"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }

}
