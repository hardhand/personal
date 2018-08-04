import java.util.Scanner;

//기본요금 배열, 전력양 요금 배열 두개 만들어서 사용

public class Elecbill {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("사용량을 입력하세요.");

		int basic = scan.nextInt(); // 기본요금 변수
		double bill = 0; // 요금합계 변수

		final int[] basic_b = { 410, 910, 1600, 3850, 7300, 12940 }; //기본요금 체계
		final double[] personal_b = { 60.7, 125.9, 187.9, 280.6, 417.7, 709.5 }; //전력량 요금체계

		if (basic <= 100) {
			bill = basic_b[0] + personal_b[0] * basic;
		} else if (basic <= 200) {
			bill = basic_b[1] + personal_b[0] * 100 
					+ personal_b[1] * (basic - 100);
		} else if (basic <= 300) {
			bill = basic_b[2] + personal_b[0] * 100 
					+ personal_b[1] * 100 
					+ personal_b[2] * (basic - 200);
		} else if (basic <= 400) {
			bill = basic_b[3] + personal_b[0] * 100 
					+ personal_b[1] * 100
					+ personal_b[2] * 100
					+ personal_b[3] * (basic - 300);
		} else if (basic <= 500) {
			bill = basic_b[4] + personal_b[0] * 100 
					+ personal_b[1] * 100 
					+ personal_b[2] * 100 
					+ personal_b[3] * 100 
					+ personal_b[4] * (basic - 400);
		} else {
			bill = basic_b[5] + personal_b[0] * 100 
					+ personal_b[1] * 100 
					+ personal_b[2] * 100 
					+ personal_b[3] * 100 
					+ personal_b[4] * 100 
					+ personal_b[5] * (basic - 500);

		}
		System.out.println(bill); // 사용량 출력
		System.out.println(bill + (bill * 0.1)); //사용량 + 부가세
		
	}

}
