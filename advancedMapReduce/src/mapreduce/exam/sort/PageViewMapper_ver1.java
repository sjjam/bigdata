package mapreduce.exam.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_ver1 extends Mapper<LongWritable, Text, MyKey, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	MyKey outputkey = new MyKey();//output key
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
			String line = value.toString();
			String[] data = line.split("\\t");
			outputkey.setProductId(data[2]);
			outputkey.setUserId(data[9]);
			context.write(outputkey, outputVal);
	}
}
