package guessNumber;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("数あてゲーム　開始!");

		while (true) {
			int tryNumber = 1;// 挑戦数
			// CP側に4つの乱数を用意+重複考慮
			Random rand = new Random();
			int cp_digit[] = new int[4];
			int count = 0;

			for (int i = 0; i < cp_digit.length; i++) {
				int duplicate_digit = rand.nextInt(10);
				for (int j = 0; j < cp_digit.length; j++) {
					if (cp_digit[j] == duplicate_digit) {
						count++;
					}
				}
				if (count > 0) {
					i--;
					count = 0;
					continue;
				} else {
					cp_digit[i] = duplicate_digit;
				}
			}
			System.out.println("");

			// ユーザー側に4つの数字を用意
			int[] user_digit = new int[4];
			System.out.println("0-9の数字を4つ入力してください");
			for (int k = 0; k < user_digit.length; k++) {
				user_digit[k] = new java.util.Scanner(System.in).nextInt();
			}
				System.out.println("あなたが入力した数字は以下ですね");
				System.out.print(user_digit[0]);
				System.out.print(user_digit[1]);
				System.out.print(user_digit[2]);
				System.out.print(user_digit[3]);
		
			// 判定処理
			int hit = 0;// 数字及び桁が一致
			int blow = 0; // 数字のみ一致

			System.out.println("");
			for (int i = 0; i < cp_digit.length; i++) {
				if (cp_digit[i] == user_digit[i]) {
					hit++;
				}
			}
			for (int i = 0; i < cp_digit.length; i++) {
				for (int k = 0; k < cp_digit.length; k++) {
					if (cp_digit[i] == user_digit[k]) {
						blow++;
					}
				}
			}

			// ゲーム終了処理
			if (hit == 4) {
				System.out.println("○");
				System.out.print("正解です。");
				System.out.println("あなたの挑戦回数は" + tryNumber + "回で正解しました");
				tryNumber++;
				break;
			} else if (blow < 4&&0<blow) {
				System.out.println("△");
			} else {
				System.out.println("×");
			}
		}
	}
}
