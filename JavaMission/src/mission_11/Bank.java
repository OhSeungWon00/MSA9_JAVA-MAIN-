package mission_11;

import java.util.Scanner;

public class Bank {

	static int count = 0;    //계좌 개수 카운
	static Account[] account = new Account[1000];  //Account 클래스객체를 만들 배열 1000개 생성
	static int magicKey = 1234;		//관리자 비밀번호

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int u = 0;    // 1이되면 종료

		do {

			System.out.println("===========================================");
			System.out.println("1. 계좌등록");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 계좌조회");
			System.out.println("5. 계좌목록");
			System.out.println("6. 종료");
			System.out.println("===========================================");
			System.out.println("입력 >> ");
			int input = sc.nextInt();

			switch (input) {

			case 1: // 계좌등록
				System.out.println("계좌등록을 실행합니다");
				System.out.println("계좌번호>> ");
				String accountNum = sc.next();
				System.out.println("예금주>> ");
				String name = sc.next();
				System.out.println("최초예금액>> ");
				int money = sc.nextInt();
				System.out.println("비밀번호>>");
				int passWord = sc.nextInt();

				account[count++] = new Account(accountNum, name, money, passWord);
				System.out.println(name + " 님의 계좌가 개설되었습니다.");
				break;

			case 2: // 입금
				System.out.println("============== 입금 ===============");
				System.out.println("계좌번호>> ");
				String accountnum = sc.next();
				System.out.println("입금액>> ");
				int sendMoney = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].getAccountNum().equals(accountnum)) {
						System.out.println(account[i].getName() + "님에게 입금하는 게 맞으십니까? ");
						System.out.println("1. 예");
						System.out.println("2. 아니오");
						System.out.println("입력>> ");
						int select = sc.nextInt();
						if (select == 1) {
							account[i].setMoney(sendMoney);
							System.out.println(account[i].getName() + "님의 계좌에 " + sendMoney + "원이 입금되었습니다.");
						} else {
							System.out.println("입금을 취소합니다.");
						}
					} else {
						System.out.println("해당 계좌가 존재하지 않습니다.");
					}
				}
				break;

			case 3: // 출금
				System.out.println("============== 출금 ===============");
				System.out.println("계좌번호>> ");
				String accountnum2 = sc.next();
				System.out.println("비밀번호>> ");
				int mypassword = sc.nextInt();
				System.out.println("출금액>> ");
				int outmoney = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].getAccountNum().equals(accountnum2) && account[i].getPassWord() == mypassword) {
						account[i].setMoney2(outmoney);
						System.out.println(account[i].getName() + "님의 계좌에 " + outmoney + "원이 출금되었습니다.");
					}else {
						System.out.println("계좌번호 또는 비밀번호를 확인해 주세요");
					}

				}
				break;

			case 4: // 계좌조회
				System.out.println("=================== 계좌조회 =======================");
				System.out.println("계좌번호>> ");
				String num3 = sc.next();
				System.out.println("비밀번호>> ");
				int password3 = sc.nextInt();

				for (int i = 0; i < count; i++) {
					if (account[i].accountNum.equals(num3) && account[i].passWord == password3) {
						System.out.println(account[i].name + "님의 계좌잔액은 " + account[i].money + "원 입니다.");
					} else {
						System.out.println("계좌번호 또는 비밀번호를 확인해주세요");
					}
				}
				break;

			case 5: // 계좌목록
				System.out.println("관리자 비밀번호>> ");
				int num = sc.nextInt();
				if (num == magicKey) {
					System.out.println("============== 계좌목록 ================");
					System.out.println("예금주\t계좌번호\t잔고");
					for (int i = 0; i < count; i++) {
						System.out.println(account[i].getName() + account[i].getAccountNum() + 
								+ account[i].getMoney());
					}
				} else {
					System.out.println("관리자 비밀번호가 다릅니다.");
				}
				break;

			case 6: // 종료
				System.out.println("시스템을 종료합니다.");
				u++;
				break;

			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
				break;
			} // switch문 종료
		} while (u <= 0); // do-while 루프 종료
		sc.close();
	} // main 메서드 종료
} // Bank 클래스 종료
