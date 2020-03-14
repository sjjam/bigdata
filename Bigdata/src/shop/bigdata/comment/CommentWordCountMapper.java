package shop.bigdata.comment;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		String line = value.toString();
		String[] data = line.split(",");
		Pattern p = Pattern.compile("의|에|은|는|이|가");
		Matcher m = p.matcher(data[2]);
		
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			String str = m.group();
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		String[] result = sb.toString().split(" ");
		
		
		for (int i = 0; i < result.length; i++) {
			if(!result[i].equals("")) {
				outputkey.set(result[i]);
				context.write(outputkey, outputVal);
			}
		}
	}
	
}
