package tencentseven;

import org.junit.Test;

public class test {
	public static void main(String[] args) {
		Seven_2 obj = new Seven_2();
		obj.push(-3);
		obj.push(0);
		obj.push(2);
		obj.push(-2);
		obj.push(12);
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		System.out.println(param_3);
		System.out.println(param_4);

	}
	
	@Test
	public void testseven() throws Exception {
		
		Seven_2 obj = new Seven_2();
		obj.push(-3);
		obj.push(0);
		obj.push(2);
		obj.push(-2);
		obj.push(12);
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		System.out.println(param_3);
		System.out.println(param_4);
		
	}
	

}
