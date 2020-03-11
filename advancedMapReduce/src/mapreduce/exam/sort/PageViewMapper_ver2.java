package mapreduce.exam.sort;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_ver2 extends Mapper<LongWritable, Text, MyKey, Text>{
	MyKey outputkey = new MyKey();//output key
	Text outputVal = new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, MyKey, Text>.Context context)
			throws IOException, InterruptedException {
			String line = value.toString();
			String[] data = line.split("\\t");
			outputkey.setProductId(data[2]);
			outputkey.setUserId(data[9]);
			outputVal.set(data[9]);
			context.write(outputkey, outputVal);
	}
}
