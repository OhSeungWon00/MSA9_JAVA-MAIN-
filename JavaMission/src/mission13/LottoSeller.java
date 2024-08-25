package mission13; // 수동 로또 번호 지정 시 1 ~ 45 값 초과 시 테스트 케이스 미적용, 추첨일 계산미적용

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

public class LottoSeller {

	static LottoMachine[] lotto = new LottoMachine[5];
	static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("몇 게임?");
		int n = sc.nextInt();
		int gamenum = 1; // 게임 몇번 째?

		while (n > 0) {

			System.out.println("[" + gamenum + "게임" + "]" + " " + "(1.자동 / 2.수동)"); // 각 번호 인스턴스 만들어서 저장 해야됨
			String choose = sc.next();
			// 1번 자동 고를 시 번호 자동 생성및 객체 생성
			if (choose.equals("1")) {
				int arr[] = new int[6];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = (int) (Math.random() * 45 + 1);
					for (int j = i - 1; j >= 0; j--) {
						if (arr[j] == arr[i]) {
							i--;
							break;
						}
					}

				}

				lotto[count++] = new LottoMachine(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], choose);

				for (int i : arr) {
					System.out.print(i + "  ");
				}
				System.out.println();

				// 2번 골랐을때 수동 번호 추첨 후 객체 생성
			} else if (choose.equals("2")) {
				System.out.println("1 : ");
				int first = sc.nextInt();
				System.out.println("2 : ");
				int second = sc.nextInt();
				System.out.println("3 : ");
				int third = sc.nextInt();
				System.out.println("4 : ");
				int fourth = sc.nextInt();
				System.out.println("5 : ");
				int fifth = sc.nextInt();
				System.out.println("6 : ");
				int sixth = sc.nextInt();

				lotto[count++] = new LottoMachine(first, second, third, fourth, fifth, sixth, choose); // 객체생성

				System.out.println(first + " " + second + " " + third + " " + fourth + " " + fifth + " " + sixth + " ");

			} else {
				System.out.println("올바른 번호를 눌러주세요");
				continue;
			}

			gamenum++;
			n--;

		}
		System.out.println();

		// 현재 날짜 지정 및 추첨일, 지급기한 날짜 계산
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
		String now = sdf.format(cal.getTime());

		// 추첨일 계산 -- 토요일 오후 9시 이전이면 그 주 토요일 9시로, 이후면 차주 토요일 9시로......... 모르겠다.

		// 지급기한 계산 -- 1년하고 1일 더한 날짜
		cal.add(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.YEAR, 1);
		String untilday = sdf.format(cal.getTime());

		System.out.println("############ 인생역전 Lottoria #######################");
		System.out.println("발행일 :   \t" + now);
		System.out.println("추첨일 :   \t" + now); // 아직
		System.out.println("지급기한 :  \t" + untilday);
		System.out.println("--------------------------------------------------");

		// 숫자 한자리면 앞에 0 붙이기 ex) 1 --> 01 미적용.
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + " " + (lotto[i].choose.equals("1") ? "자   동\t" : "수   동\t") + lotto[i].first
					+ "\t" + lotto[i].second + "\t" + lotto[i].third + "\t" + lotto[i].fourth + "\t" + lotto[i].fifth
					+ "\t" + lotto[i].sixth);

		}
		System.out.println("--------------------------------------------------");
		System.out.println("금액 \t\t\t\t" + count * 1000 + "원");
		System.out.println("####################################################");
		System.out.println();
		System.out.println();

		// 당첨 번호 지정

		int arr[] = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45 + 1);
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				}
			}

		}
		// 보너스 번호 지정
		System.out.print("당첨 번호 : ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
		int bonus = (int) (Math.random() * 45 + 1);
		System.out.println("보너스 번호 : " + bonus);
		System.out.println();

		// 당첨 결과 조회.
		int result = 0;
		String arr2[] = new String[count];
		for (int i = 0; i < count; i++) {
			if (lotto[i].first == arr[i] || lotto[i].first == bonus) {
				result++;
			}
			if (lotto[i].second == arr[i] || lotto[i].second == bonus) {
				result++;
			}
			if (lotto[i].third == arr[i] || lotto[i].third == bonus) {
				result++;
			}
			if (lotto[i].fourth == arr[i] || lotto[i].fourth == bonus) {
				result++;
			}
			if (lotto[i].fifth == arr[i] || lotto[i].fifth == bonus) {
				result++;
			}
			if (lotto[i].sixth == arr[i] || lotto[i].sixth == bonus) {
				result++;
			}

			if (result == 6) {
				arr2[i] = "1등";
			} else if (result == 5) {
				arr2[i] = "3등";
			} else if (result == 4) {
				arr2[i] = "4등";
			} else if (result == 3) {
				arr2[i] = "5등";
			} else {
				arr2[i] = "낙첨";
			}
			result = 0;
		}

		System.out.println("################## 당첨결과# #########################");
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + " " + (lotto[i].choose.equals("1") ? "자   동\t" : "수   동\t") + lotto[i].first
					+ "\t" + lotto[i].second + "\t" + lotto[i].third + "\t" + lotto[i].fourth + "\t" + lotto[i].fifth
					+ "\t" + lotto[i].sixth + "\t" + "(" + arr2[i] + ")");
		}

		System.out.println("####################################################");

		sc.close();

	}
}
