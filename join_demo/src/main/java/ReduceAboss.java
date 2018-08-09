import java.io.IOException;
import java.net.URI;
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

/*public class ReduceAboss {
    private final static String INPUT_PATH = "hdfs://liguodong:8020/inputjoin";
    private final static String OUTPUT_PATH = "hdfs://liguodong:8020/outputmapjoin";

    public static class MyMapper extends Mapper<LongWritable, Text,  NullWritable, postdemo>{
        private postdemo empJoinDep = new postdemo();

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
            if(values.length==41){
                empJoinDep.setKID(values[0]);
                empJoinDep.setKName(values[1]);
                empJoinDep.setCID(values[8]);
                empJoinDep.setCName(values[10]);
                empJoinDep.setResource("Aboss");
                context.write(NullWritable.get(), empJoinDep);
            }

            if(values.length==22){
                empJoinDep.setKID(values[0]);
                empJoinDep.setKName(values[1]);
                empJoinDep.setCID(values[4]);
                empJoinDep.setCName(values[5]);
                empJoinDep.setResource("JJFE");
                context.write(NullWritable.get(), empJoinDep);
            }
        }
    }
    public static class MyReducer extends Reducer<NullWritable, postdemo, NullWritable, postdemo>{

        @Override
        protected void reduce(NullWritable key, Iterable<postdemo> values,
                              Context context)
                throws IOException, InterruptedException {

            for (postdemo val : values) {
                context.write(NullWritable.get(), val);
            }
            //如果上面部门编号是1，则这里也是1。


        }

    }



    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        //System.out.println(System.getenv("HADOOP_HOME"));
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
        ((JobConf)job.getConfiguration()).setJar("C:\\Users\\weilichao\\join_demo\\target\\join_demo-1.0-SNAPSHOT.jar");
        job.setNumReduceTasks(1);
        job.setJobName("word count");
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(postdemo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(postdemo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job,"hdfs://n1:8020/user/aboss/mr");
        FileOutputFormat.setOutputPath(job,new Path("hdfs://n1:8020/user/test/output24"));
        boolean res = job.waitForCompletion(true);
        System.exit(res?0:1);
    }
}*/