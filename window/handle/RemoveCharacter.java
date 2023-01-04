package window.handle;

public class RemoveCharacter {

	public static void main(String[] args) {
		String str="vino@#";
		String str1 = str.replaceAll("[^a-z0-9]", "");
		System.out.println(str1);
		
		String a="abc" ,b="def";
		a=a+b;
		b=a.substring(0,a.length()-b.length());
		a=a.substring(b.length());
		System.out.println(a+""+b);
		
		int num=15;
		for (int i = 1; i <=num; i++) {
			if (num%i==0) {
				System.out.println(i);
			}
			
		}

	}

}
