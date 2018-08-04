import java.util.Scanner;

////1에서부터 10까지 사이의 수를 입력받아 다음을 출력하는 프로그램
//
////1. if
//import java.util.Scanner;
//
//public class IfExam {
//
//	public static void main(String[] args) {
//
//		Scanner input = new Scanner(System.in);
//		int num;
//		System.out.println("행운의 숫자를 입력하세요.");
//		num = input.nextInt();
//
//		if (num == 1)
//			System.out.println("Bananas");
//		else if (num == 2)
//			System.out.println("Oranges");
//		else if (num == 3)
//			System.out.println("Pears");
//
//		if (num == 3)
//			System.out.println("Apples");
//		if (num == 4)
//			System.out.println("Apples");
//		if (num == 3)
//			System.out.println("plums");
//		if (num == 4)
//			System.out.println("plums");
//		
//		else if (num == 5)
//			System.out.println("Plums");
//		else if (num == 6)
//			System.out.println("Pineapples");
//		else if (num == 7)
//			System.out.println("");
//		else if (num > 7)
//			System.out.println("Nuts");
//
//	}
//
//}
//
////2. switch
//import java.util.Scanner;
//
//public class SwitchExam {
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int number;
//		System.out.print("행운의 숫자를 입력하세요:");
//		number = scan.nextInt();
//		switch(number) {
//		case 1:
//			System.out.println("Bananas");
//			break;
//		case 2:
//			System.out.println("Oranges");
//			break;
//		case 3:
//			System.out.println("Pears");
//			
//		case 4:
//			System.out.println("Apples");
//			
//		case 5:
//			System.out.println("Plums");
//			break;
//		case 6:
//			System.out.println("Pineapples");
//			break;
//		case 7:
//			System.out.println("");
//			break;		
//		default:
//			System.out.println("Nuts");
//			break;
//		}
//
//	}
//
//}
//
////3. if random
//public class RandomIfExam {
//
//	public static void main(String[] args) {
//		int num;
//		num = (int)(Math.random() * 10) + 1;
//
//		if (num == 1)
//			System.out.println("Bananas");
//		else if (num == 2)
//			System.out.println("Oranges");
//		else if (num == 3)
//			System.out.println("Pears");
//
//		if (num == 3)
//			System.out.println("Apples");
//		if (num == 4)
//			System.out.println("Apples");
//		if (num == 3)
//			System.out.println("plums");
//		if (num == 4)
//			System.out.println("plums");
//		
//		else if (num == 5)
//			System.out.println("Plums");
//		else if (num == 6)
//			System.out.println("Pineapples");
//		else if (num == 7)
//			System.out.println("");
//		else if (num > 7)
//			System.out.println("Nuts");
//
//	}
//
//}
//
////4. switch random
//import java.util.Scanner;
//
//public class RandomSwitchExam {
//
//	public static void main(String[] args) {
//		
//		int number;
//		number = (int)(Math.random() * 10) + 1;
//		
//		switch(number) {
//		case 1:
//			System.out.println("Bananas");
//			break;
//		case 2:
//			System.out.println("Oranges");
//			break;
//		case 3:
//			System.out.println("Pears");
//			
//		case 4:
//			System.out.println("Apples");
//			
//		case 5:
//			System.out.println("Plums");
//			break;
//		case 6:
//			System.out.println("Pineapples");
//			break;
//		case 7:
//			System.out.println("");
//			break;		
//		default:
//			System.out.println("Nuts");
//			break;		
//		}
//
//	}
//
//}
//
//
///////////////////////////////////////////////////////////////
//// 주말과제
//
////1. 두개의 정수와, 한개의 사칙연산(+,-,*,/) 을 입력받아서 계산의 값을 출력하세요.
//
//import java.util.Scanner;
//
//public class Sachic {
//
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		int num1;
//		int num2;
//		String calcul;
//
//		System.out.println("첫번째 수를 입력하시오.");
//		num1 = scan.nextInt();
//		
//		
//		System.out.println("두번째 수를 입력하시오.");
//		num2 = scan.nextInt();
//		
//		Scanner cal = new Scanner(System.in);
//
//		System.out.println("연산자를 선택하시오.");
//		calcul = cal.next();
//
//		switch (calcul) {
//		
//		case "1":
//			int result1 = num1 + num2;
//			System.out.println("두 수의 합은"+result1);
//			break;
//
//		case "2":
//			int result2 = num1 - num2;
//			System.out.println("두 수의 빼기는"+result2);
//			break;
//			
//		case "3":
//			int result3 = num1 * num2;
//			System.out.println("두 수의 곱은"+result3);
//			break;
//			
//		case "4":
//			int result4 = num1 / num2;
//			System.out.println("두 수의 나누기는"+result4);
//			break;
//			
//		default:
//			System.out.println("연산자를 잘못 선택하셨습니다.");
//			break;
//		}
//
//	}
//
//}
//

//2. 초 단위 시간을 입력받아서 시, 분, 초 단위로 변환하는 프로그램.

//3. 피보나치 수열 출력하기. 10번째까지.
//Ex) 0, 1, 1, 2, 3, 5, 8, 13, 21.......

//public static void main(String[] args) {
//
//		int n1 = 0;
//		int n2 = 1;
//		int n3;
//		
//		System.out.print(n1 + " ," + n2 + " ,");
//		
//		for (int i = 3; i <=10; i++) {
//			n3 = n1 + n2;
//			
//			System.out.print(n3 + " ,");
//			
//			n1 = n2; // n2 값을 n1으로 대입한다. 그러면 n1 값이 1이 된다.
//			n2 = n3; // n3 값을 n2로 대입한다. 그러면 n2 값이 2가 된다.
//		}
//
//	}
//
//3-2. 피보나치 수열에서 사용자가 입력한 정수(n) 까지의 합을 출력하세요.
//public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		int n;
//
//		int n1 = 0;
//		int n2 = 1;
//		int n3;		
//	   
//		System.out.println("입력값을 넣으세요.");
//		n = scan.nextInt();
//		
//		System.out.print(n1 + " ," + n2 + " ,");
//		
//		for (int i = 3; i <= n; i++) {
//			n3 = n1 + n2;
//			
//			System.out.print(n3 + " ,");
//			
//			n1 = n2; // n2 값을 n1으로 대입한다. 그러면 n1 값이 1이 된다.
//			n2 = n3; // n3 값을 n2로 대입한다. 그러면 n2 값이 2가 된다.
//		}
//
//4. 3개의 For 문을 이용해서 구구단(1~9단) 을 출력하세요
//Ex)   1단  2단  3단
//      4단  5단  6단
//      7단  8단  9단

//public static void main(String[] args) {
//
//	for (int a = 1; a <= 9; a= a + 3) {
//		for (int b = 1; b <= 9; b++) {
//			for (int c = a; c < a+3; c++)
//				System.out.print(c + "*" + b + "=" + b * c + "\t");
//			System.out.println();
//		}
//
//		System.out.println();
//
//	}
//
//}



//Welcome to hell
//1.
		// for (int a = 0; a < 6; a++) {
		// for (int b = 0; b < a; b++)
		//
		// System.out.print("*");
		//
		// System.out.println();
		//
		// }
		
//2.
//		for (int a = 5; a >= 1; a--) {
//			for (int b = 1; b < a; b++) {
//				System.out.print(" ");
//			}
//
//			for (int c = a; c <= 5; c++) {
//				System.out.print("*");
//
//			}
//			System.out.println();
//
//		}
		
//3.
//		for (int a = 1; a <= 5; a++) {
//			for (int b = 1; b > a; b--) {
//				System.out.print(" ");
//			}
//
//			for (int c = a; c <= 5; c++) {
//				System.out.print("*");
//
//			}
//			System.out.println();
//		}
//
//	}
//}
		
		
//4. 
//	int i, j;
//	for (i = 5; i >= 1; i--) {
//		for (j = 1; j <= 5 - i; j++)
//			System.out.printf(" ");

//		for (j = 1; j <= i; j++)
//			System.out.printf("*");

//	 System.out.printf("\n");


//5.		
//		for (int a = 0; a < 6; a++) {
//			for (int b = 0; b < a; b++)
//
//				System.out.print("*");
//
//			System.out.println();
//
//		}
//		for (int a = 1; a <= 5; a++) {
//			for (int b = 1; b > a; b--) {
//				System.out.print(" ");
//			}
//
//			for (int c = a; c <= 4; c++) {
//				System.out.print("*");
//
//			}
//			System.out.println();
//		}


//6.

//	for (int a = 5; a >= 2; a--) {
//		for (int b = 1; b < a; b++) {
//			System.out.print(" ");
//		}
//
//		for (int c = a; c <= 5; c++) {
//			System.out.print("*");
//
//		}
//		System.out.println();
//	}
//
//	{
//		int i, j;
//		for (i = 5; i >= 1; i--) {
//			for (j = 1; j <= 5 - i; j++)
//				System.out.printf(" ");
//			for (j = 1; j <= i; j++)
//				System.out.printf("*");
//			System.out.printf("\n");
//		}
//
//	}
//}
//}

//7. 
//			for (int a = 1; a <= 5; a++) {
//				for (int b = 1; b > a; b--) {
//					System.out.print(" ");
//				}
//
//				for (int c = a; c <= 5; c++) {
//					System.out.print("*");
//
//				}
//				System.out.println();
//			}
//			for (int a = 2; a < 6; a++) {
//				for (int b = 0; b < a; b++)
//
//					System.out.print("*");
//
//				System.out.println();
//
//			}

//8.
//	int i, j;
//	for (i = 5; i >= 1; i--) {
//		for (j = 1; j <= 5 - i; j++)
//			System.out.printf(" ");
//		for (j = 1; j <= i; j++)
//			System.out.printf("*");
//		System.out.printf("\n");
//	}
//	for (int a = 4; a >= 1; a--) 
//
//	{
//	for (int b = 1; b < a; b++) {
//		System.out.print(" ");
//	}
//
//	for (int c = a; c <= 5; c++) {
//		System.out.print("*");
//
//	}
//	System.out.println();
//}

//10.
//for (int i = 0; i < 5; i++) {
//	for (int j = 0; j <4-i; j++) {
//		System.out.printf("");
//	}
//	for (int j=0;j<2*i+1; j++) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//	
//}
//
//11.
//for (int i = 0; i < 5; i++) {
//	for (int j = 0; j < i; j++) {
//		System.out.printf(" ");
//	}
//	for (int j = 1; j < (5 - i)*2; j++) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//
//}
//}
//12.
//for (int i = 0; i < 5; i++) {
//	for (int j = 0; j < i; j++) {
//		System.out.printf(" ");
//	}
//	for (int j = 1; j < (5 - i) * 2; j++) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//
//}
//for (int i = 1; i < 5; i++) {
//	for (int j = 0; j < 4 - i; j++) {
//		System.out.printf(" ");
//	}
//	for (int j = 1; j < (i +1)*2; j++) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//
//}
//}
//13.
//for (int i = 0; i < 4; i++) {
//	for (int j = 0; j < i; j++) {
//		System.out.printf(" ");
//	}
//	for (int j = 0; j < 5; j++) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//
//}
//for (int i = 0; i < 5; i++) {
//	for (int j = 4; j > i; j--) {
//		System.out.printf(" ");
//	}
//	for (int j = 5; j > 0; j--) {
//		System.out.printf("*");
//	}
//	System.out.println("");
//	
//}
//}
//14.
//for (int i = 0; i < 5; i++) {
//
//	for (int j = 0; j < (5 + i); j++) {
//
//		System.out.print((j == (4 - i) || j == (4 + i) || i == 4) ? "*" : " ");
//
//	}
//
//	System.out.println();
//
//}
//15.
//		for (int i = 0; i < 5; i++) {
//
//			for (int j = 0; j < (5 + i); j++) {
//
//				System.out.print((j == (4 - i) || j == i) ? "*" : " ");
//
//			}
//
//			System.out.println();
//
//		}