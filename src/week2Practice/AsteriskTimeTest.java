package week2Practice;

public class AsteriskTimeTest {
	
	//concatenate String
	public static String repeat1(char c, int i) {
		long startTime = System.currentTimeMillis();
		String s = "";
		for (int j = 0; j < i; j++) {
			s+= c;
		}
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("repeat1 Time elapsed: " + timeElapsed);
		return s;
	}
	
	//append using StringBuilder
	public static String repeat2(char c, int i) {
		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < i; j++) {
			sb.append(c);
		}
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("repeat2 Time elapsed: " + timeElapsed);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing repeat1");
		System.out.println(repeat1('*', 40));
		System.out.println("Testing repeat2");
		System.out.println(repeat2('*', 40));
	}

}
