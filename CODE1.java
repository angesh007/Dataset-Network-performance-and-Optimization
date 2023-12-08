import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class SourceIPProtocolCount {
public static class SourceIPProtocolMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {
private final static IntWritable one = new IntWritable(1);
public void map(LongWritable key, Text value, Context context)
throws IOException, InterruptedException {
String[] fields = value.toString().split(",");
String sourceIP = fields[1];
String protocolName = fields[63];
String keyText;
if (protocolName.equals("HTTP")) {
keyText = sourceIP + "_HTTP";
} else if (protocolName.equals("HTTP_PROXY")) {
keyText = sourceIP + "_HTTP_PROXY";
} else if (protocolName.equals("SSL")) {
keyText = sourceIP + "_SSL";
} else if (protocolName.equals("GOOGLE")) {
keyText = sourceIP + "_GOOGLE";
} else {
return;
}
context.write(new Text(keyText), one);
}
}
public static class SourceIPProtocolReducer
extends Reducer<Text, IntWritable, Text, IntWritable> {
public void reduce(Text key, Iterable<IntWritable> values, Context context)
throws IOException, InterruptedException {
int sum = 0;
for (IntWritable value : values) {
sum += value.get();
}
context.write(key, new IntWritable(sum));
}
}
public static void main(String[] args) throws Exception {
Configuration conf = new Configuration();
Job job = new Job();
job.setJarByClass(SourceIPProtocolCount.class);
job.setMapperClass(SourceIPProtocolMapper.class);
job.setCombinerClass(SourceIPProtocolReducer.class);
job.setReducerClass(SourceIPProtocolReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(IntWritable.class);
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}
public static void main(String[] args) throws Exception {
Configuration conf = new Configuration();
Job job = new Job();
job.setJarByClass(SourceIPProtocolCount.class);
job.setMapperClass(SourceIPProtocolMapper.class);
job.setCombinerClass(SourceIPProtocolReducer.class);
job.setReducerClass(SourceIPProtocolReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(IntWritable.class);
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
} import java.io.IOException;
