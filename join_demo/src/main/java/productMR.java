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
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class productMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, productInfo> {
        private productInfo empJoinDep;

        {
            try {
                empJoinDep = new productInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
          if (values.length == 41) {
                empJoinDep.setCode(values[1]);
                empJoinDep.setName(values[2]);
                empJoinDep.setExchange(values[0]);
                empJoinDep.setExchange_code(empJoinDep.getjysResult(values[0]));
                empJoinDep.setCatagory(empJoinDep.getResult(values[4].toString()));
                empJoinDep.setCurrency(values[22]);
                empJoinDep.setProductType("股票");
                empJoinDep.setIssue_time(values[7]);
                empJoinDep.setStatus(empJoinDep.getZtResult("2"+values[9]));
                empJoinDep.setRisk(values[33]);
                empJoinDep.setTablename("gp");
                empJoinDep.setProduct_system("aboss");
                context.write(new Text(empJoinDep.getCode()), empJoinDep);
            }

            else if (values.length == 72) {
                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[7]);
                empJoinDep.setCurrency(values[13]);
                empJoinDep.setProductType("基金");

                empJoinDep.setStatus(empJoinDep.getZtResult(values[8]));

                empJoinDep.setRisk(values[47]);
                empJoinDep.setIssue_time(values[54]);

                empJoinDep.setNav(values[9]);
                empJoinDep.setSub_start_time(values[16]);
                empJoinDep.setSub_close_time(values[17]);

                empJoinDep.setProduct_system("aboss");
                empJoinDep.setTablename("jj");
                context.write(new Text(empJoinDep.getCode()), empJoinDep);
            }




            else {
                empJoinDep.setCode(values[1]);
                empJoinDep.setCode_xt(values[2]);
                empJoinDep.setName(values[5]);

                empJoinDep.setCurrency(values[13]);

                empJoinDep.setProductType(empJoinDep.getcplxResult(values[8]));

                empJoinDep.setCatagory(empJoinDep.getCPFLResult(values[4]));
                empJoinDep.setIssue_period(values[11]);
                empJoinDep.setInvestment_catagory(values[12]);
                empJoinDep.setExchange_code(values[14]);
              empJoinDep.setExchange(empJoinDep.getotc_jysResult(values[14]));
                empJoinDep.setOrganization(empJoinDep.getorgResult(values[15]));
                empJoinDep.setIssue_period(empJoinDep.getotc_tzqxResult(values[11]));

                empJoinDep.setStatus(empJoinDep.getotc_cpztResult(values[22]));
                empJoinDep.setInvestment_catagory(empJoinDep.getotc_tzpzResult(values[12]));
                empJoinDep.setRisk(empJoinDep.getotc_fxpjResult(values[9]));

                empJoinDep.setIssue_time(values[24]);



                empJoinDep.setProduct_system("OTC");
                empJoinDep.setTablename("otc");

                context.write(new Text(empJoinDep.getCode()), empJoinDep);
            }


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











    public static class MyReducer extends Reducer<Text, productInfo, NullWritable, productInfo> {

        @Override
        protected void reduce(Text key, Iterable<productInfo> values,
                              Context context)
                throws IOException, InterruptedException {

            for (productInfo val : values) {
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
        job.setMapOutputValueClass(productInfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(productInfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/aboss/mr1");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/outputproduct2"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
