package org.example.atm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ATMRepository {
	private static final String FILE_PATH = "atm_balance.txt"; // 잔액 정보가 저장된 파일 경로

	public ATMRepository() {
		File file = new File(FILE_PATH);
		if (!file.exists()) {
			try {
				file.createNewFile();
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(Integer.toString(100000)); // 초기 잔액을 100000원으로 설정
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getCurrentBalanceFromFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			String st;
			while ((st = br.readLine()) != null) {
				return Integer.parseInt(st.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean updateCash(int amount) {
		int currentCash = getCurrentBalanceFromFile();
		if (currentCash == -1) {
			return false;
		}

		int newCash = currentCash + amount;
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
			writer.write(Integer.toString(newCash));
			writer.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}


