package mapred.basic;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CommentWordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	static final IntWritable outputVal = new IntWritable(1);
	
	Text outputkey = new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		StringTokenizer st = new StringTokenizer(value.toString());
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			outputkey.set(token);
			context.write(outputkey, outputVal);
		}
	}
	
}
