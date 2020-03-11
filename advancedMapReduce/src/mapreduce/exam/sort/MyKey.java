package mapreduce.exam.sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;
//복합키를 정의 - 사용자정의 키(정렬할 기준을 컬럼으로 갖고 있는 객체)
//맵리듀스 프레임워크 내부에서 키와 value는 네트워크에서 주고 받는 값이므로
//네트워크 전송을 하기 위해 제공되는 Writable타입이어야 하므로
//WritableComparable을 상속받아 작성한다.
public class MyKey implements WritableComparable<MyKey>{

	private String productId;
	private String userId;
	
	public MyKey() {
		
	}

	public MyKey(String productId, String userId) {
		super();
		this.productId = productId;
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return (new StringBuffer()).append(productId).append(",").append(userId).toString();
	}

	//데이터를 쓰고 읽는 작업을 처리
	//데이터를 쓰기 - 직렬화
	//데이터를 읽기 - 역직렬화
	//하둡의 맵리듀스 내부에서 이런 작업을 처리할 수 있도록 구현된 메소드를 호출해서 처리한다.
	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, productId);
		WritableUtils.writeString(out, userId);
	}
	
	//역직렬화될때 호출
	@Override
	public void readFields(DataInput in) throws IOException {
		productId = WritableUtils.readString(in);
		userId = WritableUtils.readString(in);
	}

	//사용자가 만들어 놓은 키를 기준으로 정렬하기 위해서 비교하게 할 메소드
	//year로 비교 yaer가 같으면 month로 비교
	@Override
	public int compareTo(MyKey obj) {
		int result = productId.compareTo(obj.productId);
		if(result==0) {//year가 같다.
			result = userId.compareTo(obj.userId);
		}
		return result;
	}
	
}
