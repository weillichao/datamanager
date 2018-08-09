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


import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class positionMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, positionInfo> {
        private positionInfo empJoinDep;
        int mark=1;

        {
            try {
                empJoinDep = new positionInfo();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");

            /*if (values.length == 41&&values[0].length()>8 ) {

                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[1]);
                empJoinDep.setOrganzisition(empJoinDep.getYybResult(values[2]));
                empJoinDep.setOrganzisition_code(values[2]);
                empJoinDep.setExchange(values[5]);
                empJoinDep.setExchange(empJoinDep.getjysResult(values[5]));
                empJoinDep.setShare_code(values[6]);
                empJoinDep.setProduct_code(values[8]);
                empJoinDep.setProduct_name(values[10]);
                empJoinDep.setCurrency(values[12]);
                empJoinDep.setProduct_num(values[13]);
                empJoinDep.setOpendate(values[28]);
                empJoinDep.setChangedate(values[29]);
                empJoinDep.setBuy_num(values[31]);
                empJoinDep.setBuy_price(values[30]);
                empJoinDep.setSale_num(values[35]);
                empJoinDep.setSale_price(values[34]);
                empJoinDep.setCost(values[39]);
                empJoinDep.setProfit(values[40]);
                empJoinDep.setNew_sale(values[16]);

                empJoinDep.setBuy_wt_today(values[18]);
                empJoinDep.setSale_wt_today(values[19]);
                empJoinDep.setBuy_num_today(values[20]);
                empJoinDep.setSale_num_today(values[23]);
                empJoinDep.setBuy_price_today(values[26]);
                empJoinDep.setSale_price_today(values[27]);

                empJoinDep.setRecord_date("20170321");
                empJoinDep.setTablename("zq");
                empJoinDep.setProductType("rzrq");
                empJoinDep.setSystem_name("rzrq");
                context.write(value, empJoinDep);
            }

            if (values.length == 22) {
                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[1]);
                empJoinDep.setFund_num(values[2]);
                empJoinDep.setShare_code(values[2]);
                empJoinDep.setProduct_code(values[4]);
                empJoinDep.setProduct_name(values[5]);
                empJoinDep.setProduct_num(values[7]);
                empJoinDep.setNew_sale(values[10]);
                empJoinDep.setOpendate(values[11]);
                empJoinDep.setChangedate(values[12]);
                empJoinDep.setCost(values[13]);
                empJoinDep.setProfit(values[14]);
                empJoinDep.setProductType("fund");
                empJoinDep.setOrganzisition(empJoinDep.getYybResult(values[17]));
                empJoinDep.setOrganzisition_code(values[17]);
                empJoinDep.setCurrency(values[21]);
                empJoinDep.setTablename("jj");
                empJoinDep.setSystem_name("aboss");
                context.write(value, empJoinDep);
            }


            if (values.length == 17) {
                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[1]);
                empJoinDep.setShare_code(values[2]);
                empJoinDep.setExchange(values[3]);
                empJoinDep.setExchange_name(empJoinDep.getjysResult(values[3]));
                empJoinDep.setCurrency(values[6]);
                empJoinDep.setProduct_code(values[4]);


                empJoinDep.setOpendate(values[8]);
                empJoinDep.setChangedate(values[9]);
                empJoinDep.setProduct_num(values[10]);
                empJoinDep.setOrganzisition(empJoinDep.getYybResult(values[14]));
                empJoinDep.setOrganzisition_code(values[14]);
                empJoinDep.setProductType("持仓历史");
                empJoinDep.setSystem_name("aboss");

                context.write(value, empJoinDep);
            }





            if (values.length == 41&&values[0].length()<8 )
            {
                empJoinDep.setCode(values[5]);
                empJoinDep.setName(values[6]);
                empJoinDep.setShare_code(values[7]);
                empJoinDep.setExchange(values[11]);
                empJoinDep.setExchange_name(empJoinDep.getotc_jysResult(values[11]));
                empJoinDep.setCatagory(empJoinDep.getCPFLResult(values[12]));
                empJoinDep.setProduct_num(values[14]);
                empJoinDep.setProduct_code(values[4]);
                empJoinDep.setCost(values[17]);
                empJoinDep.setNew_sale(values[18]);




                empJoinDep.setOpendate(values[20]);
                empJoinDep.setChangedate(values[19]);
                empJoinDep.setUpdate_date(values[32]);



                empJoinDep.setOrganzisition(empJoinDep.getorgResult(values[1]));
                empJoinDep.setOrganzisition_code(values[1]);

                empJoinDep.setProductType("金融产品持仓");
                empJoinDep.setSystem_name("otc");
                context.write(value, empJoinDep);
            }
            if (values.length == 20 )
            {
                empJoinDep.setCode(values[3]);
                empJoinDep.setName(values[4]);
                empJoinDep.setShare_code(values[5]);
                empJoinDep.setProduct_code(values[0]);
                empJoinDep.setCatagory(empJoinDep.getCPFLResult(values[6]));
                empJoinDep.setProduct_num(values[7]);

                empJoinDep.setCost(values[9]);
                empJoinDep.setProfit(values[19]);
                empJoinDep.setNew_sale(values[10]);


                empJoinDep.setOpendate(values[12]);
                empJoinDep.setChangedate(values[11]);
                empJoinDep.setUpdate_date(values[13]);



                empJoinDep.setOrganzisition(empJoinDep.getorgResult(values[1]));
                empJoinDep.setOrganzisition_code(values[1]);

                empJoinDep.setProductType("金融产品持仓历史");
                empJoinDep.setSystem_name("otc");
                context.write(value, empJoinDep);
            }*/


            {
                empJoinDep.setCode(values[0]);
                empJoinDep.setName(values[1]);
                empJoinDep.setShare_code(values[2]);
                empJoinDep.setProduct_code(values[4]);
                empJoinDep.setCurrency(values[7]);

               // empJoinDep.setCatagory(empJoinDep.getCPFLResult(values[6]));
                empJoinDep.setProduct_num(values[10]);






                empJoinDep.setOpendate(values[8]);
                empJoinDep.setChangedate(values[9]);





                empJoinDep.setOrganzisition_code(values[11]);

                empJoinDep.setProductType("基金产品持仓历史");
                empJoinDep.setSystem_name("aboss");
                context.write(value, empJoinDep);
            }

        }
    }

    public static class MyReducer extends Reducer<Text, positionInfo, NullWritable, positionInfo> {

        @Override
        protected void reduce(Text key, Iterable<positionInfo> values,
                              Context context)
                throws IOException, InterruptedException {

            for (positionInfo val : values) {
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
        job.setMapOutputValueClass(positionInfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(positionInfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/aboss/TOF_JJFELS");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/test/outputposition7"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
