package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//하둡을 실행할때 사용자가 입력하는 옵션을 Mapper내부에서 사용할 수 있도록
//옵션이 어떤 값으로 입력되었냐에 따라 다른 작업을 할 수 있도록 처리
public class AirMultipleMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputkey = new Text();
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		/*
		 * -D 옵션과 함께 사용자가 입력하는 jobType이라는 옵션의 지정한 값을
		 *    추출해서 Mapper에 선언된 변수에 저장
		 */
	}

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get()>0) {
			String[] line = value.toString().split(",");
			if(line!=null & line.length>0) {
				if(!line[15].equals("NA") && Integer.parseInt(line[15])>0) {
					outputkey.set("departure, "+line[1]+"월");
					context.write(outputkey, outputVal);
				}else if(!line[14].equals("NA") && Integer.parseInt(line[14])>0) {
					outputkey.set("arrival, "+line[1]+"월");
					context.write(outputkey, outputVal);
				}else if(line[15].equals("NA")) {
					outputkey.set("dNA, "+line[1]);
					context.write(outputkey, outputVal);
				}else if(line[14].equals("NA")) {
					outputkey.set("aNA, "+line[1]);
					context.write(outputkey, outputVal);
				}
			}
		}
	}
}
