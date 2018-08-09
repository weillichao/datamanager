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

public class wTinfoMR {



    public static class MyMapper extends Mapper<LongWritable, Text,  Text, wtinfo> {
        private wtinfo empJoinDep;

        {
            try {
                empJoinDep = new wtinfo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] values = value.toString().split("\t");
         /* if(values.length==97)
             {
                empJoinDep.setWt_code(values[1]);
                 empJoinDep.setClientcode(values[6]);
                 empJoinDep.setClientname(values[7]);
                 empJoinDep.setOrganization(values[8]);
                 empJoinDep.setFund_code(values[16]);
                    empJoinDep.setWt_cata(empJoinDep.getYWDMResult(values[17]));
                 empJoinDep.setShare_code(values[15]);
                 empJoinDep.setProduct_code(values[22]);
                 empJoinDep.setProduct_name(values[23]);
                 empJoinDep.setWt_date(values[25]);
                 empJoinDep.setWt_time(values[27]);
                 empJoinDep.setSb_date(values[26]);
                 empJoinDep.setWt_num(values[28]);
                 empJoinDep.setWt_amount(values[31]);
                 empJoinDep.setWt_price(values[29]);

                 empJoinDep.setDdlx(values[19]);
                 empJoinDep.setCurrency(values[54]);
                 empJoinDep.setDeal_date(values[60]);
                 empJoinDep.setDeal_amount(values[66]);
                 empJoinDep.setDeal_time(values[89]);


                 empJoinDep.setDeal_price(values[90]);

                 empJoinDep.setDeal_num(values[67]);
                 empJoinDep.setType("金融产品");

                 empJoinDep.setSystem_name("otc");

                 context.write(new Text(empJoinDep.getWt_code()), empJoinDep);

             }

            if(values.length==52)
             {
                empJoinDep.setWt_code(values[1]);
                 empJoinDep.setClientcode(values[3]);
                 empJoinDep.setClientname(values[4]);
                 empJoinDep.setOrganization(values[5]);
                 empJoinDep.setFund_code(values[13]);

                 empJoinDep.setShare_code(values[11]);
                 empJoinDep.setProduct_code(values[17]);
                 empJoinDep.setProduct_name(values[18]);
                 empJoinDep.setWt_date(values[20]);
                 empJoinDep.setWt_time(values[21]);
                 empJoinDep.setSb_date(values[44]);
                 empJoinDep.setWt_num(values[22]);
                 empJoinDep.setWt_price(values[23]);
                 //empJoinDep.setWt_price(values[31]);
                 empJoinDep.setWt_way(values[41]);

                 empJoinDep.setWt_cata(empJoinDep.getYWDMResult(values[15]));

                 empJoinDep.setCurrency(values[47]);
                // empJoinDep.setOrder_abstract(values[51]);
                 empJoinDep.setType("基金");

                 empJoinDep.setSystem_name("aboss");
                 context.write(new Text(empJoinDep.getWt_code()), empJoinDep);

             }*/
            {
                 empJoinDep.setWt_code(values[2]);
                 empJoinDep.setClientcode(values[4]);
                 empJoinDep.setClientname(values[5]);
                 empJoinDep.setShare_code(values[10]);
                 empJoinDep.setExchange(values[9]);
                 empJoinDep.setCurrency(values[15]);

                 empJoinDep.setOrganization(empJoinDep.getYybResult(values[6]));

                 empJoinDep.setProduct_code(values[14]);
                 empJoinDep.setProduct_name(values[15]);

                 empJoinDep.setWt_cata(empJoinDep.getLBResult(values[11]));
                 empJoinDep.setDdlx(empJoinDep.getDdlxResult(values[17] + "210"));


                 empJoinDep.setWt_num(values[21]);
                 //empJoinDep.setWt_cata(values[22]);
                 empJoinDep.setWt_date(values[25]);
                 empJoinDep.setWt_time(values[25]);
                 empJoinDep.setSb_date(values[28]);
                 empJoinDep.setSb_time(values[29]);
                 empJoinDep.setSb_result(values[35]);
                 empJoinDep.setDeal_amount(values[38]);
                 empJoinDep.setDeal_date(values[42]);

                 empJoinDep.setDeal_num(values[37]);
                 empJoinDep.setDeal_price(values[41]);


                 empJoinDep.setCurrency(values[43]);

                 empJoinDep.setFund_code(values[47]);

                 empJoinDep.setType("融资融券");

                 empJoinDep.setSystem_name("rzrq");

                 context.write(new Text(empJoinDep.getWt_code()), empJoinDep);
             }





        }
    }

    public static class MyReducer extends Reducer<Text,wtinfo, NullWritable, wtinfo> {

        @Override
        protected void reduce(Text key, Iterable<wtinfo> values,
                              Context context)
                throws IOException, InterruptedException {

            for (wtinfo val : values) {
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
        job.setMapOutputValueClass(wtinfo.class);
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(wtinfo.class);
        //要处理的数据输入与输出地址
        FileInputFormat.setInputPaths(job, "hdfs://n1:8020/user/rzrq/NEW_TWTLS");
        FileOutputFormat.setOutputPath(job, new Path("hdfs://n1:8020/user/mr/wtlsresult12"));
        boolean res = job.waitForCompletion(true);
        System.exit(res ? 0 : 1);
    }
}
