package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSCopyTest {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		
		FileSystem hdfs = null;
		
		FSDataInputStream hdfsin = null;
		FSDataOutputStream hdfsout = null;
		
		try {
			hdfs = FileSystem.get(conf);
			
			Path inputpath = new Path(args[0]);
			Path outputpath = new Path(args[1]);
			
			hdfsin = hdfs.open(inputpath);
			hdfsout = hdfs.create(outputpath);
			
			String data = hdfsin.readUTF();
			System.out.println("hdfs 데이터:"+data);
			
			hdfsout.writeUTF(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
