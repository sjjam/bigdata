package mapred.exam.stock.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);//output value
	Text outputkey = new Text();//output key
	//라인하나에 맵매소드 한번씩 출력
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {//key, value일때 첫줄의 key=0이므로 첫줄 문자열 다음부터 진행
			String[] line = value.toString().split(",");
			if(line!=null & line.length>0) {
				//년도, 상승마감
				String year = line[2].substring(0,4);
				double result = Double.parseDouble(line[6])-Double.parseDouble(line[3]);
				if(result>0) { //상승마감
					outputkey.set("up, "+year);
					context.write(outputkey, outputVal);
				}else if(result<0) {
					outputkey.set("down, "+year);
					context.write(outputkey, outputVal);
				}else {
					outputkey.set("equal, "+year);
					context.write(outputkey, outputVal);
				}
			}
		}
	}
}
