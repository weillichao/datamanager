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

public class jGLSmr {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, JGLS> {
        private JGLS empJoinDep;

        {
            try {
                empJoinDep = new JGLS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
            if (values.length==57) {

                empJoinDep.setLs_code(values[3]);


                empJoinDep.setClientcode(values[6]);

                empJoinDep.setShare_code(values[8]);
                empJoinDep.setFund_code(values[9]);

                empJoinDep.setExchange(values[16]);
                empJoinDep.setOrganization(values[1]);
                empJoinDep.setProduct_organization(empJoinDep.getorgResult(values[12]));
                empJoinDep.setProduct_code(values[13]);
                empJoinDep.setProduct_cata(empJoinDep.getCPFLResult(values[14]));
                empJoinDep.setProduct_way(empJoinDep.getResult(values[23]));
                empJoinDep.setExchange(values[16]);
                empJoinDep.setDeal_num(values[27]);
                empJoinDep.setDeal_sum(values[28]);
                empJoinDep.setDeal_price(values[29]);
                empJoinDep.setCurrency(values[31]);
                empJoinDep.setFund_balance(values[41]);
                empJoinDep.setShare_balance(values[42]);
                empJoinDep.setJsrq(values[45]);
                empJoinDep.setDeal_time(values[46]);
                empJoinDep.setYsje(values[44]);
                empJoinDep.setType(empJoinDep.getcplxResult(values[15]));
                empJoinDep.setYsje("otc");
                context.write(new Text(empJoinDep.getLs_code()), empJoinDep);

            } else if(values.length==49)
            {
                empJoinDep.setLs_code(values[1]);


                empJoinDep.setClientcode(values[2]);

                empJoinDep.setShare_code(values[12]);
                empJoinDep.setFund_code(values[10]);

                empJoinDep.setExchange(values[16]);
                empJoinDep.setOrganization(values[4]);

                empJoinDep.setProduct_code(values[17]);
                empJoinDep.setProduct_name(values[18]);
                empJoinDep.setCurrency(values[25]);

                empJoinDep.setProduct_way(empJoinDep.getResult(values[23]));
                empJoinDep.setDeal_date(values[26]);
                empJoinDep.setDeal_num(values[28]);
                empJoinDep.setDeal_sum(values[29]);
                empJoinDep.setExchange(values[4]);


                empJoinDep.setFund_balance(values[40]);
                empJoinDep.setShare_balance(values[41]);

                empJoinDep.setType("基金");
                empJoinDep.setSystem_name("aboss");
                context.write(new Text(empJoinDep.getLs_code()), empJoinDep);
            }

           else {

                empJoinDep.setLs_code(values[1]);

            empJoinDep.setWt_code(values[3]);
            empJoinDep.setClientcode(values[4]);

            empJoinDep.setShare_code(values[8]);
            empJoinDep.setExchange(values[10]);
            empJoinDep.setFund_code(values[13]);
            empJoinDep.setProduct_way(empJoinDep.getResult(values[16]));
            empJoinDep.setCurrency(values[15]);
            empJoinDep.setOrganization(empJoinDep.getYybResult(values[17]));
            empJoinDep.setProduct_code(values[19]);
            empJoinDep.setProduct_name(values[20]);
            empJoinDep.setProduct_cata(empJoinDep.getLBResult(values[22]));
            empJoinDep.setDeal_date(values[24]);
            empJoinDep.setDeal_time(values[25]);
            empJoinDep.setDeal_bishi(values[27]);
            empJoinDep.setDeal_num(values[28]);
            empJoinDep.setDeal_price(values[29]);
            empJoinDep.setSb_date(values[26]);
            empJoinDep.setDeal_sum(values[32]);

            empJoinDep.setYsje(values[41]);
            empJoinDep.setYssl(values[52]);
            empJoinDep.setJsrq(values[57]);

            empJoinDep.setRzrq(values[58]);
                empJoinDep.setType("融资融券");
                empJoinDep.setSystem_name("rzrq");

            context.write(new Text(empJoinDep.getLs_code()), empJoinDep);
        }





        }
    }

    public static class MyReducer extends Reducer<Text, JGLS, NullWritable, JGLS> {

        @Override
        protected void reduce(Text key, Iterable<JGLS> values,
                              Context context)
                throws IOException, InterruptedException {

            for (JGLS val : values) {
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
        job.setMapOutputValueClass(JGLS.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(JGLS.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/rzrq/TJGMXLS");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/jgls5"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
