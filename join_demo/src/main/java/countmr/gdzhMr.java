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
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class gdzhMr {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, Text> {






        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            context.write(new Text(values[0]), value);


        }
    }



    /**
     * partitioner的输入就是map的输出
     */
    public static class MyPartitionerPar extends Partitioner<Text, Text> {
        @Override
        public int getPartition(Text key, Text value, int numPartitions) {
            int result = 0;
            /*********************************************************************/
            /***key.toString().equals("long")  must use toString()!!!!  ***/
            /***开始的时候我没有用 ，导致都在一个区里，结果也在一个reduce输出文件中。  ***/
            /********************************************************************/
            if (key.toString().equals("long")) {
                result = 0 % numPartitions;
            } else if (key.toString().equals("short")) {
                result = 1 % numPartitions;
            } else if (key.toString().equals("right")) {
                result = 2 % numPartitions;
            }
            return result;
        }
    }



    public static class MyReducer extends Reducer<Text, Text, Text, Text> {

        @Override
        protected void reduce(Text key, Iterable<Text> values,
                              Context context)
                throws IOException, InterruptedException {

            int sum=0;
            String result="";
            Set<String> ss=new HashSet<String>();
            if(values.iterator().hasNext()) {
                for (Text val : values) {
                    String[] valuess = val.toString().split("\t");
                    //String result="";
                    if (valuess.length==2) {
                        //sum = Integer.valueOf(valuess[1]);
                            ss.add(valuess[1]);
                            //result = result+valuess[1];
                            //context.write(key, new Text("非常活跃"));

                    }

                }
                for (String str : ss) {
                    result=result+" "+str;
                }
                context.write(key, new Text(result));


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
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/test/account3/");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/mr/gudongzhanghao1"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
