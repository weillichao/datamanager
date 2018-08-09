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

public class product_lsMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, product_ls_info> {
        private product_ls_info empJoinDep;

        {
            try {
                empJoinDep = new product_ls_info();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[1]);
                empJoinDep.setShare_code(values[2]);
                empJoinDep.setExchage(values[3]);
                empJoinDep.setCurrency(values[6]);
                empJoinDep.setProduct_code(values[4]);
                empJoinDep.setCatagory( empJoinDep.getResult(values[7]));

                empJoinDep.setStart_data(values[8]);
                empJoinDep.setStart_data(values[9]);
            empJoinDep.setProduct_num(values[10]);
            empJoinDep.setOrganization(empJoinDep.getYybResult(values[14]));

                context.write(value, empJoinDep);




        }
    }

    public static class MyReducer extends Reducer<Text,product_ls_info, NullWritable, product_ls_info> {

        @Override
        protected void reduce(Text key, Iterable<product_ls_info> values,
                              Context context)
                throws IOException, InterruptedException {

            for (product_ls_info val : values) {
                context.write(NullWritable.get(), val);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        //ClientInfo empJoinDep = new ClientInfo();
        // System.out.println(empJoinDep.getResult("43"));
        // System.out.println(System.getenv("HADOOP_HOME"));
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
        job.setMapOutputValueClass(product_ls_info.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(product_ls_info.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/aboss/mr4");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/lst1"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
